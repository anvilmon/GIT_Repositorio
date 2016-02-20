package com.crawl.command.crud.impl.valprop;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.crawl.command.abs.AbstractCommand;
import com.crawl.command.crud.IEliminar;
import com.crawl.jpa.data.ValorPropiedad;

@Service
@Controller
public class EliminarImpl extends AbstractCommand<ValorPropiedad> implements IEliminar<ValorPropiedad>{
	
	@Override
	public void execute(ValorPropiedad in) { getDao().delete(in); }


}
