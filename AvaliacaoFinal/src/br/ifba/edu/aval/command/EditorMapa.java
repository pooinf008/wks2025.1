package br.ifba.edu.aval.command;

import java.util.Stack;

import br.ifba.edu.aval.command.composite.MacroPistaCommand;
import br.ifba.edu.aval.model.Mapa;
import br.ifba.edu.aval.model.PontoGeografico;
import br.ifba.edu.aval.model.Prisma;
import br.ifba.edu.aval.model.Sinaletica;

public class EditorMapa {
    private Mapa mapa;
    private Sinaletica sinaletica;
    private Stack<PistaCommand> historico;
    private Stack<PistaCommand> desfeitos;

    public EditorMapa(Mapa mapa, Sinaletica sinaletica) {
        this.mapa = mapa;
        this.sinaletica = sinaletica;
        this.historico = new Stack<>();
        this.desfeitos = new Stack<>();
    }
    
    public void adicionarPrisma(Prisma prisma) {
        PistaCommand comando = new AdicionarPrismaCommand(this.mapa, this.sinaletica, prisma);
        this.executarComando(comando);
    }
    
    public void removerPrisma(Integer id) {
        PistaCommand comando = new RemoverPrismaCommand(this.mapa, this.sinaletica, id);
        this.executarComando(comando);
    }
    
    public void moverPrisma(Integer id, PontoGeografico novoPonto) {
        PistaCommand comandoRemover = new RemoverPrismaCommand(this.mapa, this.sinaletica, id);
        PistaCommand comandoAdicionar = new AdicionarPrismaCommand(this.mapa, this.sinaletica, new Prisma(id, novoPonto));
        MacroPistaCommand macroCommand = new MacroPistaCommand();
        macroCommand.adicionar(comandoRemover);
        macroCommand.adicionar(comandoAdicionar);
        this.executarComando(macroCommand);
    }
    
    private void executarComando(PistaCommand comando) {
        comando.executar();
        historico.push(comando);
        desfeitos.clear();
    }
    
    public void desfazer() {
        if (!historico.isEmpty()) {
            PistaCommand comando = historico.pop();
            comando.desfazer();
            desfeitos.push(comando);
        }    
    }
    
    public void refazer() {
        if (!desfeitos.isEmpty()) {
            PistaCommand comando = desfeitos.pop();
            comando.executar();
            historico.push(comando);
        }    
    }
}
