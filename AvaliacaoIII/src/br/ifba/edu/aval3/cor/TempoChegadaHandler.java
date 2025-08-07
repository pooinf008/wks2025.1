package br.ifba.edu.aval3.cor;

import java.time.Duration;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
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
    protected Boolean violaRegra(BoletimProva boletim) {
    	Duration tempoChegada = boletim.getTempo(Prisma.CHEGADA);
    	if(tempoChegada == null)
    		return Boolean.TRUE;
    	return Boolean.FALSE;
    }

	@Override
	protected String getNomeRegra() {
		return "Regra Tempo de Registro de Chegada";
	}  
    
    @Override
    protected Duration tempoAdicionadoRegra(BoletimProva boletim) throws AtividadeNaoPermitidaException{
    	return boletim.getTempo(Prisma.CHEGADA);
    }

}
