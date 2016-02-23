package com.crawl.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crawl.jpa.dao.custom.IProductoDaoCustom;
import com.crawl.jpa.data.Producto;

public interface IProductoDao extends JpaRepository<Producto, Long>, IProductoDaoCustom{}
