package com.crawl.command.crud.impl.propiedad;

import org.springframework.stereotype.Service;

import com.crawl.command.abs.AbstractCommand;
import com.crawl.command.crud.IRecuperarPorId;
import com.crawl.jpa.data.Propiedad;

@Service
public class RecuperarPorIdImpl extends AbstractCommand<Propiedad> implements IRecuperarPorId<Long, Propiedad> {

	@Override
	public Propiedad execute(Long in) { return getDao().findOne(in); }

}
