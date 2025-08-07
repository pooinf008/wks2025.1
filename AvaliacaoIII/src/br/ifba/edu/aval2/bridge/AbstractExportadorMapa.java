package br.ifba.edu.aval2.bridge;

public abstract class AbstractExportadorMapa implements ExportadorMapa{
	
	protected GeradorMapa gerador; 

    public AbstractExportadorMapa(GeradorMapa gerador) {
        this.gerador = gerador;
    }
    
}
