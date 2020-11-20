package br.ufg.inf.spring.ctrl.negocio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.spring.ctrl.excecao.CarroException;
import br.ufg.inf.spring.ctrl.excecao.NotFoundException;
import br.ufg.inf.spring.model.entidades.Carro;
import br.ufg.inf.spring.model.repositorio.CarroRepositorio;



@Service
public class CarroNegocio {
	
	@Autowired
	private CarroRepositorio repositorio;
	
	public List<Carro> findAll(){
		return repositorio.findAll();
	}
	
	public Carro findById(Integer Id) throws NotFoundException {
		Optional<Carro> retorno = repositorio.findById(Id);
		if(!retorno.isPresent()) {
			throw new NotFoundException("Carro com id "+Id+" não encontrada");
		}
		return retorno.get();
	}
	
	public Carro insert(Carro carro) throws CarroException{
		return this.insertOrUpdate(carro);
	}
	
	private Carro insertOrUpdate(Carro carro) throws CarroException {
		
		if(carro.getPlaca().length()==0) {
			throw new CarroException("Campo(s) Faltando");
		}
		
		return repositorio.save(carro);
	}
	
	public void delete(Integer id) throws NotFoundException {
		Optional<Carro> carro = repositorio.findById(id);
		if(carro.isPresent()) {
			repositorio.delete(carro.get());
		}else {
			throw new NotFoundException("Carro com id "+id+" não encontrada");
		}
		
		
	}
	
	
	public Carro update(Carro carro) throws NotFoundException, CarroException{
		Optional<Carro> bUpd = repositorio.findById(carro.getIdCarro());
		//Atualizar os daddos no objeto
		
		if(!bUpd.isPresent()) {
			throw new NotFoundException("Carro com id "+carro.getIdCarro()+" não encontrada");
		}
		else {
			Carro carroUpd = bUpd.get();
			carroUpd.setTipo(carro.getTipo());
			carroUpd.setCor(carro.getCor());
			carroUpd.setAno(carro.getAno());
			carroUpd.setPlaca(carro.getPlaca());
			carroUpd.setModelo(carro.getModelo());
			
			return this.insertOrUpdate(carroUpd);
		}
	}
	
}
