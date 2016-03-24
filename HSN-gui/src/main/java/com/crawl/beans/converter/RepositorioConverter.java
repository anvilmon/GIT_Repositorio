package com.crawl.beans.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.crawl.jpa.data.Repositorio;

@FacesConverter(forClass=Repositorio.class, value="repositorioConverter")
public class RepositorioConverter implements Converter{

	@SuppressWarnings("unchecked")
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		Repositorio r = null;
		for (Repositorio repo : (List<Repositorio>)arg1.getAttributes().get("aList")){
			if (repo.getUrl().equalsIgnoreCase(arg2)){
				r = repo;
				break;
			}
		}
		return r;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		Repositorio r = null;
		for (Repositorio repo : (List<Repositorio>)arg1.getAttributes().get("aList")){
			if (repo.getUrl().equalsIgnoreCase(((Repositorio)arg2).getUrl())){
				r = repo;
				break;
			}
		}
		return r.toString();
	}

}
