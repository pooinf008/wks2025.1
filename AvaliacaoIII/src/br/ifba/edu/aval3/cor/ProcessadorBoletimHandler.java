package br.ifba.edu.aval3.cor;

import java.time.Duration;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval.model.BoletimProva;

public abstract class ProcessadorBoletimHandler {
    protected ProcessadorBoletimHandler proximoHandler;
    
    public ProcessadorBoletimHandler(ProcessadorBoletimHandler proximo) {
    	this.setProximoHandler(proximo);
    }
    
    public ProcessadorBoletimHandler() {
    	this.setProximoHandler(null);
    }

    public void setProximoHandler(ProcessadorBoletimHandler proximoHandler) {
        this.proximoHandler = proximoHandler;
    }
    
    //TEMPLATE METHOD
    public final Duration processar(BoletimProva boletim) throws DNFException, AtividadeNaoPermitidaException{
    	Duration duration = Duration.ZERO;
    	if(this.ehAplicavel(boletim)) {
    		if(this.violaRegra(boletim))
    			throw new DNFException("Regra violada: " + this.getNomeRegra());
    		duration = duration.plus(this.tempoAdicionadoRegra(boletim));
    	}
        if (proximoHandler != null) 
        	duration = duration.plus(proximoHandler.processar(boletim));
        return duration;	
    }

    // hooks
    protected Boolean ehAplicavel(BoletimProva boletim) {
    	return Boolean.TRUE;
    };
    
    protected Boolean violaRegra(BoletimProva boletim) {
    	return Boolean.FALSE;
    };

    // primitivas
    protected abstract Duration tempoAdicionadoRegra(BoletimProva boletim) throws AtividadeNaoPermitidaException;
    protected abstract String getNomeRegra();
}


