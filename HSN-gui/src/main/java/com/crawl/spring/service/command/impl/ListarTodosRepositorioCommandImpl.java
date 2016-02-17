package com.crawl.spring.service.command.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crawl.jpa.data.EmptyEntity;
import com.crawl.jpa.data.Repositorio;
import com.crawl.spring.service.IService;
import com.crawl.spring.service.command.ListarTodosRepositorioCommand;

@Service
public class ListarTodosRepositorioCommandImpl implements ListarTodosRepositorioCommand{
	
	@Autowired
	private IService<Repositorio> dao;

	@Override
	public List<Repositorio> execute(EmptyEntity in) {
		return dao.findAll();
	}

}
