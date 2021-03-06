package aula02.br.ufg.inf.model.entidade;

public class Pessoa {
	
	private Integer id;
	private String nome;
	private String endereco;
	
	public Pessoa (Integer id, String nome, String endereco) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEnderešo() {
		return endereco;
	}
	public void setEnderešo(String enderešo) {
		this.endereco = enderešo;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\nID: " + this.getId());
		sb.append("\nNome: " + this.getNome());
		sb.append("\nEnderešo: " + this.getEnderešo());
		return sb.toString();
	}
	
}
