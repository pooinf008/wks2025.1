package br.ifba.edu.aval2.bridge;

import br.ifba.edu.aval.model.BoletimProva;
import br.ifba.edu.aval.model.Mapa;
import br.ifba.edu.aval.model.PontoGeografico;
import br.ifba.edu.aval.model.Prisma;

public class ExportadorMapaCompleto extends ExportadorMapaSimplificado {

	public BoletimProva boletim;
	
    public ExportadorMapaCompleto(GeradorMapa gerador, BoletimProva boletim) {
        super(gerador);
    }

    public String adicionarPartida(PontoGeografico partida) {
    	return this.gerador.adicionarPonto("partida", partida);
    }
    
    public String adicionarChegada(PontoGeografico chegada) {
    	return this.gerador.adicionarPonto("chegada", chegada);
    }
    
    public String adicionarPrisma(Prisma prisma) {
    	return this.gerador.adicionarPonto("prima", prisma.ponto()) + this.gerador.adicionarTexto(prisma.ponto(), prisma.numero().toString());
    }
    
    public String adicionarMetadados(String metadado) {
    	return gerador.adicionarMetadados(metadado);
    }

    @Override
    public String exportar(Mapa mapa) {
        StringBuilder sb = new StringBuilder();
        sb.append(gerador.iniciarDocumento());
        sb.append(gerador.adicionarAreaMapa(mapa));
        sb.append(this.adicionarMetadados(mapa.categoria().toString()));
        sb.append(this.adicionarPartida(mapa.partida()));
        sb.append(this.adicionarChegada(mapa.chegada()));
        for(Prisma prisma : mapa.prismas())
        	sb.append(this.adicionarPrisma(prisma));
        sb.append(gerador.finalizarDocumento());
        return sb.toString().replace(",\n}", "\n}"); 
    }
}