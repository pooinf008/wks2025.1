package br.ifba.edu.aval.model;

import java.util.List;

public class Mapa {
	
	private Categoria categoria;
	private Integer escala;
	private Integer ecn;
	private PontoGeografico largada;
	private PontoGeografico partida;
	private ListaPrismas prismas;
	private PontoGeografico chegada;
	
	
	public Mapa(Categoria categoria,
			   Integer escala, Integer ecn, PontoGeografico largada,
			   PontoGeografico partida, List<Prisma> prismas, PontoGeografico chegada) {
		this.categoria = categoria;
		this.escala = escala;
		this.ecn = ecn;
		this.largada = largada;
		this.partida = partida;
		this.prismas = new ListaPrismas(prismas);
		this.chegada = chegada;
	}

	public Categoria categoria() {
		return this.categoria;
	}

	public Integer escala() {
		return this.escala;
	}

	public Integer ecn() {
		return this.ecn;
	}

	public PontoGeografico largada() {
		return this.largada;
	}

	public PontoGeografico partida() {
		return this.partida;
	}


	public List<Prisma> prismas() {
		return this.prismas.prismas();
	}

	public PontoGeografico chegada() {
		return this.chegada;
	}
	
    public void adicionarPrisma(Prisma prisma) {
        this.prismas.adicionarPrisma(prisma);
    }	
    
    public void removerPrisma(Prisma prisma) {
        this.prismas.removerPrisma(prisma);
    }
    
    
    public Prisma findPrismaById(Integer id) {
    	for(Prisma prisma : this.prismas())
    		if(prisma.numero() == id)
    			return prisma;
        return null;
    }      
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Mapa:\n");
        sb.append("  - Categoria: ").append(this.categoria.sexo()).append(", ").append(this.categoria.idade()).append(", ").append(this.categoria.dificuldade()).append("\n");
        sb.append("  - Escala: 1:").append(escala).append("\n");
        sb.append("  - ECN: ").append(ecn).append("m\n");
        sb.append("  - Largada: ").append(largada).append("\n");
        sb.append("  - Partida: ").append(partida).append("\n");
        sb.append("Prismas:\n");
        for (Prisma prisma : prismas.prismas()) {
            sb.append("\t").append(prisma.toString()).append("\n");
        }
        sb.append("  - Chegada: ").append(chegada).append("\n");
        return sb.toString();
    }    

}
