package io.github.tibetteixeira.api.v1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/erro")
public class ErroController {

    @GetMapping
    public String index() {
        return "Erro!";
    }
}
