package br.com.unicesumar.aep12.dto;

import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

//@Author Mateus Cardozo, Gelyson Santos

@Getter
public class RepositorioAvaliacoes {

    private List<Avaliacao> avaliacoes = new ArrayList<>();

    public void adicionar(Avaliacao avaliacao) {
        this.avaliacoes.add(avaliacao);
    }

    public List<Aluno> obterAprovados (Disciplina disciplina) {

        List<Aluno> alunosAprovados = new ArrayList<>();
        Set<Aluno> alunos = new HashSet<>();

        avaliacoes.forEach(avaliacao ->  alunos.add(avaliacao.getAluno()));

        alunos.forEach(aluno -> {

            List<Avaliacao> avaliacaoList = avaliacoes.stream()
                    .filter(avaliacao -> avaliacao.getAluno().getNome().equals(aluno.getNome()))
                    .filter(avaliacao -> avaliacao.getDisciplina().getNome().equals(disciplina.getNome())).collect(Collectors.toList());

            double media = avaliacaoList.stream().mapToDouble(Avaliacao::getNota).average().orElse(0.0);

            if (media >= 6.0) {
                alunosAprovados.add(aluno);
            }
        });
        return alunosAprovados;
    }
}
