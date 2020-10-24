package br.ufg.inf.spring.model.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufg.inf.spring.model.entidades.Carro;

public interface CarroRepositorio extends JpaRepository<Carro, Integer>{
	
	

}
