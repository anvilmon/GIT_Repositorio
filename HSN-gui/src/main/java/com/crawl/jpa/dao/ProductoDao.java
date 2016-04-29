package com.crawl.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crawl.jpa.data.Producto;
public interface ProductoDao extends JpaRepository<Producto, Long>, ProductoDaoCustom{}
