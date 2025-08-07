package br.ifba.edu.aval1.builder;

import br.ifba.edu.aval.model.Dificuldade;
import br.ifba.edu.aval.model.Idade;
import br.ifba.edu.aval.model.PontoGeografico;
import br.ifba.edu.aval.model.Prisma;
import br.ifba.edu.aval.model.Sexo;

public interface OrientacaoBuilder {
	
	public void init();
	public void withSexo(Sexo sexo);
	public void withIdade(Idade categoria);
	public void withDificuldade(Dificuldade dificuldade);
	public void withPartidaAt(PontoGeografico partida);
	public void withLargadaAt(PontoGeografico largada);
	public void withChegadaAt(PontoGeografico chegada);
	public void addPrisma(Prisma prisma);
	public void setECN(Integer i);
	public void setEscala(Integer i);

}
