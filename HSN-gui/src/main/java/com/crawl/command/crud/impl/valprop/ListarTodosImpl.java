package com.crawl.command.crud.impl.valprop;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.crawl.command.abs.AbstractCommand;
import com.crawl.command.crud.IListarTodos;
import com.crawl.jpa.data.ValorPropiedad;

@Service
@Controller
public class ListarTodosImpl extends AbstractCommand<ValorPropiedad> implements IListarTodos<List<ValorPropiedad>>{
	
	@Override
	public List<ValorPropiedad> execute() { return getDao().findAll(); }

}
