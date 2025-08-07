package br.ifba.edu.aval2.bridge;

import java.util.Collection;

import br.ifba.edu.aval.model.Mapa;
import br.ifba.edu.aval.model.PontoGeografico;
import br.ifba.edu.aval.model.Prisma;

public class GeradorMapaSVG implements GeradorMapa {

	private static final Integer DELTA = 10; 
	
	private PontoGeografico min;
	private PontoGeografico max;
	
	public PontoGeografico referenciaMin(Collection<Prisma> prismas) {
        double menorLatitude = prismas.stream()
                .map(Prisma::ponto)
                .mapToDouble(PontoGeografico::latitude)
                .min()
                .orElse(Double.MAX_VALUE);

        double menorLongitude = prismas.stream()
                .map(Prisma::ponto)
                .mapToDouble(PontoGeografico::longitude)
                .min()
                .orElse(Double.MAX_VALUE);

        return new PontoGeografico(menorLatitude, menorLongitude, 0.0); 		
	}
	
	public PontoGeografico referenciaMax(Collection<Prisma> prismas) {
        double maiorLatitude = prismas.stream()
                .map(Prisma::ponto)
                .mapToDouble(PontoGeografico::latitude)
                .max()
                .orElse(Double.MIN_VALUE);

        double maiorLongitude = prismas.stream()
                .map(Prisma::ponto)
                .mapToDouble(PontoGeografico::longitude)
                .max()
                .orElse(Double.MIN_VALUE);

        return new PontoGeografico(maiorLatitude, maiorLongitude, 0.0); 		
	}	
	
	
	
    @Override
    public String iniciarDocumento() {
        return "<svg width=\"1000\" height=\"1000\" xmlns=\"http://www.w3.org/2000/svg\">\n";
    }
    
    @Override
    public String adicionarAreaMapa(Mapa mapa) {
    	this.min = this.referenciaMin(mapa.prismas());
    	this.max = this.referenciaMax(mapa.prismas());
    	return String.format("  <rect x=\"%d\" y=\"%d\" width=\"%.0f\" height=\"%.0f\" \n"
    					   + "	fill=\"none\" stroke=\"black\" stroke-width=\"2\"/> \n", 
    					   1, 1, (this.max.latitude() - this.min.latitude())  * 100000 * 1.15,
    					   		 (this.max.longitude() - this.min.longitude()) * 100000 * 1.15);		
    }
    

    @Override
    public String adicionarMetadados(String categoria) {
        return String.format("  <title>Mapa de Orientação: %s</title>\n", categoria);
    }

    @Override
    public String adicionarPonto(String tipo, PontoGeografico ponto) {
    	String str;
    	if (tipo.equals("partida"))
            return String.format("  <line x1=\"%.0f\" y1=\"%.0f\" x2=\"%.0f\" y2=\"%.0f\" style=\"stroke:magenta;stroke-width:3\" /> \n",
					 Math.abs((ponto.latitude() - this.min.latitude()) * 100000) - 5 +  GeradorMapaSVG.DELTA, 
					 Math.abs((ponto.longitude() - this.min.longitude()) * 100000) - 5 +  GeradorMapaSVG.DELTA,
					 Math.abs((ponto.latitude() - this.min.latitude()) * 100000) + 5 +  GeradorMapaSVG.DELTA, 
					 Math.abs((ponto.longitude() - this.min.longitude()) * 100000) + 5 +  GeradorMapaSVG.DELTA);
    	else if (tipo.equals("chegada")) {
            str =  String.format("  <circle cx=\"%.0f\" cy=\"%.0f\" r=\"5\" fill=\"none\" style=\"stroke:magenta;stroke-width:1\"/> \n",
            		Math.abs((ponto.latitude() - this.min.latitude()) * 100000) +  GeradorMapaSVG.DELTA, Math.abs((ponto.longitude() - this.min.longitude()) * 100000) +  GeradorMapaSVG.DELTA);
        	str +=  String.format("  <circle cx=\"%.0f\" cy=\"%.0f\" r=\"3\" fill=\"none\" style=\"stroke:magenta;stroke-width:1\"/> \n",
        			Math.abs((ponto.latitude() - this.min.latitude()) * 100000) +  GeradorMapaSVG.DELTA, Math.abs((ponto.longitude() - this.min.longitude()) * 100000) +  GeradorMapaSVG.DELTA);
        	return str;
    	}else {
    		 str = String.format("  <circle cx=\"%.0f\" cy=\"%.0f\" r=\"5\" fill=\"none\" style=\"stroke:magenta;stroke-width:1\"/> \n",
            		Math.abs((ponto.latitude() - this.min.latitude()) * 100000) +  GeradorMapaSVG.DELTA, Math.abs((ponto.longitude() - this.min.longitude()) * 100000) +  GeradorMapaSVG.DELTA);
    		 return str;
    	}	
    }


    @Override
    public String finalizarDocumento() {
        return "</svg>";
    }

	@Override
	public String adicionarTexto(PontoGeografico ponto, String texto) {
		//fill=\"magenta\"
		String str;
		str =  String.format("  <text x=\"%.0f\" y=\"%.0f\" font-size=\"12\" style=\"stroke:magenta;stroke-width:1\">%s</text>\n",
			                 Math.abs((ponto.latitude() - this.min.latitude()) * 100000) + 10 + GeradorMapaSVG.DELTA, 
			                 Math.abs((ponto.longitude() - this.min.longitude()) * 100000) + 10 +  GeradorMapaSVG.DELTA,
			                 texto);
		return str;
	}
}