package aula01.sistemaBancario;

import java.util.Random;

public class ContaEspecial extends Conta {
	
	private Double limite;
	
	public ContaEspecial (Pessoa cliente, Integer nrConta, Double saldo,
			Double limite) {
		super(cliente, nrConta, saldo);
		this.limite = limite;
	}

	public Double getLimite() {
		return limite;
	}

	public void setLimite(Double limite) {
		this.limite = limite;
	}
	
	protected Boolean temSaldo(Double valor) {
		return (valor <= (this.getSaldo() + this.limite));
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(super.toString());
		sb.append("\nLimite: " + this.getLimite());
		return sb.toString();
	}
}
