package br.ifba.edu.aval;

import java.util.ArrayList;
import java.util.List;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;

public class AppAvaliacaoFront {
	
	private List<AppAvaliacaoBase> avaliacoes;

	public AppAvaliacaoFront() {
		this.avaliacoes = new ArrayList<AppAvaliacaoBase>();
		this.avaliacoes.add(new AppAvaliacao1());
		this.avaliacoes.add(new AppAvaliacao2());
		this.avaliacoes.add(new AppAvaliacao3());
	}
	
	
	public void run() throws AtividadeNaoPermitidaException{
		for(AppAvaliacaoBase avaliacao : this.avaliacoes)
			avaliacao.aval();
	}
	
	public static void main(String[] args) throws AtividadeNaoPermitidaException{
		new AppAvaliacaoFront().run();
	}

}
