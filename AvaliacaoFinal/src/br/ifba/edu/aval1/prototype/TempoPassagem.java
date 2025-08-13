package br.ifba.edu.aval1.prototype;

import java.time.Duration;
import java.util.Objects;

import br.ifba.edu.aval.model.Prisma;

public class TempoPassagem implements Cloneable{
	
	private Prisma prisma;
	private Duration tempo; 

	public TempoPassagem(Prisma prisma) {
		this.prisma = prisma;
		this.tempo = null;
	}
	
	public TempoPassagem(Prisma prisma, Duration tempo) {
		this.prisma = prisma;
		this.tempo = tempo;
	}
	
	public TempoPassagem(TempoPassagem tempo) {
		this.prisma = tempo.prisma();
		this.tempo = tempo.tempo();
	}
	
	
	public Prisma prisma() {
		return this.prisma;
	}
	
	public Duration tempo() {
		return this.tempo;
	}
	
	public void setTempo(Duration tempo) {
		this.tempo = tempo;
	}
	
	
	public Cloneable clone() {
		return new TempoPassagem(this);
	}

	@Override
	public String toString() {
		return "TempoPassagem [prisma=" + prisma + ", tempo=" + tempo + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(prisma);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TempoPassagem other = (TempoPassagem) obj;
		return Objects.equals(prisma, other.prisma);
	}
	
	
	
	
	
}
