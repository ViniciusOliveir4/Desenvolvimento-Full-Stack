package br.ufg.inf.spring.ctrl.negocio;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.spring.model.entidades.Fabricante;
import br.ufg.inf.spring.model.repositorio.FabricanteRepositorio;


@Service
public class FabricanteNegocio {
	
	@Autowired
	private FabricanteRepositorio repositorio;
	
	public List<Fabricante> findAll(){
		return repositorio.findAll();
	}
	
	public Fabricante findById(Integer Id) {
		Optional<Fabricante> retorno = repositorio.findById(Id);
		return retorno.get();
	}
	
	public Fabricante insert(Fabricante fabricante) {
		return repositorio.save(fabricante);
	}
	
	public void delete(Integer id) {
		repositorio.deleteById(id);
	}
	
	
	public Fabricante update(Fabricante fabricante) {
		Fabricante fabricanteUpdate = repositorio.getOne(fabricante.getFabricanteId());
		
		fabricanteUpdate.setFabricanteNome(fabricante.getFabricanteNome());
		
		return repositorio.save(fabricanteUpdate);
	}
}
