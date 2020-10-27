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

import br.ufg.inf.spring.ctrl.excecao.ModeloException;
import br.ufg.inf.spring.ctrl.excecao.NotFoundException;
import br.ufg.inf.spring.ctrl.negocio.ModeloNegocio;
import br.ufg.inf.spring.model.entidades.Modelo;
import br.ufg.inf.spring.model.repositorio.ModeloRepositorio;


@RestController
@RequestMapping(value="/modelos")
public class ModeloServico {
	
	@Autowired
	private ModeloNegocio negocio;
	
	@GetMapping
	public ResponseEntity<List<Modelo>> findAll(){
		
		List<Modelo> list = negocio.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Modelo> findById(@PathVariable Integer id){
		Modelo retorno = null;
		try {
			retorno = negocio.findById(id);
			return ResponseEntity.status(HttpStatus.OK).body(retorno);
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(retorno);
		}
		
	}
	
	
	@PostMapping
	public ResponseEntity<Modelo> insert(@RequestBody Modelo modelo){
		try {
			modelo = negocio.insert(modelo);
			return ResponseEntity.status(HttpStatus.CREATED).body(modelo);
		} catch (ModeloException e) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(modelo);
		}
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
	public ResponseEntity<Modelo> update(@PathVariable Integer id, @RequestBody Modelo modelo){
		try{
			modelo = negocio.update(modelo);
			return ResponseEntity.status(HttpStatus.CREATED).body(modelo);
		} catch (ModeloException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(modelo);	
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(modelo);
		}
		
	}
	
	
	@GetMapping(value="/nome/{str}")
	public ResponseEntity<Modelo> buscaPorNome(@PathVariable String str){
		Modelo modelo = null;
		try {
			modelo = negocio.findByNome(str);
			return ResponseEntity.status(HttpStatus.OK).body(modelo);
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(modelo);
		}
		
	}
	
	@GetMapping(value="/filtro/{str}")
	public ResponseEntity<List<Modelo>> FiltrPorNome(@PathVariable String str){
		List<Modelo> modelos = null;
		try {
			modelos = negocio.findAllNome(str);
			return ResponseEntity.status(HttpStatus.OK).body(modelos);
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(modelos);
		}
		
	}
	
	@GetMapping(value="ordem")
	public ResponseEntity<List<Modelo>> findAllOrderNome(){
		
		List<Modelo> list = negocio.findAllOrderNome();
		return ResponseEntity.ok().body(list);
	}
	
}
