package br.ifba.edu.aval3.state;

import java.time.Duration;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval1.prototype.ListaPassagens;

public class AbstractBoletimProvaState implements BoletimProvaState {

	@Override
	public BoletimProvaState apresentarPraLargada()
		throws AtividadeNaoPermitidaException {
			throw new AtividadeNaoPermitidaException("Atividade não permitida no estado atual.");
	}

	@Override
	public BoletimProvaState registrarLargada() 
		throws AtividadeNaoPermitidaException {
			throw new AtividadeNaoPermitidaException("Atividade não permitida no estado atual.");
	}

	@Override
	public BoletimProvaState registrarChegada(ListaPassagens passagens, Duration tempo)
		throws AtividadeNaoPermitidaException {
			throw new AtividadeNaoPermitidaException("Atividade não permitida no estado atual.");
	}

	@Override
	public void registrar(ListaPassagens passagens, Integer prismaID, Duration tempo)
		throws AtividadeNaoPermitidaException {
			throw new AtividadeNaoPermitidaException("Atividade não permitida no estado atual.");
	}

	@Override
	public Long registrarAtrasoEmPartida(Long minutoPartidaEfetivo)
		throws AtividadeNaoPermitidaException {
			throw new AtividadeNaoPermitidaException("Atividade não permitida no estado atual.");		
	}

	@Override
	public Long getMinutosAtraso(Long minutoPartidaEfetivo, Long minutoPartidaPrevisto)
			throws AtividadeNaoPermitidaException {
		throw new AtividadeNaoPermitidaException("Atividade não permitida no estado atual.");		
	}
}