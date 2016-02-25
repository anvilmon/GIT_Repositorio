package com.crawl.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crawl.jpa.dao.custom.IValorPropiedadDaoCustom;
import com.crawl.jpa.data.ValorPropiedad;
public interface IValorPropiedadDao extends JpaRepository<ValorPropiedad, Long>, IValorPropiedadDaoCustom{}
