package com.crawl.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crawl.jpa.data.Sustitucion;
public interface SustitucionDao extends JpaRepository<Sustitucion, Long>, SustitucionDaoCustom{}
