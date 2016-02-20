package com.crawl.command.crud.impl.asocfoto;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.crawl.command.abs.AbstractCommand;
import com.crawl.command.crud.IListarTodos;
import com.crawl.jpa.data.CatPropiedad;

@Service
@Controller
public class ListarTodosImpl extends AbstractCommand<CatPropiedad> implements IListarTodos<List<CatPropiedad>>{
	
	@Override
	public List<CatPropiedad> execute() { return getDao().findAll(); }

}
