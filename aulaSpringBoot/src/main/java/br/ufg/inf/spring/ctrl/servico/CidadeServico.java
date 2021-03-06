package br.ufg.inf.spring.ctrl.servico;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.ufg.inf.spring.ctrl.negocio.CidadeNegocio;
import br.ufg.inf.spring.model.entidades.Cidade;

@RestController
@RequestMapping(value="/cidades")
public class CidadeServico {
	
	@Autowired
	private CidadeNegocio negocio;
	
	@GetMapping
	public ResponseEntity<List<Cidade>> findAll() {
		
		List<Cidade> list = negocio.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Cidade> findById(@PathVariable Integer id){
		Cidade retorno = negocio.findById(id);
		return ResponseEntity.ok(retorno);
	}
	
	
	@PostMapping
	public ResponseEntity<Cidade> insert(@RequestBody Cidade cidade){
		cidade = negocio.insert(cidade);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(cidade.getIdCidade()).toUri();
		
		return ResponseEntity.created(uri).body(cidade);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete (@PathVariable Integer id){
		negocio.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Cidade> update(@PathVariable Integer id, @RequestBody Cidade cidade){
		cidade = negocio.update(cidade);
		return ResponseEntity.ok().body(cidade);
	}
	
}
