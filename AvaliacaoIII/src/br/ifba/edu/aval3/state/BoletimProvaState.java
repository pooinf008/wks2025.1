package br.ifba.edu.aval3.state;

import java.time.Duration;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval1.prototype.ListaPassagens;

public interface BoletimProvaState {
	
	public BoletimProvaState apresentarPraLargada() throws AtividadeNaoPermitidaException;
	public BoletimProvaState registrarLargada() throws AtividadeNaoPermitidaException;
	public BoletimProvaState registrarChegada(ListaPassagens passagens, Duration tempo) throws AtividadeNaoPermitidaException;
	public void registrar(ListaPassagens passagens, Integer prismaID, Duration tempo) throws AtividadeNaoPermitidaException;
	public Long registrarAtrasoEmPartida(Long minutoPartidaEfetivo) throws AtividadeNaoPermitidaException;
	public Long getMinutosAtraso(Long minutoPartidaEfetivo, Long minutoPartidaPrevisto) throws AtividadeNaoPermitidaException;

}
