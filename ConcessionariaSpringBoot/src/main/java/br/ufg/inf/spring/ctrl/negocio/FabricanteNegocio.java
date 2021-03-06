package br.ufg.inf.spring.ctrl.negocio;

import java.util.List;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.spring.ctrl.excecao.FabricanteException;
import br.ufg.inf.spring.ctrl.excecao.NotFoundException;
import br.ufg.inf.spring.model.entidades.Fabricante;
import br.ufg.inf.spring.model.repositorio.FabricanteRepositorio;


@Service
public class FabricanteNegocio {
	
	@Autowired
	private FabricanteRepositorio repositorio;
	
	public List<Fabricante> findAll(){
		return repositorio.findAll();
	}
	
	public Fabricante findById(Integer Id) throws NotFoundException {
		Optional<Fabricante> retorno = repositorio.findById(Id);
		if(!retorno.isPresent()) {
			throw new NotFoundException("Fabricante com id "+Id+" não encontrado");
		}
		return retorno.get();
	}
	
	public Fabricante insert(Fabricante fabricante) throws FabricanteException{
		return this.insertOrUpdate(fabricante);
	}
	
	private Fabricante insertOrUpdate(Fabricante fabricante) throws FabricanteException {
		
		if(fabricante.getFabricanteNome().length()==0) {
			throw new FabricanteException("Campo(s) Faltando");
		}
		
		return repositorio.save(fabricante);
	}
	
	public void delete(Integer id) throws NotFoundException {
		Optional<Fabricante> fabricante = repositorio.findById(id);
		if(fabricante.isPresent()) {
			repositorio.delete(fabricante.get());
		}else {
			throw new NotFoundException("Fabricante com id "+id+" não encontrado");
		}
		
		
	}
	
	
	public Fabricante update(Fabricante fabricante) throws NotFoundException, FabricanteException{
		Optional<Fabricante> fUpd = repositorio.findById(fabricante.getFabricanteId());
		//Atualizar os daddos no objeto
		
		if(!fUpd.isPresent()) {
			throw new NotFoundException("Fabricante com id "+fabricante.getFabricanteId()+" não encontrado");
		}
		else {
			Fabricante fabricanteUpd = fUpd.get();
			fabricanteUpd.setFabricanteNome(fabricante.getFabricanteNome());
			
			return this.insertOrUpdate(fabricanteUpd);
		}
	}
	
}
