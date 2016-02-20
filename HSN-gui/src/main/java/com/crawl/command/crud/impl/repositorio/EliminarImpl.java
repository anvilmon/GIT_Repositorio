package com.crawl.command.crud.impl.repositorio;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.crawl.command.abs.AbstractCommand;
import com.crawl.command.crud.IEliminar;
import com.crawl.jpa.data.Repositorio;

@Service
@Controller
public class EliminarImpl extends AbstractCommand<Repositorio> implements IEliminar<Repositorio>{
	
	@Override
	public void execute(Repositorio in) { getDao().delete(in); }


}
