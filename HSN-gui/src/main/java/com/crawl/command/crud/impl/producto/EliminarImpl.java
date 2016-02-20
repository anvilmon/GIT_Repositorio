package com.crawl.command.crud.impl.producto;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.crawl.command.abs.AbstractCommand;
import com.crawl.command.crud.IEliminar;
import com.crawl.jpa.data.Producto;

@Service
@Controller
public class EliminarImpl extends AbstractCommand<Producto> implements IEliminar<Producto>{
	
	@Override
	public void execute(Producto in) { getDao().delete(in); }


}
