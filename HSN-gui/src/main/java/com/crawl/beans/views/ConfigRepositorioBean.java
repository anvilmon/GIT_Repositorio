package com.crawl.beans.views;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.crawl.command.crud.IConfigRepositorioCRUDManager;
import com.crawl.jpa.data.ConfigRepositorio;
import com.crawl.jpa.data.Repositorio;

@ManagedBean(name="configRepositorioBean")
@ViewScoped
@Controller
public class ConfigRepositorioBean {

	@Autowired
	private IConfigRepositorioCRUDManager configRepositorioCRUDManager;
	
	private ConfigRepositorio element;
	
	public void save() { 
		configRepositorioCRUDManager.guardar(element);
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dlgConfigRepositorio').hide();");
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Configuración de repositorio guardada correctamente"));
	}
	
	public void cancel() { 	
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('dlgConfigRepositorio').hide();");
	}

	public ConfigRepositorio getElement() {
		return element;
	}

	public void setElement(ConfigRepositorio element) {
		this.element = element;
	}
	
	public void setRepositorio (Repositorio r){
		if (r != null){
			element = configRepositorioCRUDManager.buscarPorRepositorio(r);
			if (element.getRepositorio() == null){
				element.setRepositorio(r);
			}
		}
	}
}
