package com.crawl.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crawl.jpa.data.ProductoCategoria;
public interface ProductoCategoriaDao extends JpaRepository<ProductoCategoria, Long>, ProductoCategoriaDaoCustom{}
