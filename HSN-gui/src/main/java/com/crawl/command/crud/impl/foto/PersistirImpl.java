package com.crawl.command.crud.impl.foto;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.crawl.command.abs.AbstractCommand;
import com.crawl.command.crud.IPersistir;
import com.crawl.jpa.data.Foto;

@Service
@Controller
public class PersistirImpl extends AbstractCommand<Foto> implements IPersistir<Foto,Foto>{
	

	@Override
	public Foto execute(Foto in) { return getDao().register(in); }



}
