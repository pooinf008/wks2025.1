package br.ifba.edu.aval3.cor;

import java.time.Duration;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
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
    protected Boolean violaRegra(BoletimProva boletim) {
    	Duration tempoChegada = boletim.getTempo(Prisma.CHEGADA);
    	if(tempoChegada != null)
    		if(tempoChegada.compareTo(this.tempoLimite) > 0)
    		return Boolean.TRUE;
    	return Boolean.FALSE;
    }

	@Override
	protected String getNomeRegra() {
		return "Regra Tempo Máximo de Chegada";
	}  
    
    @Override
    protected Duration tempoAdicionadoRegra(BoletimProva boletim) throws AtividadeNaoPermitidaException{
    	return Duration.ZERO;
    }
    
    
}
