package br.ifba.edu.aval;

import java.time.Duration;

import br.ifba.edu.aval.command.EditorMapa;
import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.model.Categoria;
import br.ifba.edu.aval.model.Dificuldade;
import br.ifba.edu.aval.model.Idade;
import br.ifba.edu.aval.model.Mapa;
import br.ifba.edu.aval.model.PontoGeografico;
import br.ifba.edu.aval.model.Prisma;
import br.ifba.edu.aval.model.Sexo;
import br.ifba.edu.aval.model.Sinaletica;
import br.ifba.edu.aval.observer.Resultado;

public class AppAvaliacaoFinal extends AppAvaliacaoBase{
	
	private Resultado resultado;
	
	public AppAvaliacaoFinal() {
		this.resultado = new Resultado(new Categoria(Sexo.D, Dificuldade.N, Idade.INFANTIL), Duration.ofMinutes(120));
	}
	
	private void registerResultado() {
		this.atleta1.registerObserver(this.resultado);
		this.atleta2.registerObserver(this.resultado);
		this.atleta3.registerObserver(this.resultado);
		this.atleta4.registerObserver(this.resultado);
		this.atleta5.registerObserver(this.resultado);
	}
	
	
	public void aval() {
		System.out.println("* AVALIAÇÃO FINAL **************************");
		this.questao1();
		System.out.println("******************************************");
		this.questao2();
	}

	public void questao1() {
		Mapa mapa = this.makeMapa();
		Sinaletica sinaletica = this.makeSinaletica();
		EditorMapa editor = new EditorMapa(mapa,sinaletica);
		
		System.out.println("QUESTÃO 1");
        System.out.println("--- Estado Inicial do Mapa ---");
        System.out.println(mapa);
        System.out.println(sinaletica);
        
        
        System.out.println("--- Operação: Adicionar Prisma 39 ---");
        Prisma prisma39 = new Prisma(39, new PontoGeografico(-12.99718, -38.47499, 1.05));
        editor.adicionarPrisma(prisma39);
        System.out.println(mapa);
        System.out.println(sinaletica);
        
        System.out.println("--- Operação: Mover Prisma 39 ---");
        PontoGeografico novoPonto = new PontoGeografico(-12.99728, -38.67499, 2.05);
        editor.moverPrisma(39, novoPonto);
        System.out.println(mapa);	
        System.out.println(sinaletica);
        
        
        System.out.println("--- Operação: Desfazer (Undo) ---");
        editor.desfazer();
        System.out.println(mapa);
        System.out.println(sinaletica);
        
        System.out.println("--- Operação: Refazer (Redo) ---");
        editor.refazer();
        System.out.println(mapa);     
        System.out.println(sinaletica);
        
        System.out.println("--- Operação: Remover Prisma 39 ---");
        editor.removerPrisma(39);
        System.out.println(mapa);        
        System.out.println(sinaletica);
        
	}
	
	public void questao2() {
		System.out.println("QUESTÃO 2");
		this.makeBoletinsProva();
		this.registerResultado();
		
		System.out.println("**Corrida do Atleta1**");
		try {
			this.runAtleta1Aval1();
		} catch (AtividadeNaoPermitidaException e) {
			System.err.println("Atividade não permitida na corrida do " + atleta1.cboNumero() + ": " + e.getMessage());
		}
		System.out.println("**Corrida do Atleta2**");
		try {
			this.runAtleta2Aval1();
		} catch (AtividadeNaoPermitidaException e) {
			System.err.println("Atividade não permitida na corrida do " + atleta2.cboNumero() + ": " + e.getMessage());
		}
		System.out.println("**Corrida do Atleta3**");
		try {
			this.runAtleta3Aval3();
		} catch (AtividadeNaoPermitidaException e) {
			System.err.println("Atividade não permitida na corrida do " + atleta3.cboNumero() + ": " + e.getMessage());
		}
		System.out.println("******************************************");
		System.out.println("**Corrida do Atleta4**");
		try {
			this.runAtleta4Aval3();
		} catch (AtividadeNaoPermitidaException e) {
			System.err.println("Atividade não permitida na corrida do " + atleta4.cboNumero() + ": " + e.getMessage());
		}
		System.out.println("******************************************");

		System.out.println("**Corrida do Atleta5**");
		try {
			this.runAtleta5Aval3();
		} catch (AtividadeNaoPermitidaException e) {
			System.err.println("Atividade não permitida na corrida do " + atleta5.cboNumero() + ": " + e.getMessage());
		}
		System.out.println("******************************************");
		
	}

	
	
	
	public static void main(String[] args) {
		new AppAvaliacaoFinal().aval();
	}

	

}
