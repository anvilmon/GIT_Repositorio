package com.crawl.command.crud.impl.sustitucion;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.crawl.command.abs.AbstractCommand;
import com.crawl.command.crud.IListarTodos;
import com.crawl.jpa.data.Sustitucion;

@Service
@Controller
public class ListarTodosImpl extends AbstractCommand<Sustitucion> implements IListarTodos<List<Sustitucion>>{
	
	@Override
	public List<Sustitucion> execute() { return getDao().findAll(); }

}
