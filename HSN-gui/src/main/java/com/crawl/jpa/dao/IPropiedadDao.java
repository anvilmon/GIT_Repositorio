package com.crawl.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crawl.jpa.dao.custom.IPropiedadDaoCustom;
import com.crawl.jpa.data.Propiedad;

public interface IPropiedadDao extends JpaRepository<Propiedad, Long>, IPropiedadDaoCustom{}
