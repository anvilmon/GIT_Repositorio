package com.crawl.beans.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.crawl.command.crud.ICatPropiedadCRUDManager;
import com.crawl.command.crud.IRepositorioCRUDManager;
import com.crawl.jpa.data.CatPropiedad;
import com.crawl.jpa.data.Propiedad;
import com.crawl.jpa.data.Repositorio;

@ManagedBean(name="repositorioBean")
@ViewScoped
@Controller
public class RepositorioBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Repositorio> list;
	private Repositorio element;
	
	@Autowired
	private IRepositorioCRUDManager repositorioCRUDManager;
	@Autowired
	private ICatPropiedadCRUDManager catPropiedadCRUDManager;
	@PostConstruct
	public void init(){
		reload();
	}
	
	public void reload (){ list = repositorioCRUDManager.listarTodos(); element = null; }	
	
	public void save() {
		repositorioCRUDManager.guardar(element);
		reload();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Repositorio guardado correctamente."));
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dlgEditRepositorio').hide();");
		context.execute("PF('dlgConfigRepositorio').hide();");
	}
	
	public void edit (Repositorio pRepositorio){
		element = pRepositorio;
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dlgEditRepositorio').show();");
	}
	
	public void configure (Repositorio pRepositorio){
		element = pRepositorio;
		final List<CatPropiedad> cps = catPropiedadCRUDManager.listarTodos();
		if (element.getPropiedades() == null || element.getPropiedades().isEmpty()) {
			element.setPropiedades(new ArrayList<Propiedad>());
			Propiedad p = null;
			for (CatPropiedad cp : cps){
				p = new Propiedad();
				p.setRepositorio(element);
				p.setTipoPropiedad(cp);
				p.setSelector("");
				element.getPropiedades().add(p);
			}
		}else if (element.getPropiedades().size() < cps.size()){
			for (CatPropiedad cp : cps){
				boolean flag = false;
				for (Propiedad p : element.getPropiedades()){
					if (p.getTipoPropiedad().getId() == cp.getId()){
						flag = true ;
						break;
					}
				}
				if (!flag){
					Propiedad p = new Propiedad();
					p.setRepositorio(element);
					p.setTipoPropiedad(cp);
					p.setSelector("");
					element.getPropiedades().add(p);
				}
			}
		}
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dlgConfigRepositorio').show();");
	}
	
	public void create (){
		element = new Repositorio();
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dlgEditRepositorio').show();");
	}
	
	public void cancel() { 	
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dlgEditRepositorio').hide();");
		context.execute("PF('dlgConfigRepositorio').hide();");
		reload();
	}
	
	public void changeStatus (Repositorio pRepositorio){
		pRepositorio.setActive(!pRepositorio.isActive());
		repositorioCRUDManager.guardar(pRepositorio);
		reload();
		if (pRepositorio.isActive()) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Repositorio activado correctamente."));
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Repositorio desactivado correctamente."));
		}
	}

	public void scanAll() throws Exception{
		
	}
	
	public void scan (Repositorio pRepositorio){
		
	}

	/* GETTERS Y SETTERS */
	public List<Repositorio> getList() { return list; }
	public void setList(List<Repositorio> list) { this.list = list; }
	public Repositorio getElement() { return element; }
	public void setElement(Repositorio element) { this.element = element; }
}
