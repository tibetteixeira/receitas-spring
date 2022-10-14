package io.github.tibetteixeira.api.v1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/error")
public class ErrorController {

    @GetMapping
    public String index() {
        return "Erro!";
    }
}
