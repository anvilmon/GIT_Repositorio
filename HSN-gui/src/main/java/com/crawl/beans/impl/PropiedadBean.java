package com.crawl.beans.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;

import com.crawl.beans.ITableBean;
import com.crawl.command.crud.IPropiedadCRUDManager;
import com.crawl.jpa.AbstractEntity;
import com.crawl.jpa.data.Propiedad;

@ManagedBean(name="propiedadBean")
@SessionScoped
public class PropiedadBean implements Serializable, ITableBean{

	private static final long serialVersionUID = 6926554498905067989L;

	private Propiedad propiedad;
	private List<Propiedad> listPropiedad;
	
	@Autowired
	private IPropiedadCRUDManager propiedadCRUD;
	
	@PostConstruct
	public void init(){
		reload();
	}
	
	public Propiedad getPropiedad() {
		return propiedad;
	}
	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}
	public List<Propiedad> getListPropiedad() {
		return listPropiedad;
	}
	public void setListPropiedad(List<Propiedad> listPropiedad) {
		this.listPropiedad = listPropiedad;
	}
	
	public void reload(){
		listPropiedad = propiedadCRUD.listarTodos();
		propiedad = new Propiedad();
	}
	
	public void register() {
		try{
			if(propiedad.getRepositorio() == null){
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Must select a repository..."));
				return;
			}
			propiedadCRUD.guardar(propiedad);
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The Property "+propiedad.getName()+" Is Registered Successfully"));
			System.out.println(propiedad.toString());
			propiedad = new Propiedad();
			reload();
		}catch(Exception e){
			System.out.println(e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("There has been an error registering data."));
		}
	}
	

	public void onRowEdit(RowEditEvent event) {
		propiedad = (Propiedad) event.getObject();
		register();
//        FacesMessage msg = new FacesMessage("Property Edited", ((Propiedad) event.getObject()).getName());
//        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
	public void onRowCancel(RowEditEvent event) {
		reload();
//        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Propiedad) event.getObject()).getName());
//        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
	public void onRowDelete(AbstractEntity p){
		propiedadCRUD.eliminar((Propiedad)p);
		reload();
	}

	@Override
	public void onRowCreate() {
		final Propiedad p = new Propiedad ();
		final FacesContext context = FacesContext.getCurrentInstance();
		final RepositorioBean bean = context.getApplication().evaluateExpressionGet(context, "#{repositorioBean}", RepositorioBean.class);
		p.setRepositorio(bean.getLstRepositorios().get(0));
		listPropiedad.add(p);
	}
}
