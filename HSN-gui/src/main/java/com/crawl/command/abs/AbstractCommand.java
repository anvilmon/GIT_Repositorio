package com.crawl.command.abs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crawl.jpa.dao.IDao;

@Service
public abstract class AbstractCommand<K> {

	@Autowired
	private IDao<K> dao;

	public IDao<K> getDao() {
		return dao;
	}

	public void setDao(IDao<K> dao) {
		this.dao = dao;
	}
	
}
