package br.ifba.edu.aval3.cor;

import java.time.Duration;
import java.util.List;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.model.BoletimProva;


public class OrdemPrismasHandler extends ProcessadorBoletimHandler {
	
    public OrdemPrismasHandler(ProcessadorBoletimHandler proximo) {
    	super(proximo);
    }
    
    public OrdemPrismasHandler() {
    	super();
    }	
    
    @Override
    protected Boolean violaRegra(BoletimProva boletim) {
    	List<Integer> ordemPrismas = boletim.getOrdemPrismas();
    	
    	for(int iCont = 0; iCont < ordemPrismas.size() - 1; iCont++) {
    		Duration anterior = boletim.getTempo(ordemPrismas.get(iCont));
    		Duration atual = boletim.getTempo(ordemPrismas.get(iCont+1));
    		if(anterior != null && atual != null)
    			if(anterior.compareTo(atual) > 0)
    				return Boolean.TRUE;
    	}
    	return Boolean.FALSE;
    }
    
    @Override
    protected Duration tempoAdicionadoRegra(BoletimProva boletim) throws AtividadeNaoPermitidaException{
    	return Duration.ZERO;
    }

	@Override
	protected String getNomeRegra() {
		return "Regra de Ordem dos Prismas";
	} 
	
}
