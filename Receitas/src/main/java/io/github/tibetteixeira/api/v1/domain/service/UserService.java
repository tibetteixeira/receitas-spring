package io.github.tibetteixeira.api.v1.domain.service;

import io.github.tibetteixeira.api.v1.domain.model.User;

import java.util.List;

public interface UserService extends CrudService<User, Integer> {

    List<User> findByName(String name);
}
