package io.github.tibetteixeira.api.v1.controller;

import io.github.tibetteixeira.api.v1.domain.model.Usuario;
import io.github.tibetteixeira.api.v1.domain.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(path = "/salvar")
    public void salvar(@RequestBody Usuario usuario) {
        usuarioService.salvar(usuario);
    }

    @PutMapping(path = "/atualizar")
    public void atualizar(@RequestBody Usuario usuario) {
        usuarioService.atualizar(usuario);
    }

    @DeleteMapping(path = "/remover")
    public void remover(@RequestBody Usuario usuario) {
        usuarioService.remover(usuario);
    }

    @GetMapping(path = "/listarPorCodigo/{codigo}")
    public Usuario listarPorCodigo(@PathVariable Integer codigo) {
        return usuarioService.listarPorCodigo(codigo);
    }

    @GetMapping(path = "/listarTodos")
    public List<Usuario> listarTodos() {
        return usuarioService.listarTodos();
    }

    @GetMapping(path = "/listarPorNome")
    public List<Usuario> listarPorNome(String nome) {
        return usuarioService.listarPorNome(nome);
    }

}
