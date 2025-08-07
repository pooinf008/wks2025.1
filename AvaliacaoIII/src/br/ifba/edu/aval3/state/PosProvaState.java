package br.ifba.edu.aval3.state;

import java.time.Duration;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval1.prototype.ListaPassagens;

public class PosProvaState extends AbstractBoletimProvaState implements BoletimProvaState {

	@Override
	public BoletimProvaState registrarChegada(ListaPassagens passagens, Duration tempo)
			throws AtividadeNaoPermitidaException {
		return this;
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
