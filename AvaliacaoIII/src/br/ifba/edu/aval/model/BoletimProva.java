package br.ifba.edu.aval.model;

import java.time.Duration;
import java.util.List;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval1.prototype.ListaPassagens;
import br.ifba.edu.aval3.state.BoletimProvaState;
import br.ifba.edu.aval3.state.PreProvaState;

public class BoletimProva {
	
	public String cboNumero;
	public ListaPassagens passagens;
	public Long minutoPartidaPrevisto;
	public Long minutoPartidaEfetivo;
	
	public BoletimProvaState state;
	
	
	public BoletimProva(String cboNumero, Long minutoPartidaPrevisto, ListaPassagens passagens) {
		super();
		this.cboNumero = cboNumero;
		this.passagens = passagens;
		this.minutoPartidaEfetivo = this.minutoPartidaPrevisto = minutoPartidaPrevisto;
		this.state = new PreProvaState();
	}
	

	public List<Integer> getOrdemPrismas() {
		return this.passagens.getOrdemPassagem();
	}
	
	public String cboNumero() {
		return this.cboNumero;
	}
	
	@Override
	public String toString() {
		return "BoletimProva [cboNumero=" + cboNumero + ", passagens=" + passagens + "]";
	}	
	
	public Duration getTempo(Integer prismaID) {
		return this.passagens.getTempo(prismaID);
	}
	
	public void registrar(Integer prismaID, Duration tempo) throws AtividadeNaoPermitidaException {
		this.state.registrar(this.passagens, prismaID, tempo);
	}

	public void registrarAtrasoPartida(Long minutoPartidaEfetivo) throws AtividadeNaoPermitidaException {
		this.minutoPartidaEfetivo = this.state.registrarAtrasoEmPartida(minutoPartidaEfetivo);
	}
	
	public Long getMinutosAtraso() throws AtividadeNaoPermitidaException {
		return this.state.getMinutosAtraso(this.minutoPartidaEfetivo, this.minutoPartidaPrevisto);
	}	
	
	public void apresentarPraLargada() throws AtividadeNaoPermitidaException {
		this.state = this.state.apresentarPraLargada();
		
	}
	
	public void registrarLargada() throws AtividadeNaoPermitidaException {
		this.state = this.state.registrarLargada();
	}

	public void registrarChegada(Duration tempo) throws AtividadeNaoPermitidaException {
		this.state = this.state.registrarChegada(this.passagens, tempo);
	}	
	
	

}
