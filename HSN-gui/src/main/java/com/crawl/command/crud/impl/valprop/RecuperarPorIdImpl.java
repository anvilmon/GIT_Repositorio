package com.crawl.command.crud.impl.valprop;

import org.springframework.stereotype.Service;

import com.crawl.command.abs.AbstractCommand;
import com.crawl.command.crud.IRecuperarPorId;
import com.crawl.jpa.data.ValorPropiedad;

@Service
public class RecuperarPorIdImpl extends AbstractCommand<ValorPropiedad> implements IRecuperarPorId<Long, ValorPropiedad> {

	@Override
	public ValorPropiedad execute(Long in) { return getDao().findOne(in); }

}
