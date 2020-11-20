package br.ufg.inf.view.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ufg.inf.dao.CarroDao;
import br.ufg.inf.dao.FabricanteDao;
import br.ufg.inf.dao.ModeloDao;
import br.ufg.inf.model.entidades.Carro;
import br.ufg.inf.model.entidades.Fabricante;
import br.ufg.inf.model.entidades.Modelo;
import br.ufg.inf.model.enumerador.TipoCarro;


public class Programa {

	public static void main(String[] args) {
		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("aula-jpa");
		EntityManager manager = managerFactory.createEntityManager();
		
		try {
			FabricanteDao fabricanteDao = new FabricanteDao(manager);
			ModeloDao modeloDao = new ModeloDao(manager);
			CarroDao carroDao = new CarroDao(manager);
			
			Fabricante ford = new Fabricante();
			ford.setFabricanteNome("Ford");
			fabricanteDao.inserir(ford);

			Fabricante volkswagen = new Fabricante();
			volkswagen.setFabricanteNome("Volkswagen");
			fabricanteDao.inserir(volkswagen);
			
			Fabricante fabricanteFord = fabricanteDao.procurarPorId(1);
			System.out.println(fabricanteFord.toString());

			Fabricante fabricanteVolkswagen = fabricanteDao.procurarPorId(2);
			System.out.println(fabricanteVolkswagen.toString());
			
			Modelo ka = new Modelo();
			ka.setFabricante(ford);
			ka.setNomeModelo("KA");
			modeloDao.inserir(ka);

			Modelo gol = new Modelo();
			gol.setFabricante(fabricanteVolkswagen);
			gol.setNomeModelo("Gol");
			modeloDao.inserir(gol);
			
			Modelo modeloKA = modeloDao.procurarPorId(1);
			System.out.println(modeloKA);

			Modelo modeloGol = modeloDao.procurarPorId(2);
			System.out.println(modeloGol);
			
			Carro carro1 = new Carro();
			carro1.setAno(2018);
			carro1.setCor("Preto");
			carro1.setPlaca("ABC-1234");
			carro1.setTipo(TipoCarro.SEDAN);
			carro1.setModelo(modeloKA);
			carroDao.inserir(carro1);

			Carro carro2 = new Carro();
			carro2.setAno(2017);
			carro2.setCor("Vermelho");
			carro2.setPlaca("OVO-3214");
			carro2.setTipo(TipoCarro.HATCH);
			carro2.setModelo(modeloGol);
			carroDao.inserir(carro2);
			
			Carro carroKA = carroDao.procurarPorId(1);
			System.out.println(carroKA.toString());

			Carro carroGol = carroDao.procurarPorId(2);
			System.out.println(carroGol.toString());
		}
		finally {
			manager.close();
			managerFactory.close();
		}
		
	}

}
		
