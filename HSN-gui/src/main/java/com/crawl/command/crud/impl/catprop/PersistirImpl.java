package com.crawl.command.crud.impl.catprop;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.crawl.command.abs.AbstractCommand;
import com.crawl.command.crud.IPersistir;
import com.crawl.jpa.data.AsociacionFotos;

@Service
@Controller
public class PersistirImpl extends AbstractCommand<AsociacionFotos> implements IPersistir<AsociacionFotos,AsociacionFotos>{
	

	@Override
	public AsociacionFotos execute(AsociacionFotos in) { return getDao().register(in); }



}
