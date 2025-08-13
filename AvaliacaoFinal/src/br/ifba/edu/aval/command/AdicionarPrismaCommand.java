package br.ifba.edu.aval.command;

import br.ifba.edu.aval.model.Mapa;
import br.ifba.edu.aval.model.Prisma;
import br.ifba.edu.aval.model.Sinaletica;

public class AdicionarPrismaCommand implements PistaCommand {
    private Mapa mapa;
    private Sinaletica sinaletica;
    private Prisma prisma;

    public AdicionarPrismaCommand(Mapa mapa, Sinaletica sinaletica, Prisma prisma) {
        this.mapa = mapa;
        this.sinaletica = sinaletica;
        this.prisma = prisma;
    }

    @Override
    public void executar() {
        this.mapa.adicionarPrisma(prisma);
        this.sinaletica.adicionarPrisma(prisma);
    }

    @Override
    public void desfazer() {
    	this.mapa.removerPrisma(prisma);
    	this.sinaletica.removerPrisma(prisma);
    }
}
