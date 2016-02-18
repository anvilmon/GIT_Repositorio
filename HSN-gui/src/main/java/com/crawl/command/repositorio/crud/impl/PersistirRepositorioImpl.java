package com.crawl.command.repositorio.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crawl.command.repositorio.crud.IPersistirRepositorio;
import com.crawl.jpa.dao.IDao;
import com.crawl.jpa.data.Repositorio;

@Service
public class PersistirRepositorioImpl implements IPersistirRepositorio{
	
	@Autowired
	private IDao<Repositorio> dao;

	@Override
	public Repositorio execute(Repositorio in) {
		return dao.register(in);
	}



}
