package com.crawl.command.crud;

import org.springframework.stereotype.Service;

import com.crawl.command.IOCommand;

@Service
public interface IPersistir<K,V> extends IOCommand<K,V>{}
