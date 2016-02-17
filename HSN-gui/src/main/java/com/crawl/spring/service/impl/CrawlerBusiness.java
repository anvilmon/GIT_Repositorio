package com.crawl.spring.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.crawl.jpa.data.AsociacionFotos;
import com.crawl.jpa.data.Categoria;
import com.crawl.jpa.data.EmptyEntity;
import com.crawl.jpa.data.Foto;
import com.crawl.jpa.data.Propiedad;
import com.crawl.jpa.data.Repositorio;
import com.crawl.spring.service.IBusiness;
import com.crawl.spring.service.IService;
import com.crawl.spring.service.PropiedadService;
import com.crawl.spring.service.command.ListarTodosRepositorioCommand;
import com.crawl.utils.Constants;

@Component("crawlerBusiness")
@Service
public class CrawlerBusiness extends AbstractBusiness implements IBusiness{
	
	@Autowired
	private PropiedadService propiedadService;
	
	@Autowired
	private ListarTodosRepositorioCommand listarTodosRepositorioCommand;
	
//	@Autowired
//	private IService<AsociacionFotos> asocService;
	
	@Override
	@Transactional
	public void scanRepositorios() throws Exception {
		final List<Repositorio> rList = listarTodosRepositorioCommand.execute(new EmptyEntity());
		if (rList == null || rList.isEmpty()){
			return;
		}
		
		final Foto foto = generateNewSnapshot();
		final List<AsociacionFotos> afList = new ArrayList<AsociacionFotos>();
		AsociacionFotos af = null;
		for (Repositorio r : rList){
			af = new AsociacionFotos();
			af.setRepositorio(r);
			final List<Categoria> cList = extractRepositoryCategories(r);
			r.setCategorias(cList);
//			asocService.register(af);
			af.setFoto(foto);
			afList.add(af);
		}
		foto.setAsociacionFotos(afList);;
		finishSnapshot(foto);
		
		/* Creamos la foto relativa al repositorio */
		
//		AsociacionFotos asoc = null;
//		for (Repositorio r : list){
//			asoc = new AsociacionFotos();
//			asoc.setRepositorio(r);
//			foto.getAsociacionFotos().add(asoc);
//		}
		
		
	}
	
	@Transactional
	public List<Categoria> extractRepositoryCategories(Repositorio r) throws Exception{
		final List<Propiedad> pList = propiedadService.findByRepository(r);
		if (pList == null || pList.isEmpty()) 
			throw new Exception("No properties defined for repository "+r.getUrl());
		final List<Categoria> cList = new ArrayList<Categoria>();
		final Document doc = Jsoup.connect(r.getUrl()).get();
		for (Propiedad p : pList){
			if(!p.getName().startsWith(Constants.Prefixes.Properties.CATEGORY_STARTSWITH)) continue;
			else{
				Elements categories = doc.select(p.getValue());
				Categoria c;
				for(Element category: categories){
					c = new Categoria ();
					c.setUrl(r.getRoot()+category.attr("href").replace("&amp;", "&&"));
					c.setName(category.text());
					cList.add(c);
				}
			}
		}
		
		
		return cList;
	}

	public IService<Foto> getFotoService() {
		return fotoService;
	}

	public void setFotoService(IService<Foto> fotoService) {
		this.fotoService = fotoService;
	}


}
