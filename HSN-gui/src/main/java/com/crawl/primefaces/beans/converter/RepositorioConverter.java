package com.crawl.primefaces.beans.converter;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.crawl.jpa.data.Repositorio;

@FacesConverter(forClass=Repositorio.class, value="repositorioConverter")
public class RepositorioConverter implements Converter{

	public static List<Repositorio> DB = new ArrayList<Repositorio>();
	
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		Repositorio r = null;
		for (Repositorio repo : DB){
			if (repo.getUrl().equalsIgnoreCase(arg2)){
				r = repo;
				break;
			}
		}
		return r;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		Repositorio r = null;
		for (Repositorio repo : DB){
			if (repo.getUrl().equalsIgnoreCase(((Repositorio)arg2).getUrl())){
				r = repo;
				break;
			}
		}
		return r.toString();
	}

}
