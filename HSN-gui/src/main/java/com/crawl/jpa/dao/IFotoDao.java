package com.crawl.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crawl.jpa.dao.custom.IFotoDaoCustom;
import com.crawl.jpa.data.Foto;

public interface IFotoDao extends JpaRepository<Foto, Long>, IFotoDaoCustom{}
