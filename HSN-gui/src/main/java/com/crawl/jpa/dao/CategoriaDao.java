package com.crawl.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crawl.jpa.data.Categoria;
public interface CategoriaDao extends JpaRepository<Categoria, Long>, CategoriaDaoCustom{}
