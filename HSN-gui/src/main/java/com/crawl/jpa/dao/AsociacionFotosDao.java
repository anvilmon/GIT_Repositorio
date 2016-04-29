package com.crawl.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crawl.jpa.data.AsociacionFotos;
public interface AsociacionFotosDao extends JpaRepository<AsociacionFotos, Long>, AsociacionFotosDaoCustom{}
