package br.ufg.inf.view.app;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.ufg.inf.model.Biblioteca;
import br.ufg.inf.model.Cidade;
import br.ufg.inf.model.entidades.Carro;
import br.ufg.inf.model.enumerador.TipoCarro;

public class Programa {

	public static void main(String[] args) {
		/*Biblioteca bib1 = new Biblioteca(null, "Cora Coralina", "Cidade de Goias", "Rua da Ponte");
		Biblioteca bib2 = new Biblioteca(null, "Machado de Assis", "Rio de Janeiro", "Cosme Velho");
		Biblioteca bib3 = new Biblioteca(null, "Olavo Bilac", "São Paulo", "Luz");
		
		System.out.println(bib1);
		System.out.println(bib2);
		System.out.println(bib3);
		*/
		/*EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula-jpa");
		EntityManager em = emf.createEntityManager();
		em.close();
		emf.close();
		*/
		/*
		em.getTransaction().begin();
		em.persist(bib1);
		em.persist(bib2);
		em.persist(bib3);
		
		//em.remove(bib2);
		em.getTransaction().commit();
	*/
		/*
		System.out.println("Buscar Biblioteca com ID 1");
		Biblioteca cora = em.find(Biblioteca.class, 1);
		System.out.println(cora);
		
		
		
		System.out.println("Buscar todas a bibliotecas");
		List<Biblioteca> bibs = em.createQuery("from Biblioteca", Biblioteca.class).getResultList();
		
		for(Biblioteca b : bibs) {
			System.out.println(b);
		}
		
			
		System.out.println("Buscar Biblioteca Machado de Assis");
		String nome = "Machado de Assis";
		TypedQuery<Biblioteca> query = em.createQuery("from Biblioteca b WHERE b.nomeBiblioteca = :n", Biblioteca.class);
		query.setParameter("n", nome);
		Biblioteca machado = query.getSingleResult();
		System.out.println(machado);
		
		System.out.println("Concluído");
		String str = "a";
		System.out.println("Buscar ocorrência "+str);
		
		query = em.createQuery("from Biblioteca b WHERE b.nomeBiblioteca LIKE :n", Biblioteca.class);
		query.setParameter("n", "%"+str+"%");
		bibs = query.getResultList();
		for(Biblioteca b : bibs) {
			System.out.println(b);
		}
		*/
		
		
		
		/**/
		
		
		
		
/*		servico.inserir(new Fabricante("Wolksvagem", null));
		servico.inserir(new Fabricante("Renault", null));
		servico.inserir(new Fabricante("Fiat", null));
		servico.inserir(new Fabricante("Chevrolet", null));*/
		
		/*
		FabricanteServico servico = new FabricanteServico();
		System.out.println("Listando as Fabricantes de Carrro");
		List<Fabricante> fabs = servico.listar();
		
		for(Fabricante f : fabs) {
			System.out.println(f);
		}
		
		System.out.println("Mostrando Transição");
		Fabricante mudanca = new Fabricante("Toyata", null);
		System.out.println(mudanca);
		servico.inserir(mudanca);
		System.out.println(mudanca);
		mudanca.setFabricanteNome(mudanca.getFabricanteNome()+" Motor");
		servico.alterar(mudanca);
		System.out.println(mudanca);
		
		fabs = servico.buscarPorNome("Toyata");
		for(Fabricante f : fabs) {
			servico.excluir(f);
		}
		*/
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula-jpa");
		EntityManager em = emf.createEntityManager();

		
		
		em.getTransaction().begin();
		
		Carro car1 = new Carro(null, TipoCarro.HATCH, "ABC5687", 2017, "Branco", mod1);
		em.persist(car1);
		Carro car2 = new Carro(null, TipoCarro.HATCH, "DED1100", 2012, "Prata", mod2);
		em.persist(car2);
		Carro car3 = new Carro(null, TipoCarro.SEDAN, "ABC5687", 2020, "Branco", mod3);
		em.persist(car3);
		Carro car4 = new Carro(null, TipoCarro.SEDAN, "OVO0050", 2015, "Vermelho", mod4);
		em.persist(car4);
		Carro car5 = new Carro(null, TipoCarro.HATCH, "HAN2020", 2019, "Branco", mod5);
		em.persist(car5);
		Carro car6 = new Carro(null, TipoCarro.HATCH, "VEM2021", 2021, "Prata", mod6);
		em.persist(car6);
		
		
		
		
		
		Biblioteca bib1 = new Biblioteca(null, "Pio Vagas", cid1, "Praça Pedro Ludovico");
		em.persist(bib1);
		Biblioteca bib2 = new Biblioteca(null, "Zeca Batista", cid2, "Praça Americano do Brasil");
		em.persist(bib2);
		Biblioteca bib3 = new Biblioteca(null, "Ponto de Leitura", cid3, "Marista Sul");
		em.persist(bib3);
		Biblioteca bib4 = new Biblioteca(null, "Cora Coralina", cid4, "Rua da Ponte");
		em.persist(bib4);
		Biblioteca bib5 = new Biblioteca(null, "Machado de Assis", cid5, "Cosme Velho");
		em.persist(bib5);
		Biblioteca bib6 = new Biblioteca(null, "Olavo Bilac", cid6, "Luz");
		em.persist(bib6);
		
		
		em.getTransaction().commit();
		
		
				
		System.out.println("Buscar Biblioteca Pio Vargas em Goiânia");
		String nome = "Pio Vargas";
		TypedQuery<Biblioteca> query = em.createQuery("from Biblioteca b WHERE b.nomeBiblioteca = :n", Biblioteca.class);
		query.setParameter("n", nome);
		Biblioteca pio = query.getSingleResult();
		System.out.println(pio);
		
		Cidade cid = pio.getCidade();
		
		em.getTransaction().begin();

		Biblioteca bibUfg = new Biblioteca(null, "Biblioteca da UFG", cid, "Campus Samambaia");
		em.persist(bibUfg);
		
		em.getTransaction().commit();
		
		System.out.println(bibUfg);
		
		
		em.close();
		emf.close();
		
		
	}

}
