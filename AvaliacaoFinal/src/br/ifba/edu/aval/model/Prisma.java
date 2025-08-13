package br.ifba.edu.aval.model;

import java.util.Objects;

public class Prisma {
	
	public static final Integer CHEGADA = 999;
	
	private Integer numero;
	private PontoGeografico ponto;
	private Boolean visitado;
	
	
	public Prisma(Integer numero, PontoGeografico ponto){
		this.numero = numero;
		this.ponto = ponto;
		this.visitado = Boolean.FALSE;
	}
	
	public void visitar() {
		this.visitado = Boolean.TRUE;
	}
	
	public Integer numero() {
		return this.numero;
	}
	
	public PontoGeografico ponto() {
		return this.ponto;
	}
	
	@Override
	public String toString() {
	    return String.format("%03d ", this.numero()) + ponto.toString() + (visitado ? " *" : " o");
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prisma other = (Prisma) obj;
		return Objects.equals(numero, other.numero);
	}

}
