package com.crawl.beans.impl;

import java.io.IOException;
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

import com.crawl.command.business.IScannerManager;
import com.crawl.command.crud.IRepositorioCRUDManager;
import com.crawl.jpa.data.Repositorio;
import com.crawl.jpa.data.Sustitucion;

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
	private IScannerManager scanner;
	
	@PostConstruct
	public void init(){
		reload();
	}
	
	public void reload (){ list = repositorioCRUDManager.listarTodos(); element = null;}	
	
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
	
	public void configure (){
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
	
	public void replacement(Repositorio pRepositorio){
		element = pRepositorio;
		if (element.getSustituciones() == null){
			element.setSustituciones(new ArrayList<Sustitucion>());
		}
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dlgSustitucionesRepositorio').show();");
	}
	
	public void closeReplacement (){
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dlgSustitucionesRepositorio').hide();");
		reload();
	}
	

	public void scanAll(){
		try {
			scanner.escanearTodosRepositorios();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Repositorios escaneados correctamente."));
		} catch (IOException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Fallo al escanear los repositorios."));
		} 
	}
	
	public void scan (Repositorio pRepositorio){ 
		try {
			scanner.escanearRepositorio(pRepositorio, null);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Repositorio "+pRepositorio.getName()+" escaneado correctamente."));
		} catch (IOException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Fallo al escanear el repositorio "+pRepositorio.getName()+"."));
		} 
	}

	/* GETTERS Y SETTERS */
	public List<Repositorio> getList() { return list; }
	public void setList(List<Repositorio> list) { this.list = list; }
	public Repositorio getElement() { return element; }
	public void setElement(Repositorio element) { this.element = element; }

}
