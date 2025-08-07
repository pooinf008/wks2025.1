package br.ifba.edu.aval1.prototype;

import java.util.HashMap;
import java.util.Map;

import br.ifba.edu.aval.model.BoletimProva;
import br.ifba.edu.aval.model.Dificuldade;
import br.ifba.edu.aval.model.Idade;
import br.ifba.edu.aval.model.Sexo;


//Não é um FM mas sim um Prototype Manager
public class BoletimProvaFactory {
	
	private static BoletimProvaFactory boletimProvaFactory;
	
	private Map<String, ListaPassagens> listas;

	public static BoletimProvaFactory instance() {
		if(BoletimProvaFactory.boletimProvaFactory == null)
			BoletimProvaFactory.boletimProvaFactory = new BoletimProvaFactory();
		return BoletimProvaFactory.boletimProvaFactory;
	}
	
	private BoletimProvaFactory() {
		this.listas = new HashMap<String, ListaPassagens>();
	}
	
	public void register(Sexo sexo, Idade idade, Dificuldade dificuldade, ListaPassagens listas) {
		String categoria = this.categoria(sexo, idade, dificuldade);
		this.listas.put(categoria, listas);
	}
	
	private String categoria(Sexo sexo, Idade idade, Dificuldade dificuldade) {
		return sexo.toString() + idade.toString() + dificuldade.toString();
	}
	
	public BoletimProva getBoletim(String numeroCBO, Sexo sexo, Idade idade, Dificuldade dificuldade, Long minutoPartida) {
		String categoria = this.categoria(sexo, idade, dificuldade);
		ListaPassagens lista = this.listas.get(categoria);
		if(lista == null)
			return null;
		return new BoletimProva(numeroCBO, minutoPartida, (ListaPassagens)lista.clone());		
	}
	
	

}
