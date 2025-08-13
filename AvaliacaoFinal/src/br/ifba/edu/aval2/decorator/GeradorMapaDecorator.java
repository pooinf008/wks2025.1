package br.ifba.edu.aval2.decorator;

import java.util.Collection;

import br.ifba.edu.aval.model.Mapa;
import br.ifba.edu.aval.model.PontoGeografico;
import br.ifba.edu.aval.model.Prisma;
import br.ifba.edu.aval2.bridge.GeradorMapa;

public abstract class GeradorMapaDecorator implements GeradorMapa {

    protected GeradorMapa inner; // O objeto que está sendo decorado

    public GeradorMapaDecorator(GeradorMapa gerador) {
        this.inner = gerador;
    }
    
    @Override
    public PontoGeografico referenciaMin(Collection<Prisma> prismas) {
    	return inner.referenciaMin(prismas);
    };
    
    @Override
    public PontoGeografico referenciaMax(Collection<Prisma> prismas) {
    	return inner.referenciaMax(prismas);
    };
        

    @Override
    public String iniciarDocumento() {
        return inner.iniciarDocumento();
    }

    @Override
    public String adicionarAreaMapa(Mapa mapa) {
        return inner.adicionarAreaMapa(mapa);
    }

    @Override
    public String adicionarMetadados(String categoria) {
        return inner.adicionarMetadados(categoria);
    }

    @Override
    public String adicionarPonto(String tipo, PontoGeografico ponto) {
        return inner.adicionarPonto(tipo, ponto);
    }

    @Override
    public String adicionarTexto(PontoGeografico ponto, String texto) {
        return inner.adicionarTexto(ponto, texto);
    }

    @Override
    public String finalizarDocumento() {
        return inner.finalizarDocumento();
    }
}