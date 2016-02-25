package com.crawl.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crawl.jpa.dao.custom.ICatPropiedadDaoCustom;
import com.crawl.jpa.data.CatPropiedad;
public interface ICatPropiedadDao extends JpaRepository<CatPropiedad, Long>, ICatPropiedadDaoCustom{}
