package com.crawl.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crawl.jpa.dao.custom.IRepositorioDaoCustom;
import com.crawl.jpa.data.Repositorio;
public interface IRepositorioDao extends JpaRepository<Repositorio, Long>, IRepositorioDaoCustom{}
