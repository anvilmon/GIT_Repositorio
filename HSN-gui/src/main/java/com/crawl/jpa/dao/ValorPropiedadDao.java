package com.crawl.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crawl.jpa.data.ValorPropiedad;
public interface ValorPropiedadDao extends JpaRepository<ValorPropiedad, Long>, ValorPropiedadDaoCustom{}
