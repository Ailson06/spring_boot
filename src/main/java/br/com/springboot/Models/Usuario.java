package br.com.springboot.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


// Getter => essa anotação irá criar um metodo getter para cada propriedade definida na minha classe.
// Setter => essa anotação irá criar um metodo setter para cada propriedade definida na minha classe.
// AllArgsConstructor => essa anotação ira criar um construtor onde a gente pode passar todos os nossos atributos
// NoArgsConstructor => essa anotação ira criar um construtor vazio aonde nao é necessário passar nenhum atributo

// verificar como utilizar migrations no spring boot
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

// precisamos definir que essa classe será uma tabela atraves da anotação Entity, porque até então, ela é uma classe simples
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id // esta anotação irá definir a coluna id como auto-increment
    @GeneratedValue(strategy = GenerationType.AUTO) // essa anotação irar gerar o campo id automaticamente,
    // logo não é necessario fazer nenhuma logica para setar o id
    private Long id;
    
    private String name;
    private String userName;
}