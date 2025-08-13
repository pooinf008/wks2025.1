package br.ifba.edu.aval.observer;

import br.ifba.edu.aval.model.BoletimProva;

public interface BoletimSubject {
	
	public void registerObserver(BoletimObserver o);
	public void removeObserver(BoletimObserver o);
	public void notifyObservers(BoletimProva boletim);	

}
