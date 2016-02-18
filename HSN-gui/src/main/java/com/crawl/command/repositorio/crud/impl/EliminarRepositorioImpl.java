package com.crawl.command.repositorio.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.crawl.command.repositorio.crud.IEliminarRepositorio;
import com.crawl.jpa.dao.IDao;
import com.crawl.jpa.data.Repositorio;

@Controller
public class EliminarRepositorioImpl implements IEliminarRepositorio{

	@Autowired
	private IDao<Repositorio> dao;
	
	@Override
	public void execute(Repositorio in) {
		dao.delete(in);
	}


}
