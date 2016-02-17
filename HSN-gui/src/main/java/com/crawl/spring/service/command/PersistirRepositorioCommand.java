package com.crawl.spring.service.command;

import org.springframework.stereotype.Service;

import com.crawl.jpa.data.Repositorio;

@Service
public interface PersistirRepositorioCommand extends ICommand<Repositorio, Repositorio>{}
