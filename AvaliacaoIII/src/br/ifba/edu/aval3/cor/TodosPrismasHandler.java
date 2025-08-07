package br.ifba.edu.aval3.cor;

import java.time.Duration;
import java.util.List;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
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
    protected Boolean violaRegra(BoletimProva boletim) {
    	List<Integer> ordemPrismas = boletim.getOrdemPrismas();
    	
    	for(int iCont = 0; iCont < ordemPrismas.size() - 1; iCont++) {
    		Duration tempo = boletim.getTempo(ordemPrismas.get(iCont));
    		if(ordemPrismas.get(iCont) != Prisma.CHEGADA && tempo == null)
    			return Boolean.TRUE;
    	}
    	return Boolean.FALSE;
    }
    
	@Override
	protected String getNomeRegra() {
		return "Regra Todos os Prismas Registrados";
	}  
    
    @Override
    protected Duration tempoAdicionadoRegra(BoletimProva boletim) throws AtividadeNaoPermitidaException{
    	return Duration.ZERO;
    }    
    
}
