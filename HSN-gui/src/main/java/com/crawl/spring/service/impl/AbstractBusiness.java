package com.crawl.spring.service.impl;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.crawl.jpa.data.Foto;
import com.crawl.spring.service.IService;

public class AbstractBusiness {

	@Autowired
	protected IService<Foto> fotoService;
	
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
