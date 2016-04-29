package com.crawl.beans.impl;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.NodeCollapseEvent;
import org.primefaces.event.NodeExpandEvent;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.event.NodeUnselectEvent;
import org.primefaces.model.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.crawl.command.business.ITreeManager;

@ManagedBean(name="categoriaBean")
@ViewScoped
@Controller
public class CategoriaBean implements Serializable{

	private static final long serialVersionUID = 1L;

	// TreeNode instance
	private TreeNode root;
	private TreeNode selectedNode;
	
	@Autowired
	private ITreeManager treeManager;

	//	private List<Categoria> list;
	//	private Categoria element;
	//	
	//	@Autowired
	//	private ICategoriaCRUDManager categoriaCRUDManager;
	//
	//	
	//	/* GETTERS Y SETTERS */
	//	public void setRepositorio(Repositorio r){
	//		if (r != null){
	//			list = categoriaCRUDManager.buscarCategoriasPadre(r);
	//		}
	//	}

	@PostConstruct
	public void init(){
		reload();
	}
	
	public void reload (){ 
		root = treeManager.obtenerNodosFotos();
	}
	
	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public void onNodeSelect(NodeSelectEvent event){
		System.out.println("Node Data ::"+event.getTreeNode().getData()+" :: Selected");
	}

	public void onNodeUnSelect(NodeUnselectEvent event){
		System.out.println("Node Data ::"+event.getTreeNode().getData()+" :: UnSelected");
	}

	public void onNodeExpand(NodeExpandEvent event){
		System.out.println("Node Data ::"+event.getTreeNode().getData()+" :: Expanded");
	}

	public void onNodeCollapse(NodeCollapseEvent event){
		System.out.println("Node Data ::"+event.getTreeNode().getData()+" :: Collapsed");
	}

	public TreeNode getSelectedNode() {
		return selectedNode;
	}

	public void setSelectedNode(TreeNode selectedNode) {
		this.selectedNode = selectedNode;
	}

}
