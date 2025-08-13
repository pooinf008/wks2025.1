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
    
    public final Duration processar(BoletimProva boletim) throws DNFException, AtividadeNaoPermitidaException {
    	Duration duration = Duration.ZERO;
    	if(ehAplicavel(boletim))
    		duration = duration.plus(this.doProcessar(boletim));
        if (proximoHandler != null) 
        	duration = duration.plus(proximoHandler.processar(boletim));
        return duration;	
    }
    
    public Boolean ehAplicavel(BoletimProva boletim) {
    	return Boolean.TRUE;
    };
    

    public abstract Duration doProcessar(BoletimProva boletim) throws DNFException, AtividadeNaoPermitidaException;
}


