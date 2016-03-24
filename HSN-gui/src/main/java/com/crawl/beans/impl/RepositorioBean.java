package com.crawl.beans.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.crawl.command.crud.IRepositorioCRUDManager;
import com.crawl.jpa.data.Repositorio;

@ManagedBean(name="repositorioBean")
@ViewScoped
@Controller
public class RepositorioBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Repositorio> lstRepositorios;
	private Repositorio repositorio;
	
	@Autowired
	private IRepositorioCRUDManager manager;
	
	@PostConstruct
	public void init(){
		reload();
	}
	
	public void reload (){ lstRepositorios = manager.listarTodos(); }	
	
	public void save(Repositorio pRepositorio) {
		manager.guardar(pRepositorio);
		reload();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Repositorio guardado correctamente."));
	}
	
	public void changeStatus (Repositorio pRepositorio){
		pRepositorio.setActive(!pRepositorio.isActive());
		manager.guardar(pRepositorio);
		reload();
		if (pRepositorio.isActive()) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Repositorio activado correctamente."));
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Repositorio desactivado correctamente."));
		}
	}

	public void scan(List<Repositorio> list) throws Exception{}
	
	/* GETTERS Y SETTERS */
	public List<Repositorio> getLstRepositorios() { return lstRepositorios; }
	public void setLstRepositorios(List<Repositorio> lstRepositorios) { this.lstRepositorios = lstRepositorios; }
	public Repositorio getRepositorio() { return repositorio; }
	public void setRepositorio(Repositorio repositorio) { this.repositorio = repositorio; }

}
