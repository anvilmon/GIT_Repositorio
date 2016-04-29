package com.crawl.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crawl.jpa.data.Repositorio;
public interface RepositorioDao extends JpaRepository<Repositorio, Long>, RepositorioDaoCustom{}
