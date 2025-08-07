package br.ifba.edu.aval.model;

import java.util.Objects;

public record Prisma(Integer numero, PontoGeografico ponto) {
	
	public static final Integer CHEGADA = 999;

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
