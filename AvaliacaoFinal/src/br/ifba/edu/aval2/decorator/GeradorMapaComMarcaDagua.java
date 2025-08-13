package br.ifba.edu.aval2.decorator;

import br.ifba.edu.aval.model.Mapa;
import br.ifba.edu.aval.model.PontoGeografico;
import br.ifba.edu.aval2.bridge.GeradorMapa;

public class GeradorMapaComMarcaDagua extends GeradorMapaDecorator {

    public GeradorMapaComMarcaDagua(GeradorMapa gerador) {
        super(gerador);
    }

    @Override
    public String adicionarAreaMapa(Mapa mapa) {
    	PontoGeografico min = this.referenciaMin(mapa.prismas());
    	PontoGeografico max = this.referenciaMax(mapa.prismas());
    	int x =  (int) Math.ceil((max.latitude() - min.latitude())  * 30000 * 1.15);
    	int y =  (int) Math.ceil(((max.longitude() - min.longitude()) * 50000 * 1.15));
    	String marcaDagua =  String.format("  <text x=\"%d\" y=\"%d\" font-family=\"Verdana\" font-size=\"14\" fill=\"#cccccc\" fill-opacity=\"0.8\">"
		    								+ "INF011 Maps - (C) 2025</text>", x, y);
    	String areaOriginal = super.adicionarAreaMapa(mapa);
    	  return areaOriginal + marcaDagua;
    }

}
    
  