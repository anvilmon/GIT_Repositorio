package com.crawl.command.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.crawl.command.crud.IConfigRepositorioCRUDManager;
import com.crawl.jpa.dao.ConfigRepositorioDao;
import com.crawl.jpa.data.ConfigRepositorio;
import com.crawl.jpa.data.Repositorio;

@Component("configRepositorioCRUDManagerImpl")
@Service
public class ConfigRepositorioCRUDManagerImpl implements IConfigRepositorioCRUDManager{
	
	@Autowired
	private ConfigRepositorioDao configRepositorioDao;

	@Override
	public void eliminar(ConfigRepositorio af) {
		configRepositorioDao.delete(af);
	}

	@Override
	public ConfigRepositorio guardar(ConfigRepositorio af) {
		return configRepositorioDao.save(af);
	}

	@Override
	public List<ConfigRepositorio> listarTodos() {
		return configRepositorioDao.findAll();
	}

	@Override
	public ConfigRepositorio buscarPorId(Long id) {
		return configRepositorioDao.findOne(id);
	}

	@Override
	public ConfigRepositorio buscarPorRepositorio(Repositorio r) {
		return configRepositorioDao.buscarPorRepositorio(r);
	}

}
