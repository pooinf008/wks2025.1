package br.ifba.edu.aval.model;

import java.util.List;

public class Sinaletica{
	
	public static final Double METROS_POR_GRAU = 111320.0; 	
	
	private Categoria categoria;
	private ListaPrismas prismas;
	private PontoGeografico partida;
	private PontoGeografico chegada;
	
	
	public Sinaletica(Categoria categoria,		   
			          List<Prisma> prismas, 
			          PontoGeografico partida,
			          PontoGeografico chegada) {
		this.categoria = categoria;
		this.prismas = new ListaPrismas(prismas);
		this.partida = partida;
		this.chegada = chegada;
	}	
	
	
	public Double distancia() {
		Double distancia = this.partida.distancia(this.prismas.prisma(0).ponto());
		for(int iCont = 0; iCont < this.prismas.quantidade() - 1; iCont++)
			distancia+= this.prismas.prisma(iCont).ponto().distancia(this.prismas.prisma(iCont + 1).ponto());		
		distancia *=  Sinaletica.METROS_POR_GRAU;
		return distancia;			
		
	}
	
	public Double amplitude() {
		Double desnivel = this.partida.amplitude(this.prismas.prisma(0).ponto());
		for(int iCont = 0; iCont < this.prismas.quantidade() - 1; iCont++) {
			Double novoDesnivel = this.prismas.prisma(iCont).ponto().amplitude(this.prismas.prisma(iCont + 1).ponto()); 
			if(desnivel < novoDesnivel)
				desnivel = novoDesnivel; 
		}
		return desnivel;
	}
	
    public void adicionarPrisma(Prisma prisma) {
        this.prismas.adicionarPrisma(prisma);
    }	
    
    public void adicionarPrisma(Integer ordem, Prisma prisma) {
        this.prismas.adicionarPrisma(ordem, prisma);
    }	    
    
    public void removerPrisma(Prisma prisma) {
        this.prismas.removerPrisma(prisma);
    }
    
    public Integer ordem(Prisma prisma) {
        return this.prismas.posicao(prisma);
    }    
    
    
    public Prisma findPrismaById(Integer id) {
    	for(Prisma prisma : this.prismas.prismas())
    		if(prisma.numero() == id)
    			return prisma;
        return null;
    }	
    
    
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(this.categoria.toString())
		  .append(" - Distância: ").append(String.format("%.2f", this.distancia())).append("m")
		  .append(" - Amplitude: ").append(String.format("%.2f", this.amplitude())).append("m")
		  .append("\n");

		sb.append("Prismas:\n");
		sb.append("\t").append("|>");
		if (this.prismas != null && !this.prismas.vazio()) {
			this.prismas.prismas().forEach(prisma -> 
				sb.append("\t").append(prisma.numero())
			);
		} else {
			sb.append("\tNenhum prisma cadastrado.");
		}
		sb.append("\t").append("o");
		
		return sb.toString();
	}

}
