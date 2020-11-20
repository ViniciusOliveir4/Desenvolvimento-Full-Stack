package aula01.sistemaBancario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CadastrarCliente {

	public static void main(String[] args) {
		
		Double total=0.00;
		ArrayList<Conta> c = new ArrayList<Conta>();
		
		c.add(new ContaPoupanca(new PessoaFisica(0001, "Maria", "Avenida T-9, 1525", 159263478, new Date(1990, 10, 7), "Feminino"), 1001, 495.25));
		c.add(new ContaPoupanca(new PessoaFisica(0002, "Paulo", "Rua do Sol, 23", 246963521, new Date(2000, 5, 21), "Masculino"), 1050, 15010.23));
		c.add(new ContaEspecial(new PessoaJuridica(0007, "Solução S/A", "Avenida Cesar Lates, 254", 635214, "Diretor"), 9001, 250.00, 1500.00));
		c.add(new ContaEspecial(new PessoaJuridica(0021, "Ordem e Negócios", "Rua dos comércios, 1114", 985642, "Auxiliar Administrativo"), 9010, 1250.00, 3000.00));


		System.out.println("--------------------------");
		System.out.println(c.get(1).getSaldo());
		c.get(1).sacar(100.0);
		System.out.println("--------------------------");
		System.out.println(c.get(0).getSaldo());
		c.get(0).depositar(200.0);
		
		System.out.println("--------------------------");
		System.out.println(c.get(3).getSaldo());
		c.get(3).transferir(1000.0, c.get(2));
		System.out.println("Ordem e Negócios: " +c.get(3).getSaldo());
		System.out.println("Solução S/A: " +c.get(2).getSaldo());
		

		
		for(int i=0; i<c.size(); i++) {
			System.out.println(c.get(i).toString());
			total += c.get(i).getSaldo();
		}
		
		System.out.println("---------------------");
		System.out.println("Total: R$ "+ total);
		

		

	}

}
