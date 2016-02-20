package com.crawl.command.crud.impl.producto;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.crawl.command.abs.AbstractCommand;
import com.crawl.command.crud.IListarTodos;
import com.crawl.jpa.data.Producto;

@Service
@Controller
public class ListarTodosImpl extends AbstractCommand<Producto> implements IListarTodos<List<Producto>>{
	
	@Override
	public List<Producto> execute() { return getDao().findAll(); }

}
