package io.github.tibetteixeira.api.v1.service.impl;

import io.github.tibetteixeira.api.v1.repository.ReceitaRepository;
import io.github.tibetteixeira.api.v1.service.ReceitaService;
import org.springframework.stereotype.Service;

@Service
public class ReceitaServiceImpl implements ReceitaService {

    private ReceitaRepository repository;

    public ReceitaServiceImpl(ReceitaRepository repository) {
        this.repository = repository;
    }
}