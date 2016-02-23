package com.crawl.spring.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.crawl.command.crud.IFotoCRUDManager;
import com.crawl.command.crud.IRepositorioCRUDManager;
import com.crawl.jpa.dao.IPropiedadDao;
import com.crawl.jpa.data.AsociacionFotos;
import com.crawl.jpa.data.Foto;
import com.crawl.jpa.data.Repositorio;
import com.crawl.spring.service.IBusiness;

@Component("crawlerBusiness")
@Service
public class CrawlerBusiness implements IBusiness{
	
	@Autowired
	private IPropiedadDao propiedadService;
	
	@Autowired
	private IRepositorioCRUDManager repositorioCRUD;
	
	@Autowired
	private IFotoCRUDManager fotoCRUD;
	
	@Override
	@Transactional
	public void scanRepositorios() throws Exception {
		final List<Repositorio> rList = repositorioCRUD.listarTodos();
		if (rList == null || rList.isEmpty()){
			return;
		}
		
		Foto foto = new Foto();
		foto.setDtFoto(new Date());
		foto.setTerminado(false);
		foto = fotoCRUD.guardar(foto);
		final List<AsociacionFotos> afList = new ArrayList<AsociacionFotos>();
		AsociacionFotos af = null;
//		for (Repositorio r : rList){
//			af = new AsociacionFotos();
//			af.setRepositorio(r);
//			final List<Categoria> cList = extractRepositoryCategories(r);
//			r.setCategorias(cList);
////			asocService.register(af);
//			af.setFoto(foto);
//			afList.add(af);
//		}
		foto.setAsociacionFotos(afList);;
		foto.setTerminado(true);
		foto = fotoCRUD.guardar(foto);
		
		/* Creamos la foto relativa al repositorio */
		
//		AsociacionFotos asoc = null;
//		for (Repositorio r : list){
//			asoc = new AsociacionFotos();
//			asoc.setRepositorio(r);
//			foto.getAsociacionFotos().add(asoc);
//		}
		
		
	}
	
//	@Transactional
//	public List<Categoria> extractRepositoryCategories(Repositorio r) throws Exception{
//		final List<Propiedad> pList = propiedadService.findByRepository(r);
//		if (pList == null || pList.isEmpty()) 
//			throw new Exception("No properties defined for repository "+r.getUrl());
//		final List<Categoria> cList = new ArrayList<Categoria>();
//		final Document doc = Jsoup.connect(r.getUrl()).get();
//		for (Propiedad p : pList){
//			if(!p.getName().startsWith(Constants.Prefixes.Properties.CATEGORY_STARTSWITH)) continue;
//			else{
//				Elements categories = doc.select(p.getValue());
//				Categoria c;
//				for(Element category: categories){
//					c = new Categoria ();
//					c.setUrl(r.getRoot()+category.attr("href").replace("&amp;", "&&"));
//					c.setName(category.text());
//					cList.add(c);
//				}
//			}
//		}
//		
//		
//		return cList;
//	}


}
