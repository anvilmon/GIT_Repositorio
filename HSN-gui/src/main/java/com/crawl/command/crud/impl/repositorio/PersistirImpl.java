package com.crawl.command.crud.impl.repositorio;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.crawl.command.abs.AbstractCommand;
import com.crawl.command.crud.IPersistir;
import com.crawl.jpa.data.Repositorio;

@Service
@Controller
public class PersistirImpl extends AbstractCommand<Repositorio> implements IPersistir<Repositorio,Repositorio>{
	

	@Override
	public Repositorio execute(Repositorio in) { return getDao().register(in); }



}
