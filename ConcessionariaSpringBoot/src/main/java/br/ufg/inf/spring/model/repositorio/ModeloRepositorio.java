package br.ufg.inf.spring.model.repositorio;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufg.inf.spring.model.entidades.Modelo;


public interface ModeloRepositorio extends JpaRepository<Modelo, Integer>{
	
	public List<Modelo> findByNomeModelo(String nomeModelo);
	public List<Modelo> findByNomeModeloContains(String nomeModelo);
	

	@Query(value = "SELECT b FROM Modelo b ORDER BY nomeModelo")
	public List<Modelo> findAllOrderNome();

}
