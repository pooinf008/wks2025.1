package br.ifba.edu.aval.model;

import java.util.List;

public record Sinaletica(Sexo sexo, Idade categoria, Dificuldade dificuldade, List<Prisma> prismas, Double distancia, Double desnivel) {

}
