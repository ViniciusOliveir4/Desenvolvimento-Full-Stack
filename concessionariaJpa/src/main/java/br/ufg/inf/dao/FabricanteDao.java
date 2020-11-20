package br.ufg.inf.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.ufg.inf.model.entidades.Fabricante;


public class FabricanteDao {
	
	private EntityManager manager;
	
	public FabricanteDao(EntityManager manager) {
		this.manager = manager;
	}
	
	public List<Fabricante> listar() {
		return this.manager.createQuery("FROM Fabricante", Fabricante.class).getResultList();
	}
	
	public Fabricante procurarPorId(int id) {
		return this.manager.find(Fabricante.class, id);
	}
	
	public List<Fabricante> buscarNome(String str){
		TypedQuery<Fabricante> query = this.manager.createQuery("FROM Fabricante b WHERE b.fabricanteNome LIKE :n", Fabricante.class);
		query.setParameter("n", "%"+str+"%");

		return query.getResultList();
	}
	
	public Fabricante inserir(Fabricante fabricante) {
		this.manager.getTransaction().begin();
		this.manager.persist(fabricante);
		this.manager.getTransaction().commit();

		return fabricante;
	}

	public Fabricante alterar(Fabricante fabricante) {
		return this.inserir(fabricante);
	}
	
	public Fabricante excluir(Fabricante fabricante){
		this.manager.getTransaction().begin();
		this.manager.remove(fabricante);
		this.manager.getTransaction().commit();

		return fabricante;
	}
}
