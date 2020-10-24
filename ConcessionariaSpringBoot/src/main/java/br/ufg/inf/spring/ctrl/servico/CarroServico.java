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

import br.ufg.inf.spring.ctrl.negocio.CarroNegocio;
import br.ufg.inf.spring.model.entidades.Carro;


@RestController
@RequestMapping(value="/carros")
public class CarroServico {
	
	@Autowired
	private CarroNegocio negocio;
	
	@GetMapping
	public ResponseEntity<List<Carro>> findAll() {
		
		List<Carro> list = new ArrayList<Carro>();
		
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Carro> findById(@PathVariable Integer Id){
		Carro retorno = negocio.findById(Id);
		return ResponseEntity.ok(retorno);
	}
	
	
	@PostMapping
	public ResponseEntity<Carro> insert(@RequestBody Carro carro){
		carro = negocio.insert(carro);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(carro.getIdCarro()).toUri();
		
		return ResponseEntity.created(uri).body(carro);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete (@PathVariable Integer Id){
		negocio.delete(Id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Carro> update(@PathVariable Integer id, @RequestBody Carro carro){
		carro = negocio.update(carro);
		return ResponseEntity.ok().body(carro);
	}
	

}
