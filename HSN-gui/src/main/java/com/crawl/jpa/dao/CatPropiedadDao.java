package com.crawl.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crawl.jpa.data.CatPropiedad;
public interface CatPropiedadDao extends JpaRepository<CatPropiedad, Long>, CatPropiedadDaoCustom{}
