package br.ufg.inf.model.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fabricante implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="fabricante_Id")
	private Integer fabricanteId;
	
	@Column(name="fabricante_Nome")
	private String fabricanteNome;
	
	
	public Fabricante(Integer fabricanteId, String fabricanteNome) {
		super();
		this.fabricanteNome = fabricanteNome;
		this.fabricanteId = fabricanteId;
	}
	
	public String getFabricanteNome() {
		return fabricanteNome;
	}
	
	public void setFabricanteNome(String fabricanteNome) {
		this.fabricanteNome = fabricanteNome;
	}
	
	public Integer getFabricanteId() {
		return fabricanteId;
	}
	
	public void setFabricanteId(Integer fabricanteId) {
		this.fabricanteId = fabricanteId;
	}
	
	@Override
	public String toString() {
		return "Fabricante "+ fabricanteNome;
	}
}
