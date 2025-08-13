package br.ifba.edu.aval3.cor;

import java.time.Duration;

import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval.model.BoletimProva;
import br.ifba.edu.aval.model.Prisma;


public class TempoChegadaHandler extends ProcessadorBoletimHandler {
	
    public TempoChegadaHandler(ProcessadorBoletimHandler proximo) {
    	super(proximo);
    }
    
    public TempoChegadaHandler() {
    	super();
    }	
	
    @Override
    public Duration doProcessar(BoletimProva boletim) throws DNFException{
    	Duration tempoChegada = boletim.getTempo(Prisma.CHEGADA);
    	if(tempoChegada == null)
    		throw new DNFException("Atleta não registrou chegada");
    	return tempoChegada;
    }
}
