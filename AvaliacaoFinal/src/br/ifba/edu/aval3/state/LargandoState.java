package br.ifba.edu.aval3.state;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;

public class LargandoState extends AbstractBoletimProvaState implements BoletimProvaState {

	@Override
	public BoletimProvaState apresentarPraLargada() 
			throws AtividadeNaoPermitidaException {
		return this;
	}

	@Override
	public BoletimProvaState registrarLargada() 
			throws AtividadeNaoPermitidaException {
		return new NaPistaState();
	}

	@Override
	public Long registrarAtrasoEmPartida(Long minutoPartidaEfetivo) throws AtividadeNaoPermitidaException {
		return minutoPartidaEfetivo;
	}

	@Override
	public Long getMinutosAtraso(Long minutoPartidaEfetivo, Long minutoPartidaPrevisto)
			throws AtividadeNaoPermitidaException {
		return minutoPartidaEfetivo - minutoPartidaPrevisto;
	}




}
