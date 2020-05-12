package com.edney.curso.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edney.curso.entidades.Usuario;

public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {
	//Não há necessidade de criar a implementação desta interface, o spring.data.jpa possui um implementação padrão para esta
	//interface
}
