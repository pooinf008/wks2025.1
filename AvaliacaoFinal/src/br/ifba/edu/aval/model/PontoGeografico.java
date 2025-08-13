package br.ifba.edu.aval.model;

public record PontoGeografico(Double latitude, Double longitude, Double altura) {

	public Double distancia(PontoGeografico ponto) {
		return Math.sqrt(Math.pow(ponto.latitude() - this.latitude(), 2) + 
			   Math.pow(ponto.longitude() - this.longitude(), 2));
	}		
	
	public Double amplitude(PontoGeografico ponto) {
		return Math.abs(this.altura() - ponto.altura());
	}		
	
	@Override
	public String toString() {
	    return String.format("(%.5f, %.5f) - h: %.2f", this.latitude(), this.longitude(), this.altura());
	}
	
}
