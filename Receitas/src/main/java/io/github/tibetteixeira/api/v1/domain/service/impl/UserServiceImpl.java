package io.github.tibetteixeira.api.v1.domain.service.impl;

import io.github.tibetteixeira.api.v1.domain.model.User;
import io.github.tibetteixeira.api.v1.domain.repository.UserRepository;
import io.github.tibetteixeira.api.v1.domain.service.UserService;
import io.github.tibetteixeira.api.v1.domain.exception.UserException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;
    private PasswordEncoder encoder;

    public UserServiceImpl(UserRepository repository,
                           PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }


    @Override
    public void save(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.getAuditDate().setCreationDate(new Date());

        repository.save(user);
    }

    @Override
    public void update(Integer id, User user) {
        User userFromDB = findById(id);

        if (isNull(userFromDB))
            throw new UserException("Não é possível atualizar usuário inexistente.");

        user.setId(userFromDB.getId());
        user.setPassword(encoder.encode(user.getPassword()));
        user.setAuditDate(userFromDB.getAuditDate());
        user.getAuditDate().setUpdateDate(new Date());

        repository.save(user);
    }

    @Override
    public void delete(Integer id) {
        User user = findById(id);
        user.getAuditDate().setExclusionDate(new Date());

        repository.save(user);
    }

    @Override
    public User findById(Integer id) {
        User user = repository.findById(id).orElse(null);

        if (isNull(user) || nonNull(user.getAuditDate().getExclusionDate()))
            throw new UserException(String.format("Usuário com id %d não foi encontrado", id));

        return user;
    }

    @Override
    public List<User> findAll() {
        return repository.findAll().stream()
                .filter(user -> isNull(user.getAuditDate().getExclusionDate())).collect(Collectors.toList());
    }

    @Override
    public List<User> findByName(String nome) {
        return repository.findByNameLike(nome);
    }
}
