package com.crawl.command.crud.impl.catprop;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.crawl.command.abs.AbstractCommand;
import com.crawl.command.crud.IListarTodos;
import com.crawl.jpa.data.AsociacionFotos;

@Service
@Controller
public class ListarTodosImpl extends AbstractCommand<AsociacionFotos> implements IListarTodos<List<AsociacionFotos>>{
	
	@Override
	public List<AsociacionFotos> execute() { return getDao().findAll(); }

}
