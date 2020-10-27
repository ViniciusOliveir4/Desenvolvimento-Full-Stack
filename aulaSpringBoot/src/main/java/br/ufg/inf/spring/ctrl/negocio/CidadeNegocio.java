package br.ufg.inf.spring.ctrl.negocio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.spring.model.entidades.Cidade;
import br.ufg.inf.spring.model.repositorio.CidadeRepositorio;

@Service
public class CidadeNegocio {
	
	@Autowired
	private CidadeRepositorio repositorio;
	
	public List<Cidade> findAll(){
		return repositorio.findAll();
	}
	
	public Cidade findById(Integer Id) {
		Optional<Cidade> retorno = repositorio.findById(Id);
		return retorno.get();
	}
	
	public Cidade insert(Cidade cidade) {
		return repositorio.save(cidade);
	}
	
	public void delete(Integer id) {
		repositorio.deleteById(id);
	}
	
	
	public Cidade update(Cidade cidade) {
		Cidade cidadeUpdate = repositorio.getOne(cidade.getIdCidade());
		//Atualizar os daddos no objeto
		cidadeUpdate.setNomeCidade(cidade.getNomeCidade());
		cidadeUpdate.setSiglaEstado(cidade.getSiglaEstado());
		return repositorio.save(cidadeUpdate);
	}
}
