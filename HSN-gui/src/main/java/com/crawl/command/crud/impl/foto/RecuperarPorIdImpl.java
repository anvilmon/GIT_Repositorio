package com.crawl.command.crud.impl.foto;

import org.springframework.stereotype.Service;

import com.crawl.command.abs.AbstractCommand;
import com.crawl.command.crud.IRecuperarPorId;
import com.crawl.jpa.data.Foto;

@Service
public class RecuperarPorIdImpl extends AbstractCommand<Foto> implements IRecuperarPorId<Long, Foto> {

	@Override
	public Foto execute(Long in) { return getDao().findOne(in); }

}
