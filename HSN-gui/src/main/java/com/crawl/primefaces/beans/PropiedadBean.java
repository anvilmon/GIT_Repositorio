package com.crawl.primefaces.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.RowEditEvent;

import com.crawl.jpa.data.EmptyEntity;
import com.crawl.jpa.data.Propiedad;
import com.crawl.jpa.data.Repositorio;
import com.crawl.spring.service.IService;

@ManagedBean(name="propiedadBean")
@SessionScoped
public class PropiedadBean implements Serializable, ITableBean{

	private static final long serialVersionUID = 6926554498905067989L;

	private Propiedad propiedad;
	private List<Propiedad> listPropiedad;
	
	@ManagedProperty("#{propiedadService}")
	private IService<Propiedad> service;
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
		listPropiedad = service.findAll();
		propiedad = new Propiedad();
	}
	
	public void register() {
		try{
			if(propiedad.getRepositorio() == null){
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Must select a repository..."));
				return;
			}
			service.register(propiedad);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The Property "+propiedad.getName()+" Is Registered Successfully"));
			System.out.println(propiedad.toString());
			propiedad = new Propiedad();
			reload();
		}catch(Exception e){
			System.out.println(e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("There has been an error registering data."));
		}
	}
	

	public IService<Propiedad> getService() {
		return service;
	}

	public void setService(IService<Propiedad> service) {
		this.service = service;
	}

	public void onRowEdit(RowEditEvent event) {
		propiedad = (Propiedad) event.getObject();
		register();
        FacesMessage msg = new FacesMessage("Property Edited", ((Propiedad) event.getObject()).getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
	public void onRowCancel(RowEditEvent event) {
		reload();
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Propiedad) event.getObject()).getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
	public void onRowDelete(EmptyEntity p){
		service.delete((Propiedad)p);
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
