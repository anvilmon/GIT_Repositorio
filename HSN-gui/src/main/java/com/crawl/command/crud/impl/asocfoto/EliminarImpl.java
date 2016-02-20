package com.crawl.command.crud.impl.asocfoto;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.crawl.command.abs.AbstractCommand;
import com.crawl.command.crud.IEliminar;
import com.crawl.jpa.data.CatPropiedad;

@Service
@Controller
public class EliminarImpl extends AbstractCommand<CatPropiedad> implements IEliminar<CatPropiedad>{
	
	@Override
	public void execute(CatPropiedad in) { getDao().delete(in); }


}
