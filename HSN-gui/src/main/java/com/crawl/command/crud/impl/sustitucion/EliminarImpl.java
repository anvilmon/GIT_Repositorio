package com.crawl.command.crud.impl.sustitucion;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.crawl.command.abs.AbstractCommand;
import com.crawl.command.crud.IEliminar;
import com.crawl.jpa.data.Sustitucion;

@Service
@Controller
public class EliminarImpl extends AbstractCommand<Sustitucion> implements IEliminar<Sustitucion>{
	
	@Override
	public void execute(Sustitucion in) { getDao().delete(in); }


}
