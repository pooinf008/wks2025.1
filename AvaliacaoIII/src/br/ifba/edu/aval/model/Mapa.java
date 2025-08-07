package br.ifba.edu.aval.model;

import java.util.List;

public record Mapa(Categoria categoria,
				   Integer escala, Integer ecn, PontoGeografico largada,
				   PontoGeografico partida, List<Prisma> prismas, PontoGeografico chegada) {

}
