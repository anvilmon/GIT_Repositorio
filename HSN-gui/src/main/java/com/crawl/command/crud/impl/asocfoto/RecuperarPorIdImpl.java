package com.crawl.command.crud.impl.asocfoto;

import org.springframework.stereotype.Service;

import com.crawl.command.abs.AbstractCommand;
import com.crawl.command.crud.IRecuperarPorId;
import com.crawl.jpa.data.CatPropiedad;

@Service
public class RecuperarPorIdImpl extends AbstractCommand<CatPropiedad> implements IRecuperarPorId<Long, CatPropiedad> {

	@Override
	public CatPropiedad execute(Long in) { return getDao().findOne(in); }

}
