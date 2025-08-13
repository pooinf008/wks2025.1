package br.ifba.edu.aval.command.composite;

import java.util.ArrayList;
import java.util.List;

import br.ifba.edu.aval.command.PistaCommand;

public class MacroPistaCommand implements PistaCommand{
	
    private List<PistaCommand> commands;

    public MacroPistaCommand() {
        this.commands = new ArrayList<>();
    }
    
    public void adicionar(PistaCommand command) {
        this.commands.add(command);
    }
    
    public void remover(PistaCommand command) {
        this.commands.remove(command);
    }  
    
    @Override
    public void executar() {
        for (PistaCommand command : commands)
            command.executar();
    }    
    
    
    @Override
    public void desfazer() {
        for (int i = commands.size() - 1; i >= 0; i--)
            commands.get(i).desfazer();
    }    

}
