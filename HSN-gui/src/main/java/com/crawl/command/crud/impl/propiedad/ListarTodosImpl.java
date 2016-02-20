package com.crawl.command.crud.impl.propiedad;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.crawl.command.abs.AbstractCommand;
import com.crawl.command.crud.IListarTodos;
import com.crawl.jpa.data.Propiedad;

@Service
@Controller
public class ListarTodosImpl extends AbstractCommand<Propiedad> implements IListarTodos<List<Propiedad>>{
	
	@Override
	public List<Propiedad> execute() { return getDao().findAll(); }

}
