package com.crawl.command.crud.impl.repositorio;

import org.springframework.stereotype.Service;

import com.crawl.command.abs.AbstractCommand;
import com.crawl.command.crud.IRecuperarPorId;
import com.crawl.jpa.data.Repositorio;

@Service
public class RecuperarPorIdImpl extends AbstractCommand<Repositorio> implements IRecuperarPorId<Long, Repositorio> {

	@Override
	public Repositorio execute(Long in) { return getDao().findOne(in); }

}
