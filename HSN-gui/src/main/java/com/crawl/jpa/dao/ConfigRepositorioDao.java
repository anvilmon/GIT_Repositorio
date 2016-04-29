package com.crawl.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crawl.jpa.data.ConfigRepositorio;

public interface ConfigRepositorioDao extends JpaRepository<ConfigRepositorio, Long>, ConfigRepositorioDaoCustom{

}
