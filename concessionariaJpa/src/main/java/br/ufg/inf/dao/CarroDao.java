package br.ufg.inf.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.ufg.inf.model.entidades.Carro;


public class CarroDao {

	private EntityManager manager;
	
	public CarroDao(EntityManager manager) {
		this.manager = manager;
	}
	
	public List<Carro> listar() {
		return this.manager.createQuery("FROM Carro", Carro.class).getResultList();
	}
	
	public Carro procurarPorId(int id) {
		return this.manager.find(Carro.class, id);
	}
	
	public Carro inserir(Carro carro) {
		this.manager.getTransaction().begin();
		this.manager.persist(carro);
		this.manager.getTransaction().commit();
		
		return carro;
	}
	
	public Carro alterar(Carro carro) {
		return this.inserir(carro);
	}
	
	public Carro excluir(Carro carro) {
		this.manager.getTransaction().begin();
		this.manager.remove(carro);
		this.manager.getTransaction().commit();
		
		return carro;
	}
}
