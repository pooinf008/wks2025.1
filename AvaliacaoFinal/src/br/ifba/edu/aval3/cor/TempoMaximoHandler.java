package br.ifba.edu.aval3.cor;

import java.time.Duration;

import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval.model.BoletimProva;
import br.ifba.edu.aval.model.Prisma;


public class TempoMaximoHandler extends ProcessadorBoletimHandler {
	
	private Duration tempoLimite; 
	
    public TempoMaximoHandler(ProcessadorBoletimHandler proximo, Duration tempoLimite) {
    	super(proximo);
    	this.tempoLimite = tempoLimite;
    }
    
    public TempoMaximoHandler(Duration tempoLimite) {
    	super();
    	this.tempoLimite = tempoLimite;
    }    
    
    public TempoMaximoHandler() {
    	super();
    }	
	
    @Override
    public Duration doProcessar(BoletimProva boletim) throws DNFException{
    	Duration tempoChegada = boletim.getTempo(Prisma.CHEGADA);
    	if(tempoChegada != null)
    		if(tempoChegada.compareTo(this.tempoLimite) > 0)
    			throw new DNFException("O atleta finalizou a prova, após o tempo limite");
    	return Duration.ZERO;
    }
}
