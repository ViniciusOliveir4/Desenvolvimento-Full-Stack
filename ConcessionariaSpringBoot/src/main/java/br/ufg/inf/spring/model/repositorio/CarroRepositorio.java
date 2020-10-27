package br.ufg.inf.spring.model.repositorio;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufg.inf.spring.model.entidades.Carro;


public interface CarroRepositorio extends JpaRepository<Carro, Integer>{
	
	public List<Carro> findByNomeCarro(String nomeCarro);
	public List<Carro> findByNomeCarroContains(String nomeCarro);
	

	@Query(value = "SELECT b FROM Carro b ORDER BY nomeCarro")
	public List<Carro> findAllOrderNome();

}
