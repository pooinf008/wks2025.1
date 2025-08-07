package br.ifba.edu.aval1.builder;

import br.ifba.edu.aval.model.Dificuldade;
import br.ifba.edu.aval.model.PontoGeografico;
import br.ifba.edu.aval.model.Prisma;

public class OrientacaoDirector {
	
	private OrientacaoBuilder builder;
	
	public OrientacaoDirector() {
		this.setOrientacaoBuilder(null);
	}	
	
	public OrientacaoDirector(OrientacaoBuilder builder) {
		this.setOrientacaoBuilder(builder);
	}
	
	public void setOrientacaoBuilder(OrientacaoBuilder builder) {
		this.builder = builder;
	}
	
	public void makePercurso01() {
		if(this.builder == null)
			return;
		this.builder.init();
		this.builder.withDificuldade(Dificuldade.N);
		this.builder.setECN(5);
		this.builder.setEscala(5000);
		this.builder.withPartidaAt(new PontoGeografico(-12.99759, -38.47413, 0.0));
		this.builder.addPrisma(new Prisma(31, new PontoGeografico(-12.99747, -38.47435, 0.0)));
		this.builder.addPrisma(new Prisma(32, new PontoGeografico(-12.99825, -38.47526, 0.0)));
		this.builder.addPrisma(new Prisma(33, new PontoGeografico(-12.99176, -38.47441, 0.0)));
		this.builder.addPrisma(new Prisma(34, new PontoGeografico(-12.99788, -38.47363, 0.0)));
		this.builder.addPrisma(new Prisma(35, new PontoGeografico(-12.99769, -38.47312, 0.0)));
		this.builder.addPrisma(new Prisma(36, new PontoGeografico(-12.99696, -38.47244, 0.0)));
		this.builder.addPrisma(new Prisma(37, new PontoGeografico(-12.99641, -38.47240, 0.0)));
		this.builder.addPrisma(new Prisma(38, new PontoGeografico(-12.99684, -38.47436, 0.0)));
		this.builder.withChegadaAt(new PontoGeografico(-12.99701, -38.47424, 0.0));
		
	}
	
	
	
	

}
