package br.ifba.edu.aval3.cor;

import java.time.Duration;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.model.BoletimProva;

public class AtrasoPartidaHandler extends ProcessadorBoletimHandler {
	
    public AtrasoPartidaHandler(ProcessadorBoletimHandler proximo) {
    	super(proximo);
    }
    
    public AtrasoPartidaHandler() {
    	super();
    }	
	
    @Override
    protected Duration tempoAdicionadoRegra(BoletimProva boletim) throws AtividadeNaoPermitidaException{
		return Duration.ofMinutes(boletim.getMinutosAtraso());
    }

	@Override
	protected String getNomeRegra() {
		return "Penalidade por Atraso na Partida";
	}
}
