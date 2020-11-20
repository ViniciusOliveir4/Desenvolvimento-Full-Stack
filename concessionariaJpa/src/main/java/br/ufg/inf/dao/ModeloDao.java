package br.ufg.inf.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ufg.inf.model.entidades.Modelo;



public class ModeloDao {
	private EntityManager manager;
	
	public ModeloDao(EntityManager manager) {
		this.manager = manager;
	}
	
	public List<Modelo> listar() {
		return this.manager.createQuery("FROM Modelo", Modelo.class).getResultList();
	}
	
	public Modelo procurarPorId(int id) {
		return this.manager.find(Modelo.class, id);
	}
	
	public List<Modelo> procurarPorNome(String nome) {
		TypedQuery<Modelo> query = this.manager.createQuery("FROM Modelo m WHERE m.nome_modelo LIKE :n", Modelo.class);
		query.setParameter("n", "%" + nome + "%");
		
		return query.getResultList();
	}
	
	public Modelo inserir(Modelo modelo) {
		this.manager.getTransaction().begin();
		this.manager.persist(modelo);
		this.manager.getTransaction().commit();
		
		return modelo;
	}
	
	public Modelo alterar(Modelo modelo) {
		return this.inserir(modelo);
	}
	
	public Modelo excluir(Modelo modelo) {
		this.manager.getTransaction().begin();
		this.manager.remove(modelo);
		this.manager.getTransaction().commit();
		
		return modelo;
	}
}