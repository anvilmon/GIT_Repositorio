package com.crawl.spring.service.command;

import java.util.List;

import com.crawl.jpa.data.EmptyEntity;
import com.crawl.jpa.data.Repositorio;

public interface ListarTodosRepositorioCommand extends ICommand<EmptyEntity, List<Repositorio>>{

}
