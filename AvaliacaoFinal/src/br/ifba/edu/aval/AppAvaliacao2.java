package br.ifba.edu.aval;

import br.ifba.edu.aval.model.Mapa;
import br.ifba.edu.aval2.bridge.ExportadorMapa;
import br.ifba.edu.aval2.bridge.ExportadorMapaSimplificado;
import br.ifba.edu.aval2.bridge.GeradorMapaSVG;
import br.ifba.edu.aval2.decorator.GeradorMapaComMarcaDagua;

public class AppAvaliacao2 extends AppAvaliacaoBase{

	public void aval() {
		System.out.println("* AVALIAÇÃO II ***************************");
		this.questao1();
		System.out.println("******************************************");
		this.questao2();
		System.out.println("******************************************");
	}

	public void questao1() {
		System.out.println("QUESTÃO 1");
		System.out.println("*** GERAÇÃO DE MAPA SIMPLIFICADO EM SVG ***");
		this.printMapa(new ExportadorMapaSimplificado(new GeradorMapaSVG()));
		System.out.println("******************************************");
	}
	
	public void questao2() {
		System.out.println("QUESTÃO 2");
		System.out.println("*** GERAÇÃO DE MAPA SIMPLIFICADO EM SVG COM MAPA D'AGUA***");
		this.printMapa(new ExportadorMapaSimplificado(new GeradorMapaComMarcaDagua(new GeradorMapaSVG())));
		System.out.println("******************************************");
	}
	
	
	public void printMapa(ExportadorMapa exportador) {
		Mapa mapa = this.makeMapa();
        System.out.println(exportador.exportar(mapa));		
	}		
	
	public static void main(String[] args) {
		new AppAvaliacao2().aval();
	}

}
