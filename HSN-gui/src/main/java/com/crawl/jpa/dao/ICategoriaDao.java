package com.crawl.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crawl.jpa.dao.custom.ICategoriaDaoCustom;
import com.crawl.jpa.data.Categoria;

public interface ICategoriaDao extends JpaRepository<Categoria, Long>, ICategoriaDaoCustom{}
