package br.ifba.edu.aval3.cor;

import java.time.Duration;
import java.util.List;

import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval.model.BoletimProva;
import br.ifba.edu.aval.model.Prisma;


public class TodosPrismasHandler extends ProcessadorBoletimHandler {
	
    public TodosPrismasHandler(ProcessadorBoletimHandler proximo) {
    	super(proximo);
    }
    
    public TodosPrismasHandler() {
    	super();
    }	
	
    @Override
    public Duration doProcessar(BoletimProva boletim) throws DNFException{
    	
    	List<Integer> ordemPrismas = boletim.getOrdemPrismas();
    	
    	for(int iCont = 0; iCont < ordemPrismas.size() - 1; iCont++) {
    		Duration tempo = boletim.getTempo(ordemPrismas.get(iCont));
    		if(ordemPrismas.get(iCont) != Prisma.CHEGADA && tempo == null)
    			throw new DNFException("Atleta não registrou um dos prismas.");
    	}	
    	return Duration.ZERO;
    }
}
