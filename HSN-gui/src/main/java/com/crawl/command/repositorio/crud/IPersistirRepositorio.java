package com.crawl.command.repositorio.crud;

import org.springframework.stereotype.Service;

import com.crawl.command.IOCommand;
import com.crawl.jpa.data.Repositorio;

@Service
public interface IPersistirRepositorio extends IOCommand<Repositorio, Repositorio>{}
