package br.ifba.edu.aval.command;

import br.ifba.edu.aval.model.Mapa;
import br.ifba.edu.aval.model.Prisma;
import br.ifba.edu.aval.model.Sinaletica;

public class RemoverPrismaCommand implements PistaCommand {
    private Mapa mapa;
    private Prisma prismaRemovido;
    private Sinaletica sinaletica;
    private Integer posicao;

    public RemoverPrismaCommand(Mapa mapa, Sinaletica sinaletica, Integer prismaNumeroRemovido) {
        this.mapa = mapa;
        this.sinaletica = sinaletica;
        this.prismaRemovido = this.mapa.findPrismaById(prismaNumeroRemovido);
        
    }

    @Override
    public void executar() {
    	this.mapa.removerPrisma(this.prismaRemovido);
    	this.posicao = this.sinaletica.ordem(prismaRemovido);
    	this.sinaletica.removerPrisma(this.prismaRemovido);
    }

    @Override
    public void desfazer() {
        this.mapa.adicionarPrisma(this.prismaRemovido);
    	this.sinaletica.adicionarPrisma(this.posicao, this.prismaRemovido);
    	
    }
}
