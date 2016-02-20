package com.crawl.command.crud.impl.asocfoto;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.crawl.command.abs.AbstractCommand;
import com.crawl.command.crud.IPersistir;
import com.crawl.jpa.data.CatPropiedad;

@Service
@Controller
public class PersistirImpl extends AbstractCommand<CatPropiedad> implements IPersistir<CatPropiedad,CatPropiedad>{
	

	@Override
	public CatPropiedad execute(CatPropiedad in) { return getDao().register(in); }



}
