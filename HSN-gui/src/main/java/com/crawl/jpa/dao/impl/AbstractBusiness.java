package com.crawl.jpa.dao.impl;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.crawl.jpa.dao.IDao;
import com.crawl.jpa.data.Foto;

public class AbstractBusiness {

	@Autowired
	protected IDao<Foto> fotoService;
	
	@Transactional
	protected Foto generateNewSnapshot (){
		Foto foto = new Foto();
		foto.setDtFoto(new Date());
		foto.setTerminado(false);
		foto = fotoService.register(foto);
		return foto;
	}
	
	protected void finishSnapshot(Foto f){
		f.setTerminado(true);
		fotoService.register(f);
	}
}
