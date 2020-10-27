package br.ufg.inf.spring.model.repositorio;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufg.inf.spring.model.entidades.Fabricante;


public interface FabricanteRepositorio extends JpaRepository<Fabricante, Integer>{
	
	public List<Fabricante> findByNomeFabricante(String nomeFabricante);
	public List<Fabricante> findByNomeFabricanteContains(String nomeFabricante);

	
	
	@Query(value = "SELECT b FROM Fabricante b ORDER BY nomeFabricante")
	public List<Fabricante> findAllOrderNome();

}
