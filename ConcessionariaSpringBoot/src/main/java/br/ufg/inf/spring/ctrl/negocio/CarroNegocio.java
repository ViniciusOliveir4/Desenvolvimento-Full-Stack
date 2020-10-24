package br.ufg.inf.spring.ctrl.negocio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.inf.spring.model.entidades.Carro;
import br.ufg.inf.spring.model.repositorio.CarroRepositorio;

@Service
public class CarroNegocio {
	
	@Autowired
	private CarroRepositorio repositorio;
	
	public List<Carro> findAll(){
		return repositorio.findAll();
	}
	
	public Carro findById(Integer Id) {
		Optional<Carro> retorno = repositorio.findById(Id);
		return retorno.get();
	}
	
	public Carro insert(Carro carro) {
		return repositorio.save(carro);
	}
	
	public void delete(Integer id) {
		repositorio.deleteById(id);
	}
	
	
	public Carro update(Carro carro) {
		Carro carroUpdate = repositorio.getOne(carro.getIdCarro());
		
		carroUpdate.setTipo(carro.getTipo());
		carroUpdate.setPlaca(carro.getPlaca());
		carroUpdate.setAno(carro.getAno());
		carroUpdate.setCor(carro.getCor());
		carroUpdate.setModelo(carroUpdate.getModelo());
		
		return repositorio.save(carroUpdate);
	}
	
}
