package com.crawl.command.business.impl;

import java.util.List;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crawl.command.business.ITreeManager;
import com.crawl.jpa.dao.FotoDao;
import com.crawl.jpa.data.Foto;
import com.crawl.jpa.data.dto.TreeNodeDTO;

@Component("treeManagerImpl")
public class TreeManagerImpl implements ITreeManager{
	
	@Autowired 
	private FotoDao fotoDao; 

	@Override
	public TreeNode obtenerNodosFotos() {
		final List<Foto> lFoto = fotoDao.findAll();
		final TreeNode root = new DefaultTreeNode("Root", new TreeNodeDTO(null), null);
		TreeNodeDTO tn = null;
		for (Foto f : lFoto){
			tn = new TreeNodeDTO(f);
			new DefaultTreeNode("foto", tn, root);
		}
		return root;
	}

}
