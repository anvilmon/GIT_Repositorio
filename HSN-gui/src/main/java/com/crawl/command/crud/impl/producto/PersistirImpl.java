package com.crawl.command.crud.impl.producto;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.crawl.command.abs.AbstractCommand;
import com.crawl.command.crud.IPersistir;
import com.crawl.jpa.data.Producto;

@Service
@Controller
public class PersistirImpl extends AbstractCommand<Producto> implements IPersistir<Producto,Producto>{
	

	@Override
	public Producto execute(Producto in) { return getDao().register(in); }



}
