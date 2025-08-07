package br.ifba.edu.aval1.builder;

import java.util.ArrayList;
import java.util.List;

import br.ifba.edu.aval.model.Dificuldade;
import br.ifba.edu.aval.model.Idade;
import br.ifba.edu.aval.model.PontoGeografico;
import br.ifba.edu.aval.model.Prisma;
import br.ifba.edu.aval.model.Sexo;
import br.ifba.edu.aval.model.Sinaletica;

public class SinaleticaBuilder extends AbstractOrientacaoBuilder implements OrientacaoBuilder{
	
	public static final Double METROS_POR_GRAU = 111320.0; 
	
	private Sexo sexo;
	private Idade idade;
	private Dificuldade dificuldade;
	private PontoGeografico largada;
	private PontoGeografico partida;
	private List<Prisma> prismas; 
	private PontoGeografico chegada;	
	
	public void init() {
		this.sexo = Sexo.D;
		this.idade = Idade.INFANTIL;
		this.dificuldade = Dificuldade.N;
		this.largada = null;
		this.partida = null;
		this.chegada = null;
		this.prismas = new ArrayList<Prisma>();
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
		this.prismas.add(prisma);
	}
	
	public Sinaletica get() {

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
		
		Double distancia = this.partida.distancia(this.prismas.get(0).ponto());
		Double desnivel = this.partida.amplitude(this.prismas.get(0).ponto());
		
		for(int iCont = 0; iCont < this.prismas.size() - 1; iCont++)
			distancia+= this.prismas.get(iCont).ponto().distancia(this.prismas.get(iCont + 1).ponto());
		
		distancia *=  SinaleticaBuilder.METROS_POR_GRAU;
		
		for(int iCont = 0; iCont < this.prismas.size() - 1; iCont++) {
			Double novoDesnivel = this.prismas.get(iCont).ponto().amplitude(this.prismas.get(iCont + 1).ponto()); 
			if(desnivel < novoDesnivel)
				desnivel = novoDesnivel; 
		}	
		
		return new Sinaletica(this.sexo, this.idade, this.dificuldade, this.prismas, distancia, desnivel);
		
	}


	

}
