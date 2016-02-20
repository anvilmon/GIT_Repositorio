package com.crawl.command.crud.impl.foto;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.crawl.command.abs.AbstractCommand;
import com.crawl.command.crud.IEliminar;
import com.crawl.jpa.data.Foto;

@Service
@Controller
public class EliminarImpl extends AbstractCommand<Foto> implements IEliminar<Foto>{
	
	@Override
	public void execute(Foto in) { getDao().delete(in); }


}
