package com.crawl.spring.service.command.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crawl.jpa.data.Repositorio;
import com.crawl.spring.service.IService;
import com.crawl.spring.service.command.PersistirRepositorioCommand;

@Service
public class PersistirRepositorioCommandImpl implements PersistirRepositorioCommand{
	
	@Autowired
	private IService<Repositorio> dao;

	@Override
	public Repositorio execute(Repositorio in) {
		return dao.register(in);
	}



}
