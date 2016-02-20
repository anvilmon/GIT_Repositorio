package com.crawl.command.crud.impl.propiedad;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.crawl.command.abs.AbstractCommand;
import com.crawl.command.crud.IEliminar;
import com.crawl.jpa.data.Propiedad;

@Service
@Controller
public class EliminarImpl extends AbstractCommand<Propiedad> implements IEliminar<Propiedad>{
	
	@Override
	public void execute(Propiedad in) { getDao().delete(in); }


}
