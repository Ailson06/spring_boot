package br.com.springboot.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.Models.Usuario;
import br.com.springboot.Repositorys.UsuarioRepository;

// @RestController essa anotação torna nosso controller REST
// REST
// Representational State Transfer, em português Transferência Representacional de Estado, é um estilo de arquitetura de software que define um conjunto de restrições a serem usadas para a criação de web services. Wikipédia

// @RequestMapping path ou endereço que definimos geral para todos os metodos

// referencia aonde instalamos o jpa/postgresql (https://mvnrepository.com/)

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    // para definir como acessar esse metodo, é necessario utilizar o verbo http
    // juntamente com uma rota
    // para cada verbo http ha uma "anotation"

    private List<Usuario> usuarios = new ArrayList<>();

    // nao é possivel instanciar repositorys porque eles são interfaces
    // mas atraves da anotação AutoWired conseguimos realizar uma injeção de dependencias
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public Usuario helloWord() {
        Usuario user = new Usuario();
        user.setId(1L);
        user.setName("ailson");
        user.setUserName("ailson monstrão");

        return user;
    }

    // a anotação @RequestBody => representa minha requisição
    @PostMapping
    public Usuario user(@RequestBody Usuario user) {
        return this.usuarioRepository.save(user);
    }

    @GetMapping("/{id}")
    public Usuario getUsuarioById(@PathVariable("id") Long id) {
        Optional<Usuario> users = this.usuarioRepository.findById(id);
        return users.get();
    }

    @GetMapping("/all")
    public List<Usuario> getUsuarios() {
        return this.usuarioRepository.findAll();
    }

    // RASCUNHO
    // migrations no spring boot Flyway e Liquibase
}
