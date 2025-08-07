package br.ifba.edu.aval1.builder;

import br.ifba.edu.aval.model.Dificuldade;
import br.ifba.edu.aval.model.Idade;
import br.ifba.edu.aval.model.PontoGeografico;
import br.ifba.edu.aval.model.Prisma;
import br.ifba.edu.aval.model.Sexo;

public class AbstractOrientacaoBuilder implements OrientacaoBuilder{

	@Override
	public void init() {
		// TODO Auto-generated method stub
	}

	@Override
	public void withSexo(Sexo sexo) {
		// TODO Auto-generated method stub
	}

	@Override
	public void withIdade(Idade idade) {
		// TODO Auto-generated method stub
	}

	@Override
	public void withDificuldade(Dificuldade dificuldade) {
		// TODO Auto-generated method stub
	}

	@Override
	public void withPartidaAt(PontoGeografico partida) {
		// TODO Auto-generated method stub
	}

	@Override
	public void withLargadaAt(PontoGeografico largada) {
		// TODO Auto-generated method stub
	}

	@Override
	public void withChegadaAt(PontoGeografico chegada) {
		// TODO Auto-generated method stub
	}

	@Override
	public void addPrisma(Prisma prisma) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setECN(Integer i) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setEscala(Integer i) {
		// TODO Auto-generated method stub
	}

}
