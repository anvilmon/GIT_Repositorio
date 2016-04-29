package com.crawl.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crawl.jpa.data.ConfigCategoria;

public interface ConfigCategoriaDao  extends JpaRepository<ConfigCategoria, Long>, ConfigCategoriaDaoCustom{

}
