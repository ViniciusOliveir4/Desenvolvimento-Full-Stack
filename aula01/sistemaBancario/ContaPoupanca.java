package aula01.sistemaBancario;

public class ContaPoupanca extends Conta {
	
	private Double txCorrecao;
	
	public ContaPoupanca (Pessoa cliente, Integer nrConta, Double saldo) {
		super(cliente, nrConta, saldo);
	}

	public Double getTxCorrecao() {
		return txCorrecao;
	}

	public void setTxCorrecao(Double txCorrecao) {
		this.txCorrecao = txCorrecao;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(super.toString());
		sb.append("\nTaxa de Correção: " + this.getTxCorrecao());
		return sb.toString();
	}

}
