package br.ifba.edu.aval2.bridge;

import java.util.Collection;

import br.ifba.edu.aval.model.Mapa;
import br.ifba.edu.aval.model.PontoGeografico;
import br.ifba.edu.aval.model.Prisma;

public interface GeradorMapa {
    public String iniciarDocumento() ;
    public String adicionarAreaMapa(Mapa mapa);
    public String adicionarMetadados(String categoria);
    public String adicionarPonto(String tipo, PontoGeografico ponto);
    public String adicionarTexto(PontoGeografico ponto, String texto);
    public PontoGeografico referenciaMin(Collection<Prisma> prismas);
    public PontoGeografico referenciaMax(Collection<Prisma> prismas);
    public String finalizarDocumento();
}
