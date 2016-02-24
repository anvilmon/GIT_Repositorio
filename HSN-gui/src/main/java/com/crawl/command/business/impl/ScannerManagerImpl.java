package com.crawl.command.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crawl.command.business.IScannerManager;
import com.crawl.command.crud.IRepositorioCRUDManager;
import com.crawl.jpa.data.Repositorio;

@Component("scannerManagerImpl")
public class ScannerManagerImpl implements IScannerManager{
	
	@Autowired
	private IRepositorioCRUDManager repositorioCRUDManager; 

	@Override
	public void escanearTodosRepositorios() {
		final List<Repositorio> lRepositorios = repositorioCRUDManager.listarTodos();
		for (Repositorio repositorio : lRepositorios){
			escanearRepositorio(repositorio);
		}
	}

	@Override
	public void escanearRepositorio(Repositorio r) {
		// TODO Auto-generated method stub
		
	}

}
