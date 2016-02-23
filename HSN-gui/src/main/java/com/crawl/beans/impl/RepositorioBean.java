package com.crawl.beans.impl;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.crawl.beans.ITableBean;
import com.crawl.command.crud.IRepositorioCRUDManager;
import com.crawl.jpa.AbstractEntity;
import com.crawl.jpa.data.Repositorio;
import com.crawl.primefaces.beans.converter.RepositorioConverter;
import com.crawl.spring.service.IBusiness;
import com.crawl.utils.Constants;

@ManagedBean(name="repositorioBean")
@ViewScoped
@Controller
public class RepositorioBean implements Serializable, ITableBean{

	private static final long serialVersionUID = 1L;
	
	private List<Repositorio> lstRepositorios;
	private Repositorio repositorio;
	
	@Autowired
	private IRepositorioCRUDManager repositorioCRUD;
	
	@ManagedProperty("#{crawlerBusiness}")
	private IBusiness business;
	
	@PostConstruct
	public void init(){
		reload();
	}
	
	public List<Repositorio> getLstRepositorios() {
		return lstRepositorios;
	}
	public void setLstRepositorios(List<Repositorio> lstRepositorios) {
		this.lstRepositorios = lstRepositorios;
	}

	public Repositorio getRepositorio() {
		return repositorio;
	}

	public void setRepositorio(Repositorio repositorio) {
		this.repositorio = repositorio;
	}

	
	public void register() {
		try{
			repositorioCRUD.guardar(repositorio);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The Repository "+repositorio.getUrl()+" Is Registered Successfully"));
			System.out.println(repositorio.toString());
			repositorio = new Repositorio();
			reload();
		}catch(Exception e){
			System.out.println(e.getStackTrace());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("There has been an error registering data."));
		}	
	}
	
	public void reload (){
		lstRepositorios = repositorioCRUD.listarTodos();
		RepositorioConverter.DB = lstRepositorios;
		repositorio = new Repositorio();
	}	

	public void onRowEdit(RowEditEvent event) {
		repositorio = (Repositorio) event.getObject();
		register();
        FacesMessage msg = new FacesMessage("Repository Edited", ((Repositorio) event.getObject()).getUrl());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
	public void onRowCancel(RowEditEvent event) {
		reload();
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Repositorio) event.getObject()).getUrl());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
	public void onRowDelete(AbstractEntity r){
		final Repositorio toDel = (Repositorio)r;
		if (!Constants.Globals.EMPTY_STRING.equals(toDel.getUrl())){
			repositorioCRUD.eliminar(((Repositorio)r));
		}
		reload();
	}
	
	public void onRowScan(AbstractEntity r) throws Exception{
		final List<Repositorio> lRepositorios = new ArrayList<Repositorio>();
		lRepositorios.add((Repositorio)r);
		scan(lRepositorios);
	}
	
	public void scan(List<Repositorio> list) throws Exception{
		try {
			business.scanRepositorios();
		} catch (IOException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("There has been an error crawling data."));
			e.printStackTrace();
		}
	}

//	public IBusiness getBusiness() {
//		return business;
//	}
//
//	public void setBusiness(IBusiness business) {
//		this.business = business;
//	}

	@Override
	public void onRowCreate() {
		lstRepositorios.add(new Repositorio());
	}
}
