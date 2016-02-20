package com.crawl.command.crud.impl.producto;

import org.springframework.stereotype.Service;

import com.crawl.command.abs.AbstractCommand;
import com.crawl.command.crud.IRecuperarPorId;
import com.crawl.jpa.data.Producto;

@Service
public class RecuperarPorIdImpl extends AbstractCommand<Producto> implements IRecuperarPorId<Long, Producto> {

	@Override
	public Producto execute(Long in) { return getDao().findOne(in); }

}
