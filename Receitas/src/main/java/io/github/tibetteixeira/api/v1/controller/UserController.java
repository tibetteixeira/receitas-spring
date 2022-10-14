package io.github.tibetteixeira.api.v1.controller;

import io.github.tibetteixeira.api.v1.domain.model.User;
import io.github.tibetteixeira.api.v1.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/save")
    public void save(@RequestBody User user) {
        userService.save(user);
    }

    @PutMapping(path = "/update/{id}")
    public void update(@PathVariable Integer id, @RequestBody User user) {
        userService.update(id, user);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable Integer id) {
        userService.delete(id);
    }

    @GetMapping(path = "/findById/{id}")
    public User findById(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @GetMapping(path = "/findAll")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping(path = "/findByName/{name}")
    public List<User> findByName(@PathVariable String name) {
        return userService.findByName(name);
    }

}
