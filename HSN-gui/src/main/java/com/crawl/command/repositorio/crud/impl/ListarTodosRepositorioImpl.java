package com.crawl.command.repositorio.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crawl.command.repositorio.crud.IListarTodosRepositorio;
import com.crawl.jpa.dao.IDao;
import com.crawl.jpa.data.Repositorio;

@Service
public class ListarTodosRepositorioImpl implements IListarTodosRepositorio{
	
	@Autowired
	private IDao<Repositorio> dao;

	@Override
	public List<Repositorio> execute() {
		return dao.findAll();
	}

}
