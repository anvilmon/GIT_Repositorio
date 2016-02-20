package com.crawl.command.crud.impl.valprop;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.crawl.command.abs.AbstractCommand;
import com.crawl.command.crud.IPersistir;
import com.crawl.jpa.data.ValorPropiedad;

@Service
@Controller
public class PersistirImpl extends AbstractCommand<ValorPropiedad> implements IPersistir<ValorPropiedad,ValorPropiedad>{
	

	@Override
	public ValorPropiedad execute(ValorPropiedad in) { return getDao().register(in); }



}
