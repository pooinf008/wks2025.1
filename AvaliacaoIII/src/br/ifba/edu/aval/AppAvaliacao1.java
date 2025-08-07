package br.ifba.edu.aval;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.model.Mapa;
import br.ifba.edu.aval.model.Sinaletica;

public class AppAvaliacao1 extends AppAvaliacaoBase{
	
	public void aval() throws AtividadeNaoPermitidaException {
		System.out.println("* AVALIAÇÃO I ****************************");
		this.questao1();
		this.questao2();
	}	
	
	public void questao1() {
		System.out.println("******************************************");
		System.out.println("QUESTÃO 1");
		System.out.println("******************************************");

		Mapa mapa = this.makeMapa();
		System.out.println(mapa);
		System.out.println("******************************************");
		
		Sinaletica sinaletica= this.makeSinaletica();
		System.out.println(sinaletica);
		System.out.println("******************************************");
	}
	
	public void questao2() throws AtividadeNaoPermitidaException {
		System.out.println("******************************************");
		System.out.println("QUESTÃO 2");
		System.out.println("******************************************");
		this.makeBoletinsProva();
		this.runAtleta1Aval1();
		this.runAtleta2Aval1();
		System.out.println("******************************************");
		System.out.println(this.atleta1);
		System.out.println("******************************************");
		System.out.println(this.atleta2);
		System.out.println("******************************************");
	};
	
	public static void main(String[] args) throws AtividadeNaoPermitidaException {
		new AppAvaliacao1().aval();
	}

}
