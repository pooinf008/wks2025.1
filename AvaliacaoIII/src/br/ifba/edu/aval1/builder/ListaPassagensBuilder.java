package br.ifba.edu.aval1.builder;

import java.util.ArrayList;
import java.util.List;

import br.ifba.edu.aval.model.Dificuldade;
import br.ifba.edu.aval.model.Idade;
import br.ifba.edu.aval.model.PontoGeografico;
import br.ifba.edu.aval.model.Prisma;
import br.ifba.edu.aval.model.Sexo;
import br.ifba.edu.aval1.prototype.BoletimProvaFactory;
import br.ifba.edu.aval1.prototype.ListaPassagens;
import br.ifba.edu.aval1.prototype.TempoPassagem;

public class ListaPassagensBuilder extends AbstractOrientacaoBuilder implements OrientacaoBuilder{
	
	private Sexo sexo;
	private Idade idade;
	private Dificuldade dificuldade;
	
	private PontoGeografico largada;
	private PontoGeografico partida;
	private List<TempoPassagem> tempoPassagem; 
	private PontoGeografico chegada;	
	
	public void init() {
		this.sexo = Sexo.D;
		this.idade = Idade.INFANTIL;
		this.dificuldade = Dificuldade.N;
		this.largada = null;
		this.partida = null;
		this.chegada = null;
		this.tempoPassagem = new ArrayList<TempoPassagem>();
	}

	@Override
	public void withSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	@Override
	public void withIdade(Idade idade) {
		this.idade = idade;
	}
	
	@Override
	public void withDificuldade(Dificuldade dificuldade) {
		this.dificuldade = dificuldade;
	}	
	
	@Override
	public void withPartidaAt(PontoGeografico partida) {
		this.partida = partida;
	}

	@Override
	public void withLargadaAt(PontoGeografico largada) {
		this.largada = largada;
	}

	@Override
	public void withChegadaAt(PontoGeografico chegada) {
		this.chegada = chegada;
	}

	@Override
	public void addPrisma(Prisma prisma) {
		this.tempoPassagem.add(new TempoPassagem(prisma));
	}
	
	public void make() {

		PontoGeografico origem = null;
		
		if(this.partida == null && this.largada!= null)
			origem = this.largada;
		if(this.partida != null && this.largada== null)
			origem = this.partida;

		if(this.partida == null)
			this.partida = origem;
		if(this.largada == null)
			this.largada = origem;
		if(this.chegada == null)
			this.chegada = largada;
		
		this.tempoPassagem.add(new TempoPassagem(new Prisma(Prisma.CHEGADA, this.chegada)));
		
		BoletimProvaFactory.instance().register(this.sexo, this.idade, this.dificuldade, new ListaPassagens(this.tempoPassagem));
	}


	

}
