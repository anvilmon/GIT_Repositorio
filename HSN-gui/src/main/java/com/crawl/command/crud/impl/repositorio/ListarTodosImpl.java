package com.crawl.command.crud.impl.repositorio;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.crawl.command.abs.AbstractCommand;
import com.crawl.command.crud.IListarTodos;
import com.crawl.jpa.data.Repositorio;

@Service
@Controller
public class ListarTodosImpl extends AbstractCommand<Repositorio> implements IListarTodos<List<Repositorio>>{
	
	@Override
	public List<Repositorio> execute() { return getDao().findAll(); }

}
