package com.crawl.command.crud.impl.sustitucion;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.crawl.command.abs.AbstractCommand;
import com.crawl.command.crud.IPersistir;
import com.crawl.jpa.data.Sustitucion;

@Service
@Controller
public class PersistirImpl extends AbstractCommand<Sustitucion> implements IPersistir<Sustitucion,Sustitucion>{
	

	@Override
	public Sustitucion execute(Sustitucion in) { return getDao().register(in); }



}
