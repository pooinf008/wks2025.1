package br.ifba.edu.aval1.prototype;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.ifba.edu.aval.model.Prisma;

public class ListaPassagens implements Cloneable{

	private List<TempoPassagem> tempos;

	public ListaPassagens() {
		this.tempos = new ArrayList<TempoPassagem>();
	}	
	
	public ListaPassagens(ListaPassagens lista) {
		this.tempos = new ArrayList<TempoPassagem>();
		for(TempoPassagem tempo : lista.tempos)
			this.tempos.add((TempoPassagem) tempo.clone());
	}
	
	public List<Integer> getOrdemPassagem(){
		return this.tempos.stream() 
                .map(TempoPassagem::prisma)
                .map(Prisma::numero)
                .collect(Collectors.toList());
	}
	
	
	public List<TempoPassagem> getTemposPassagem(){
		return this.tempos;
	}
	
	public ListaPassagens(List<TempoPassagem> tempos) {
		this.tempos = tempos;
	}
	

	public void registrarPassagem(Integer numeroPrima, Duration tempo) {
		for(TempoPassagem tempoPassagem : this.tempos)
			if(tempoPassagem.prisma().numero() == numeroPrima)
				tempoPassagem.setTempo(tempo);
	}
	
	public Duration getTempo(Integer numeroPrima) {
		for(TempoPassagem tempoPassagem : this.tempos)
			if(tempoPassagem.prisma().numero() == numeroPrima)
				return tempoPassagem.tempo();
		return null;
	}	
	
	
	public Cloneable clone() {
		return new ListaPassagens(this);
	}

	@Override
	public String toString() {
		return "ListaPassagens [tempos=" + tempos + "]";
	}
	
	
	
	
	
	
}
