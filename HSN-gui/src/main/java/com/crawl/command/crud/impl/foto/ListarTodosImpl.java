package com.crawl.command.crud.impl.foto;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.crawl.command.abs.AbstractCommand;
import com.crawl.command.crud.IListarTodos;
import com.crawl.jpa.data.Foto;

@Service
@Controller
public class ListarTodosImpl extends AbstractCommand<Foto> implements IListarTodos<List<Foto>>{
	
	@Override
	public List<Foto> execute() { return getDao().findAll(); }

}
