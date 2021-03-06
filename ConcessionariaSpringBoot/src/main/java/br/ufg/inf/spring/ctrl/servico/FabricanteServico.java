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

import br.ufg.inf.spring.ctrl.excecao.FabricanteException;
import br.ufg.inf.spring.ctrl.excecao.NotFoundException;
import br.ufg.inf.spring.ctrl.negocio.FabricanteNegocio;
import br.ufg.inf.spring.model.entidades.Fabricante;

@RestController
@RequestMapping(value="/fabricantes")
public class FabricanteServico {
	
	@Autowired
	private FabricanteNegocio negocio;
	
	@GetMapping
	public ResponseEntity<List<Fabricante>> findAll() {
		
		List<Fabricante> list = negocio.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Fabricante> findById(@PathVariable Integer id){
		Fabricante retorno = null;
		try {
			retorno = negocio.findById(id);
			return ResponseEntity.status(HttpStatus.OK).body(retorno);
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(retorno);
		}
		
	}
	
	
	@PostMapping
	public ResponseEntity<Fabricante> insert(@RequestBody Fabricante fabricante){
		try {
			fabricante = negocio.insert(fabricante);
			return ResponseEntity.status(HttpStatus.CREATED).body(fabricante);
		} catch (FabricanteException e) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(fabricante);
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
	public ResponseEntity<Fabricante> update(@PathVariable Integer id, @RequestBody Fabricante fabricante){
		try{
			fabricante = negocio.update(fabricante);
			return ResponseEntity.status(HttpStatus.CREATED).body(fabricante);
		} catch (FabricanteException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(fabricante);	
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(fabricante);
		}
	}
	
}
