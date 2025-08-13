package br.ifba.edu.aval.model;

import java.util.ArrayList;
import java.util.List;

public class ListaPrismas {
    private List<Prisma> prismas;

    public ListaPrismas() {
        this.prismas = new ArrayList<Prisma>();
    }
    
    public Integer quantidade() {
    	return this.prismas.size();
    }
    
    
    public Boolean vazio() {
    	return this.prismas.size() == 0;
    }    
    
    public ListaPrismas(List<Prisma> prismas) {
        this.prismas = prismas;
    }    

    public void adicionarPrisma(Prisma prisma) {
        this.prismas.add(prisma);
    }
    
    public void adicionarPrisma(Integer posicao, Prisma prisma) {
        this.prismas.add(posicao, prisma);
    }
    
    public Integer posicao(Prisma prisma) {
    	return this.prismas.indexOf(prisma);
    }    

    public void removerPrisma(Prisma prisma) {
        this.prismas.remove(prisma);
    }

    public Prisma findPrismaById(Integer id) {
        for (Prisma prisma : this.prismas) {
            if (prisma.numero().equals(id)) {
                return prisma;
            }
        }
        return null;
    }
    
    
    public List<Prisma> prismas(){
    	return this.prismas;
    }
    
    
    public Prisma prisma(Integer posicao){
    	return this.prismas.get(posicao);
    }    
}
