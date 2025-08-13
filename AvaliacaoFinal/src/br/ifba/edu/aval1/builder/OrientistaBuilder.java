package br.ifba.edu.aval1.builder;

import java.util.ArrayList;
import java.util.List;

import br.ifba.edu.aval.model.Categoria;
import br.ifba.edu.aval.model.Dificuldade;
import br.ifba.edu.aval.model.Idade;
import br.ifba.edu.aval.model.Mapa;
import br.ifba.edu.aval.model.Orientista;
import br.ifba.edu.aval.model.PontoGeografico;
import br.ifba.edu.aval.model.Prisma;
import br.ifba.edu.aval.model.Sexo;
import br.ifba.edu.aval.model.Sinaletica;
import br.ifba.edu.aval1.prototype.BoletimProvaFactory;

public class OrientistaBuilder implements OrientacaoBuilder{
	
	
	private static final Integer MAPA_BUILDER_NDX = 0;
	private static final Integer SINALETICA_BUILDER_NDX = 1;
	private static final Integer LISTAPASSAGENS_BUILDER_NDX = 2;
	
	private Sexo sexo;
	private Idade idade;
	private Dificuldade dificuldade;
	private List<OrientacaoBuilder> builders;
	
	
	public OrientistaBuilder() {
		this.builders = new ArrayList<OrientacaoBuilder>();
		this.builders.add(OrientistaBuilder.MAPA_BUILDER_NDX, new MapaBuilder());
		this.builders.add(OrientistaBuilder.SINALETICA_BUILDER_NDX, new SinaleticaBuilder());
		this.builders.add(OrientistaBuilder.LISTAPASSAGENS_BUILDER_NDX, new ListaPassagensBuilder());
	}
	
	
	public void init() {
		this.sexo = Sexo.D;
		this.idade = Idade.INFANTIL;
		this.dificuldade = Dificuldade.N;
		for(OrientacaoBuilder builder : builders)
			builder.init();
		
	}

	@Override
	public void withSexo(Sexo sexo) {
		this.sexo = sexo;
		for(OrientacaoBuilder builder : builders)
			builder.withSexo(sexo);
	}

	@Override
	public void withIdade(Idade idade) {
		this.idade = idade;
		for(OrientacaoBuilder builder : builders)
			builder.withIdade(idade);		
	}
	
	@Override
	public void withDificuldade(Dificuldade dificuldade) {
		this.dificuldade = dificuldade;
		for(OrientacaoBuilder builder : builders)
			builder.withDificuldade(dificuldade);	
	}	

	@Override
	public void withPartidaAt(PontoGeografico partida) {
		for(OrientacaoBuilder builder : builders)
			builder.withPartidaAt(partida);			
	}

	@Override
	public void withLargadaAt(PontoGeografico largada) {
		for(OrientacaoBuilder builder : builders)
			builder.withLargadaAt(largada);			
	}

	@Override
	public void withChegadaAt(PontoGeografico chegada) {
		for(OrientacaoBuilder builder : builders)
			builder.withChegadaAt(chegada);	
	}

	@Override
	public void addPrisma(Prisma prisma) {
		for(OrientacaoBuilder builder : builders)
			builder.addPrisma(prisma);	
	}
	
	public void setEscala(Integer escala) {
		for(OrientacaoBuilder builder : builders)
			builder.setEscala(escala);	
	}
	
	public void setECN(Integer ecn) {
		for(OrientacaoBuilder builder : builders)
			builder.setECN(ecn);	
	}
	
	public Orientista get(String cboNumero, Long minutoPartida) {
		Mapa mapa = ((MapaBuilder)this.builders.get(OrientistaBuilder.MAPA_BUILDER_NDX)).get();
		Sinaletica sinaletica = ((SinaleticaBuilder)this.builders.get(OrientistaBuilder.SINALETICA_BUILDER_NDX)).get();
		((ListaPassagensBuilder)this.builders.get(OrientistaBuilder.LISTAPASSAGENS_BUILDER_NDX)).make();
		
		return new Orientista(cboNumero, 
							  new Categoria(this.sexo, this.dificuldade, this.idade),
							  sinaletica,
							  mapa,
							  BoletimProvaFactory.instance().getBoletim(cboNumero, this.sexo, this.idade, this.dificuldade, minutoPartida));
	}

	
	

}
