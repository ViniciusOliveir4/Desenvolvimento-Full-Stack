package br.ufg.inf.spring.ctrl.negocio;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.spring.model.entidades.Modelo;
import br.ufg.inf.spring.model.repositorio.ModeloRepositorio;

@Service
public class ModeloNegocio {
	
	@Autowired
	private ModeloRepositorio repositorio;
	
	public List<Modelo> findAll(){
		return repositorio.findAll();
	}
	
	public Modelo findById(Integer Id) {
		Optional<Modelo> retorno = repositorio.findById(Id);
		return retorno.get();
	}
	
	public Modelo insert(Modelo modelo) {
		return repositorio.save(modelo);
	}
	
	public void delete(Integer id) {
		repositorio.deleteById(id);
	}
	
	
	public Modelo update(Modelo modelo) {
		Modelo modeloUpdate = repositorio.getOne(modelo.getModeloId());
		
		modeloUpdate.setNomeModelo(modelo.getNomeModelo());
		modeloUpdate.setFabricante(modeloUpdate.getFabricante());

		return repositorio.save(modeloUpdate);
	}
}
