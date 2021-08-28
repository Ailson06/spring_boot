package br.com.springboot.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springboot.Models.Usuario;

// repository é a interface que será responsavel por acessar a entidade usuario
// Long é o tipo da chave primaria
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
  
}