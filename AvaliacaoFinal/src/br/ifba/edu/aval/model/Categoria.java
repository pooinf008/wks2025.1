package br.ifba.edu.aval.model;

public record Categoria(Sexo sexo, Dificuldade dificuldade, Idade idade) {
	public String toString() {
		return this.sexo().toString() + this.dificuldade().toString() + this.idade().toString(); 
	}
}
