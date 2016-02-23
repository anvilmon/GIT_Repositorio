package com.crawl.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crawl.jpa.dao.custom.IAsociacionFotosDaoCustom;
import com.crawl.jpa.data.AsociacionFotos;

public interface IAsociacionFotosDao extends JpaRepository<AsociacionFotos, Long>, IAsociacionFotosDaoCustom{}
