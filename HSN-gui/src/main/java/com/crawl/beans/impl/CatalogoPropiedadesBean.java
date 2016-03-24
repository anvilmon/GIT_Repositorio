package com.crawl.beans.impl;

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

import com.crawl.command.crud.ICatPropiedadCRUDManager;
import com.crawl.jpa.data.CatPropiedad;

@ManagedBean(name="catalogoPropiedadesBean")
@ViewScoped
@Controller
public class CatalogoPropiedadesBean implements Serializable{
	private static final long serialVersionUID = 1929214820560744757L;

	@Autowired
	private ICatPropiedadCRUDManager manager;
	
	private List<CatPropiedad> list;
	private CatPropiedad element = new CatPropiedad();
	@PostConstruct
	public void init() { reload(); }
	
	/* BUSINESS */
	protected void reload(){ list = manager.listarTodos(); element = null; }
	
	public void save() { 
		manager.guardar(element);
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dlgEditCatPropiedad').hide();");
		reload();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Propiedad maestra guardada correctamente"));
	}
	
	public void cancel() { 	
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dlgEditCatPropiedad').hide();");
		reload();
	}

	public void delete(CatPropiedad pCatPropiedad) { 
		manager.eliminar(pCatPropiedad);
		reload();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Propiedad maestra eliminada correctamente"));
	}
	
	public void edit(CatPropiedad pCatPropiedad){
		element = pCatPropiedad;
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dlgEditCatPropiedad').show();");
	}
	
	public void create(){
		element = new CatPropiedad();
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dlgEditCatPropiedad').show();");
	}
	
	/* GETTERS y SETTERS */
	public List<CatPropiedad> getList() { return list; }
	public void setList(List<CatPropiedad> list) { this.list = list; }
	public CatPropiedad getElement() { return element; }
	public void setElement(CatPropiedad element) { this.element = element; }


	
}
