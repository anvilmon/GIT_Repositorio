package com.crawl.command.crud.impl.sustitucion;

import org.springframework.stereotype.Service;

import com.crawl.command.abs.AbstractCommand;
import com.crawl.command.crud.IRecuperarPorId;
import com.crawl.jpa.data.Sustitucion;

@Service
public class RecuperarPorIdImpl extends AbstractCommand<Sustitucion> implements IRecuperarPorId<Long, Sustitucion> {

	@Override
	public Sustitucion execute(Long in) { return getDao().findOne(in); }

}
