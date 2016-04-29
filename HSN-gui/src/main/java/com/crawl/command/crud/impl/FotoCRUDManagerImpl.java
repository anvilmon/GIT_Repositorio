package com.crawl.command.crud.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.crawl.command.crud.IFotoCRUDManager;
import com.crawl.jpa.dao.FotoDao;
import com.crawl.jpa.data.Foto;

@Component("fotoCRUD")
@Service
public class FotoCRUDManagerImpl implements IFotoCRUDManager {
	
	@Autowired
	private FotoDao dao;

	@Override
	public void eliminar(Foto af) { dao.delete(af); }
	@Override
	public Foto guardar(Foto af) { return dao.save(af); }
	@Override
	public List<Foto> listarTodos() { return dao.findAll(); }
	@Override
	public Foto buscarPorId(Long id) { return dao.findOne(id); }
	@Override
	public Foto generateNewFoto (){
		Foto foto = new Foto ();
		foto.setDtFoto(new Date());
		foto.setTerminado(false);
		guardar(foto);
		return dao.retrieveLast();
	}
}
