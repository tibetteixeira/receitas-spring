package io.github.tibetteixeira.api.v1.controller;

import io.github.tibetteixeira.api.v1.domain.model.Usuario;
import io.github.tibetteixeira.api.v1.domain.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ReceitaController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(path = "/usuario/listaTodos")
    public List<Usuario> buscarTodos() {
        List<Usuario> usuarios = usuarioService.listarTodos();
        return usuarios;
    }
}
