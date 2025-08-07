package br.ifba.edu.aval3.cor;

import java.time.Duration;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval.model.BoletimProva;

public class Apurador {
	
	private ProcessadorBoletimHandler processador;
	
	public Apurador(Duration tempoMaximoProva) {
		this.processador = new OrdemPrismasHandler(
								new AtrasoPartidaHandler(
									new TempoChegadaHandler(
										new TodosPrismasHandler(
											new TempoMaximoHandler(tempoMaximoProva)
										)	
									)
								)
							);
	}
	
	public Duration apurar(BoletimProva boletim) throws DNFException, AtividadeNaoPermitidaException {
		Duration time = this.processador.processar(boletim);
		return time;
	}
}
