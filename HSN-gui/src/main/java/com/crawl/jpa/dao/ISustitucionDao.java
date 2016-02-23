package com.crawl.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crawl.jpa.dao.custom.ISustitucionDaoCustom;
import com.crawl.jpa.data.Sustitucion;

public interface ISustitucionDao extends JpaRepository<Sustitucion, Long>, ISustitucionDaoCustom{}
