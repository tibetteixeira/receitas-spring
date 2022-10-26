package io.github.tibetteixeira.api.v1.domain.service.impl;

import io.github.tibetteixeira.api.v1.domain.exception.ProductException;
import io.github.tibetteixeira.api.v1.domain.exception.UnitException;
import io.github.tibetteixeira.api.v1.domain.model.Unit;
import io.github.tibetteixeira.api.v1.domain.repository.UnitRepository;
import io.github.tibetteixeira.api.v1.domain.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.apache.commons.lang3.BooleanUtils.isFalse;

@Service
public class UnitServiceImpl implements UnitService {

    @Autowired
    private UnitRepository repository;

    @Override
    public void save(Unit unit) {
        repository.save(unit);
    }

    @Override
    public void update(String abbr, Unit unit) {
        if (isFalse(abbr.equalsIgnoreCase(unit.getAbbr())))
            throw new ProductException("Sigla da unidade diferente da sigla da Url!");

        findById(abbr);

        repository.save(unit);
    }

    @Override
    public void delete(String abbr) {
        Unit unit = findById(abbr);
        repository.delete(unit);
    }

    @Override
    public Unit findById(String abbr) {
        return repository.findById(abbr.toUpperCase()).orElseThrow(() ->
                new UnitException(String.format("Unidade com sigla %s inexistente!", abbr)));
    }

    @Override
    public List<Unit> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Unit> findByDescription(String description) {
        return repository.findByDescriptionContainsIgnoreCase(description);
    }
}
