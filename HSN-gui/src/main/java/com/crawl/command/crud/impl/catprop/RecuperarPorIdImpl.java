package com.crawl.command.crud.impl.catprop;

import org.springframework.stereotype.Service;

import com.crawl.command.abs.AbstractCommand;
import com.crawl.command.crud.IRecuperarPorId;
import com.crawl.jpa.data.AsociacionFotos;

@Service
public class RecuperarPorIdImpl extends AbstractCommand<AsociacionFotos> implements IRecuperarPorId<Long, AsociacionFotos> {

	@Override
	public AsociacionFotos execute(Long in) { return getDao().findOne(in); }

}
