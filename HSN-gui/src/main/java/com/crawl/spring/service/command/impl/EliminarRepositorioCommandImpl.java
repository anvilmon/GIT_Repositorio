package com.crawl.spring.service.command.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.crawl.jpa.data.EmptyEntity;
import com.crawl.jpa.data.Repositorio;
import com.crawl.spring.service.IService;
import com.crawl.spring.service.command.EliminarRepositorioCommand;

@Controller
public class EliminarRepositorioCommandImpl implements EliminarRepositorioCommand{

	@Autowired
	private IService<Repositorio> dao;
	
	@Override
	public EmptyEntity execute(Repositorio in) {
		dao.delete(in);
		return new EmptyEntity();
	}


}
