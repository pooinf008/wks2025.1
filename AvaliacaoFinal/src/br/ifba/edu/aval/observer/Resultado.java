package br.ifba.edu.aval.observer;

import java.time.Duration;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval.model.BoletimProva;
import br.ifba.edu.aval.model.Categoria;
import br.ifba.edu.aval3.cor.Apurador;

public class Resultado implements BoletimObserver {

    private Categoria categoria;
    private Map<String, Duration> resultados;
    private Apurador apurador;

    public Resultado(Categoria categoria, Duration tempoMaximo) {
        this.categoria = categoria;
        this.resultados = new HashMap<String, Duration>();
        this.apurador = new Apurador(tempoMaximo);
    }

    public Map<String, Duration> getResultados() {
        return this.resultados;
    }

    public void update(BoletimProva boletim) {
        try {
            this.resultados.put(boletim.cboNumero(), this.apurador.apurar(boletim));
        } catch (DNFException ex) {
            this.resultados.put(boletim.cboNumero(), null);
        } catch (AtividadeNaoPermitidaException ex) {
            this.resultados.put(boletim.cboNumero(), null);
        }
        System.out.println(this.toString());
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    @Override
    public String toString() {
        List<Map.Entry<String, Duration>> resultadosOrdenados = resultados.entrySet().stream()
                .filter(entry -> entry.getValue() != null)
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        sb.append("Categoria: ").append(this.categoria.toString()).append("\n");
        for (Map.Entry<String, Duration> entry : resultadosOrdenados) {
            sb.append("  - CBO: ").append(entry.getKey()).append(", Tempo: ").append(entry.getValue()).append("\n");
        }

        // Adicionar os atletas que não concluíram a prova (DNF)
        List<String> dnfList = resultados.entrySet().stream()
                .filter(entry -> entry.getValue() == null)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        if (!dnfList.isEmpty()) {
            sb.append("  - DNF (Não Concluíram): ").append(String.join(", ", dnfList)).append("\n");
        }

        return sb.toString();
    }
}
