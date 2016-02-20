package com.crawl.command.crud.impl.propiedad;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.crawl.command.abs.AbstractCommand;
import com.crawl.command.crud.IPersistir;
import com.crawl.jpa.data.Propiedad;

@Service
@Controller
public class PersistirImpl extends AbstractCommand<Propiedad> implements IPersistir<Propiedad,Propiedad>{
	

	@Override
	public Propiedad execute(Propiedad in) { return getDao().register(in); }



}
