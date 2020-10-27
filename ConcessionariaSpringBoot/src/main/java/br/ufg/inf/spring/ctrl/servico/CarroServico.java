package br.ufg.inf.spring.ctrl.servico;

import java.net.URI;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.ufg.inf.spring.ctrl.excecao.CarroException;
import br.ufg.inf.spring.ctrl.excecao.NotFoundException;
import br.ufg.inf.spring.ctrl.negocio.CarroNegocio;
import br.ufg.inf.spring.model.entidades.Carro;
import br.ufg.inf.spring.model.repositorio.CarroRepositorio;


@RestController
@RequestMapping(value="/carros")
public class CarroServico {
	
	@Autowired
	private CarroNegocio negocio;
	
	@GetMapping
	public ResponseEntity<List<Carro>> findAll(){
		
		List<Carro> list = negocio.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Carro> findById(@PathVariable Integer id){
		Carro retorno = null;
		try {
			retorno = negocio.findById(id);
			return ResponseEntity.status(HttpStatus.OK).body(retorno);
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(retorno);
		}
		
	}
	
	
	@PostMapping
	public ResponseEntity<Carro> insert(@RequestBody Carro carro){
		try {
			carro = negocio.insert(carro);
			return ResponseEntity.status(HttpStatus.CREATED).body(carro);
		} catch (CarroException e) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(carro);
		}
		//URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(carro.getIdCarro()).toUri();
		
		
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete (@PathVariable Integer id){
		try {
			negocio.delete(id);
			return ResponseEntity.noContent().build();
		} catch (NotFoundException e) {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Carro> update(@PathVariable Integer id, @RequestBody Carro carro){
		try{
			carro = negocio.update(carro);
			return ResponseEntity.status(HttpStatus.CREATED).body(carro);
		} catch (CarroException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(carro);	
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(carro);
		}
		
	}
	
	
	@GetMapping(value="/nome/{str}")
	public ResponseEntity<Carro> buscaPorNome(@PathVariable String str){
		Carro carro = null;
		try {
			carro = negocio.findByNome(str);
			return ResponseEntity.status(HttpStatus.OK).body(carro);
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(carro);
		}
		
	}
	
	@GetMapping(value="/filtro/{str}")
	public ResponseEntity<List<Carro>> FiltrPorNome(@PathVariable String str){
		List<Carro> carros = null;
		try {
			carros = negocio.findAllNome(str);
			return ResponseEntity.status(HttpStatus.OK).body(carros);
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(carros);
		}
		
	}
	
	@GetMapping(value="ordem")
	public ResponseEntity<List<Carro>> findAllOrderNome(){
		
		List<Carro> list = negocio.findAllOrderNome();
		return ResponseEntity.ok().body(list);
	}
	
	
}
