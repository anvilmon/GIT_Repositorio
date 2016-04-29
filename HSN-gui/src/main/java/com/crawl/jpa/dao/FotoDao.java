package com.crawl.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crawl.jpa.data.Foto;
public interface FotoDao extends JpaRepository<Foto, Long>, FotoDaoCustom{}
