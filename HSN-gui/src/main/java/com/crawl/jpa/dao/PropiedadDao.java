package com.crawl.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crawl.jpa.data.Propiedad;
public interface PropiedadDao extends JpaRepository<Propiedad, Long>, PropiedadDaoCustom{}
