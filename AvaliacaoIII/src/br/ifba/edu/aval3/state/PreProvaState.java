package br.ifba.edu.aval3.state;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;

public class PreProvaState extends AbstractBoletimProvaState implements BoletimProvaState{

	@Override
	public BoletimProvaState apresentarPraLargada() 
			throws AtividadeNaoPermitidaException {
		return new LargandoState();
	}
	

}
