package br.ifba.edu.aval;

import java.time.Duration;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.model.BoletimProva;
import br.ifba.edu.aval.model.Dificuldade;
import br.ifba.edu.aval.model.Idade;
import br.ifba.edu.aval.model.Mapa;
import br.ifba.edu.aval.model.Sexo;
import br.ifba.edu.aval.model.Sinaletica;
import br.ifba.edu.aval1.builder.ListaPassagensBuilder;
import br.ifba.edu.aval1.builder.MapaBuilder;
import br.ifba.edu.aval1.builder.OrientacaoDirector;
import br.ifba.edu.aval1.builder.SinaleticaBuilder;
import br.ifba.edu.aval1.prototype.BoletimProvaFactory;

public abstract class AppAvaliacaoBase {
	
	protected BoletimProva atleta1; 
	protected BoletimProva atleta2;
	protected BoletimProva atleta3;
	protected BoletimProva atleta4;
	protected BoletimProva atleta5;
	
	protected MapaBuilder mapaBuilder;
	protected SinaleticaBuilder sinaleticaBuilder;	
	protected ListaPassagensBuilder listaPassagensBuilder;
	protected OrientacaoDirector director;
	
	public abstract void aval() throws AtividadeNaoPermitidaException;
	
	public AppAvaliacaoBase() {
		this.director = new OrientacaoDirector();
	}
	
	public Mapa makeMapa() {
		this.mapaBuilder = new MapaBuilder();
		director.setOrientacaoBuilder(this.mapaBuilder);
		this.director.makePercurso01();
		return this.mapaBuilder.get();
	}
	
	public Sinaletica makeSinaletica() {
		this.sinaleticaBuilder = new SinaleticaBuilder();
		director.setOrientacaoBuilder(this.sinaleticaBuilder);
		director.makePercurso01();
		return this.sinaleticaBuilder.get();
	}
	
	public void makeBoletinsProva() {
		this.listaPassagensBuilder = new ListaPassagensBuilder();
		this.director = new OrientacaoDirector(this.listaPassagensBuilder);
		this.director.makePercurso01();
		this.listaPassagensBuilder.make();
	}
	
	public void runAtleta1Aval1() throws AtividadeNaoPermitidaException {

		this.atleta1 = BoletimProvaFactory.instance().getBoletim("12000", Sexo.D, Idade.INFANTIL, Dificuldade.N, 10L);
		this.atleta1.apresentarPraLargada();
		this.atleta1.registrarLargada();
		this.atleta1.registrar(31, Duration.ofSeconds(130));
		this.atleta1.registrar(32, Duration.ofSeconds(150));
		this.atleta1.registrar(33, Duration.ofSeconds(165));
		this.atleta1.registrar(34, Duration.ofSeconds(190));
	}
	
	public void runAtleta2Aval1() throws AtividadeNaoPermitidaException {
		this.atleta2 = BoletimProvaFactory.instance().getBoletim("13000", Sexo.D, Idade.INFANTIL, Dificuldade.N, 11L);
		this.atleta2.apresentarPraLargada();
		this.atleta2.registrarLargada();
		this.atleta2.registrar(31, Duration.ofSeconds(125));
		this.atleta2.registrar(32, Duration.ofSeconds(160));
		this.atleta2.registrar(33, Duration.ofSeconds(170));
		this.atleta2.registrar(34, Duration.ofSeconds(180));
		this.atleta2.registrarChegada(Duration.ofSeconds(185));
	}
	
	
	public void runAtleta3Aval3() throws AtividadeNaoPermitidaException {
		this.atleta3 = BoletimProvaFactory.instance().getBoletim("14000", Sexo.D, Idade.INFANTIL, Dificuldade.N, 12L);
		this.atleta3.registrar(31, Duration.ofSeconds(110));
		this.atleta3.registrar(32, Duration.ofSeconds(115));
		this.atleta3.registrar(33, Duration.ofSeconds(165));
		this.atleta3.registrar(34, Duration.ofSeconds(190));
		this.atleta3.registrarChegada(Duration.ofSeconds(200));
	}
	
	public void runAtleta4Aval3() throws AtividadeNaoPermitidaException {
		this.atleta4 = BoletimProvaFactory.instance().getBoletim("15000", Sexo.D, Idade.INFANTIL, Dificuldade.N, 13L);
		this.atleta4.apresentarPraLargada();
		this.atleta4.registrarAtrasoPartida(14L);
		this.atleta4.registrarLargada();
		this.atleta4.registrar(31, Duration.ofSeconds(112));
		this.atleta4.registrar(32, Duration.ofSeconds(120));
		this.atleta4.registrar(33, Duration.ofSeconds(165));
		this.atleta4.registrar(34, Duration.ofSeconds(180));
		this.atleta4.registrar(35, Duration.ofSeconds(210));
		this.atleta4.registrar(36, Duration.ofSeconds(225));
		this.atleta4.registrar(37, Duration.ofSeconds(230));
		this.atleta4.registrar(38, Duration.ofSeconds(300));
		this.atleta4.registrar(39, Duration.ofSeconds(360));
		this.atleta4.registrarChegada(Duration.ofSeconds(365));
	}
	
	public void runAtleta5Aval3() throws AtividadeNaoPermitidaException {
		this.atleta5 = BoletimProvaFactory.instance().getBoletim("15000", Sexo.D, Idade.INFANTIL, Dificuldade.N, 14L);
		this.atleta5.apresentarPraLargada();
		this.atleta5.registrarLargada();
		this.atleta5.registrar(32, Duration.ofSeconds(108));
		this.atleta5.registrar(31, Duration.ofSeconds(112));
		this.atleta5.registrar(33, Duration.ofSeconds(155));
		this.atleta5.registrar(34, Duration.ofSeconds(160));
		this.atleta5.registrarChegada(Duration.ofSeconds(175));
	}	
	
	

}
