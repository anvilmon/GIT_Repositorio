package com.crawl.command.business.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crawl.command.business.IScannerManager;
import com.crawl.command.crud.IAsociacionFotoCRUDManager;
import com.crawl.command.crud.IFotoCRUDManager;
import com.crawl.command.crud.IRepositorioCRUDManager;
import com.crawl.jpa.data.Categoria;
import com.crawl.jpa.data.Foto;
import com.crawl.jpa.data.Repositorio;
import com.crawl.utils.Constants;

@Component("scannerManagerImpl")
public class ScannerManagerImpl implements IScannerManager{
	
	@Autowired
	private IRepositorioCRUDManager repositorioCRUDManager; 
//	@Autowired
//	private ICategoriaCRUDManager categoriaCRUDManager;
	@Autowired 
	private IFotoCRUDManager fotoCRUDManager;
	@Autowired
	private IAsociacionFotoCRUDManager asociacionFotoCRUDManager;
	
	@Override
	public void escanearTodosRepositorios() throws IOException {
		final List<Repositorio> lRepositorios = repositorioCRUDManager.listarRepositoriosActivos();
		Foto foto = fotoCRUDManager.generateNewFoto();
		for (Repositorio repositorio : lRepositorios){
			escanearRepositorio(repositorio, foto);
		}
	}

	@Override
	public void escanearRepositorio(Repositorio r, Foto foto) throws IOException {
		if (foto == null){
			foto = fotoCRUDManager.generateNewFoto();
		}
		if (r.getConfigRepositorio() == null || r.getConfigRepositorio().getId() == null) return;
		if (r.getCategorias() == null) r.setCategorias(new ArrayList<Categoria>());
		asociacionFotoCRUDManager.generarParaRepositorio(foto, r);
		final Document doc = Jsoup.connect(r.getUrl()).get();
		Elements lElements = doc.select(r.getConfigRepositorio().getSelectorCategoria());
		final List<Categoria> lCategoria = new ArrayList<Categoria>();
		Categoria cat = null;
		boolean enc = false;
		for(Element e: lElements){
			cat = new Categoria ();
			cat.setRepositorio(r);
			if (r.getConfigRepositorio().getAtributoUrl() != null && !Constants.Globals.EMPTY_STRING.equalsIgnoreCase(r.getConfigRepositorio().getAtributoUrl())){
				cat.setUrl(e.attr(r.getConfigRepositorio().getAtributoUrl()));
			}
			if (r.getConfigRepositorio().getAtributoNombre() != null && !Constants.Globals.EMPTY_STRING.equalsIgnoreCase(r.getConfigRepositorio().getAtributoNombre())){
				if (!Constants.Properties.TEXT.equalsIgnoreCase(r.getConfigRepositorio().getAtributoNombre())){
					cat.setName(e.attr(r.getConfigRepositorio().getAtributoNombre()));
				}else{
					cat.setName(e.text());
				}
			}
			if (r.getConfigRepositorio().getSelectorImagen() != null && !Constants.Globals.EMPTY_STRING.equalsIgnoreCase(r.getConfigRepositorio().getSelectorImagen())){
				e.select(r.getConfigRepositorio().getSelectorImagen());
				if (r.getConfigRepositorio().getAtributoImagen() != null && !Constants.Globals.EMPTY_STRING.equalsIgnoreCase(r.getConfigRepositorio().getAtributoImagen())){
					cat.setName(e.attr(r.getConfigRepositorio().getAtributoImagen()));
				}
			}
			enc = false;
			for (Categoria c : r.getCategorias()){
				if (c.getUrl().equalsIgnoreCase(cat.getUrl())){
					enc = true;
					break;
				}
			}
			if (!enc){
				r.getCategorias().add(cat);
			}
			lCategoria.add(cat);
		}
		repositorioCRUDManager.guardar(r);
		r = repositorioCRUDManager.buscarPorId(r.getId());
		for (Categoria c : r.getCategorias()){
			for(Categoria c2 : lCategoria){
				if (c.getUrl().equalsIgnoreCase(c2.getUrl())){
					asociacionFotoCRUDManager.generarParaCategoria(foto, c);
					break;
				}
			}
		}
		enc = false;
	}
}
