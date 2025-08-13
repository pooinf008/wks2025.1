package br.ifba.edu.aval.model;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.observer.BoletimObserver;
import br.ifba.edu.aval.observer.BoletimSubject;
import br.ifba.edu.aval1.prototype.ListaPassagens;
import br.ifba.edu.aval3.state.BoletimProvaState;
import br.ifba.edu.aval3.state.PreProvaState;

public class BoletimProva implements BoletimSubject{
	
	private String cboNumero;
	private ListaPassagens passagens;
	private Long minutoPartidaPrevisto;
	private Long minutoPartidaEfetivo;
	
	private BoletimProvaState state;
	
	private List<BoletimObserver> observers;
	
	
	public BoletimProva(String cboNumero, Long minutoPartidaPrevisto, ListaPassagens passagens) {
		super();
		this.cboNumero = cboNumero;
		this.passagens = passagens;
		this.minutoPartidaEfetivo = this.minutoPartidaPrevisto = minutoPartidaPrevisto;
		this.state = new PreProvaState();
		
		this.observers = new ArrayList<BoletimObserver>();
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
		this.notifyObservers(this);
	}	

    @Override
    public void registerObserver(BoletimObserver o) {
        this.observers.add(o);
    }

    @Override
    public void removeObserver(BoletimObserver o) {
    	this.observers.remove(o);
    }

    @Override
    public void notifyObservers(BoletimProva boletim) {
        for (BoletimObserver observer : this.observers) {
            observer.update(boletim);
        }
    }	

}
