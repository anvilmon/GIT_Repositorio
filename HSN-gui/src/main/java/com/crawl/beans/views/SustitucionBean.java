package com.crawl.beans.views;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.crawl.command.crud.ISustitucionCRUDManager;
import com.crawl.jpa.data.Repositorio;
import com.crawl.jpa.data.Sustitucion;

@ManagedBean(name="sustitucionBean")
@ViewScoped
@Controller
public class SustitucionBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ISustitucionCRUDManager sustitucionCRUDManager;
	
	private Repositorio repositorio;
	private List<Sustitucion> list;
	private Sustitucion element;
	
	@PostConstruct
	public void init() { reload(); }
	
	/* BUSINESS */
	protected void reload(){
		if (repositorio != null ){
			list = sustitucionCRUDManager.listarParaRepositorio(repositorio); 
		}
		element = null; 
	}
	
	public void save() { 
		element.setRepositorio(repositorio);
		sustitucionCRUDManager.guardar(element);
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dlgNuevaSustitucion').hide();");
		reload();
		context.execute("PF('dlgSustitucionesRepositorio').show();");
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sustitución guardada correctamente"));
	}
	
	public void cancel() { 	
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dlgNuevaSustitucion').hide();");
		reload();
		context.execute("PF('dlgSustitucionesRepositorio').show();");
	}

	public void delete(Sustitucion pSustitucion) { 
		sustitucionCRUDManager.eliminar(pSustitucion);
		reload();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sustitución eliminada correctamente"));
	}
	
	public void edit(Sustitucion pSustitucion){
		element = pSustitucion;
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dlgNuevaSustitucion').show();");
	}
	
	public void create(){
		element = new Sustitucion();
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dlgNuevaSustitucion').show();");
	}
	
	/* GETTERS y SETTERS */
	public List<Sustitucion> getList() { return list; }
	public void setList(List<Sustitucion> list) { this.list = list; }
	public Sustitucion getElement() { return element; }
	public void setElement(Sustitucion element) { this.element = element; }

	public Repositorio getRepositorio() {
		return repositorio;
	}

	public void setRepositorio(Repositorio repositorio) {
		this.repositorio = repositorio;
		reload();
	}
}
