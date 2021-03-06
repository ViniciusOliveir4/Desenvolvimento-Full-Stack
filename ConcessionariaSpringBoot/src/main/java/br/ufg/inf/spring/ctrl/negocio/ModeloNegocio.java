package br.ufg.inf.spring.ctrl.negocio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.spring.ctrl.excecao.ModeloException;
import br.ufg.inf.spring.ctrl.excecao.NotFoundException;
import br.ufg.inf.spring.model.entidades.Modelo;
import br.ufg.inf.spring.model.repositorio.ModeloRepositorio;


@Service
public class ModeloNegocio {
	
	@Autowired
	private ModeloRepositorio repositorio;
	

	public List<Modelo> findAll(){
		return repositorio.findAll();
	}
	
	public Modelo findById(Integer Id) throws NotFoundException {
		Optional<Modelo> retorno = repositorio.findById(Id);
		if(!retorno.isPresent()) {
			throw new NotFoundException("Modelo com id "+Id+" não encontrada");
		}
		return retorno.get();
	}
	
	public Modelo insert(Modelo modelo) throws ModeloException{
		return this.insertOrUpdate(modelo);
	}
	
	private Modelo insertOrUpdate(Modelo modelo) throws ModeloException {
		
		if(modelo.getNomeModelo().length()==0) {
			throw new ModeloException("Campo(s) Faltando");
		}
		
		return repositorio.save(modelo);
	}
	
	public void delete(Integer id) throws NotFoundException {
		Optional<Modelo> modelo = repositorio.findById(id);
		if(modelo.isPresent()) {
			repositorio.delete(modelo.get());
		}else {
			throw new NotFoundException("Modelo com id "+id+" não encontrada");
		}	
	}
	
	
	public Modelo update(Modelo modelo) throws NotFoundException, ModeloException{
		Optional<Modelo> bUpd = repositorio.findById(modelo.getModeloId());
		//Atualizar os daddos no objeto
		
		if(!bUpd.isPresent()) {
			throw new NotFoundException("Modelo com id "+modelo.getModeloId()+" não encontrada");
		}
		else {
			Modelo modeloUpd = bUpd.get();
			modeloUpd.setNomeModelo(modelo.getNomeModelo());
			modeloUpd.setFabricante(modelo.getFabricante());
			
			return this.insertOrUpdate(modeloUpd);
		}
	}
	
	public Modelo findByNome(String str) throws NotFoundException {
		List<Modelo> list = repositorio.findByNomeModelo(str);
		if(list.size() > 0) {
			return list.get(0);
		}
		else {
			throw new NotFoundException("Modelo com nome '"+str+"' não encontrada");
		}
	}
	
	public List<Modelo> findAllNome(String str) throws NotFoundException {
		List<Modelo> list = repositorio.findByNomeModeloContains(str);
		if(list.size() > 0) {
			return list;
		}
		else {
			throw new NotFoundException("Modelo com a ocorrência '"+str+"' não encontrada");
		}
	}
	
	public List<Modelo> findAllOrderNome(){
		return repositorio.findAllOrderNome();
	}
	
}
