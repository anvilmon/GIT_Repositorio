package com.crawl.beans.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.crawl.command.crud.IPropiedadCRUDManager;
import com.crawl.jpa.data.Propiedad;

@ManagedBean(name="propiedadBean")
@SessionScoped
public class PropiedadBean implements Serializable{

	private static final long serialVersionUID = 6926554498905067989L;

	private Propiedad propiedad;
	private List<Propiedad> listPropiedad;
	
	@Autowired
	private IPropiedadCRUDManager manager;
	
	@PostConstruct
	public void init(){
		reload();
	}
	
	public void reload(){ listPropiedad = manager.listarTodos(); }
	
	public void save(Propiedad pPropiedad) {
		manager.guardar(pPropiedad);
		reload();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Propiedad correctamente guardada."));
	}
	
	public void delete(Propiedad pPropiedad) {
		manager.eliminar(pPropiedad);
		reload();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Propiedad correctamente eliminada."));
	}
	
	/* GETTERS Y SETTERS */
	public Propiedad getPropiedad() { return propiedad; }
	public void setPropiedad(Propiedad propiedad) { this.propiedad = propiedad; }
	public List<Propiedad> getListPropiedad() { return listPropiedad; }
	public void setListPropiedad(List<Propiedad> listPropiedad) { this.listPropiedad = listPropiedad; }
	

}
