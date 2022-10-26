package io.github.tibetteixeira.api.v1.domain.service;

import io.github.tibetteixeira.api.v1.domain.model.Unit;

import java.util.List;

public interface UnitService extends CrudService<Unit, String> {

    List<Unit> findByDescription(String description);
}
