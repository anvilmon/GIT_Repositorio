package com.crawl.command.crud.impl.catprop;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.crawl.command.abs.AbstractCommand;
import com.crawl.command.crud.IEliminar;
import com.crawl.jpa.data.AsociacionFotos;

@Service
@Controller
public class EliminarImpl extends AbstractCommand<AsociacionFotos> implements IEliminar<AsociacionFotos>{
	
	@Override
	public void execute(AsociacionFotos in) { getDao().delete(in); }


}
