package br.ifba.edu.aval3.cor;

import java.time.Duration;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval.model.BoletimProva;

public class AtrasoPartidaHandler extends ProcessadorBoletimHandler {
	
    public AtrasoPartidaHandler(ProcessadorBoletimHandler proximo) {
    	super(proximo);
    }
    
    public AtrasoPartidaHandler() {
    	super();
    }	
	
    @Override
    public Duration doProcessar(BoletimProva boletim) throws DNFException, AtividadeNaoPermitidaException{
    	return Duration.ZERO.plus(Duration.ofMinutes(boletim.getMinutosAtraso()));
    }
}
