package br.com.unicesumar.aep12.main;

import br.com.unicesumar.aep12.dto.Aluno;
import br.com.unicesumar.aep12.dto.Avaliacao;
import br.com.unicesumar.aep12.dto.Disciplina;
import br.com.unicesumar.aep12.dto.RepositorioAvaliacoes;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//@Author Mateus Cardozo, Gelyson Santos

public class App {

    private static Random random = new Random();

    public static void main(String[] args) {
        RepositorioAvaliacoes repositorioAvaliacoes = new RepositorioAvaliacoes();
        List<Aluno> alunos = getAlunos();

        List<Disciplina> disciplinas = getDisciplinas();

        List<Avaliacao> avaliacoes = getAvaliacoes(alunos, disciplinas);
        avaliacoes.forEach(repositorioAvaliacoes::adicionar);

        disciplinas.forEach(disciplina -> {
            List<Aluno> alunosAprovados = repositorioAvaliacoes.obterAprovados(disciplina);
            System.out.println("Disciplina: " + disciplina.getNome());
            alunosAprovados.forEach(aluno -> System.out.println(aluno.toString()));
            System.out.println();
        });

    }

    private static List<Aluno> getAlunos() {
        Aluno aluno = new Aluno("Mateus", 17014702);
        Aluno aluno2 = new Aluno("Gleyson", 24242424);
        Aluno aluno3 = new Aluno("Marcelo", 12345678);
        Aluno aluno4 = new Aluno("Felipe", 23456789);
        Aluno aluno5 = new Aluno("Daniela", 34567890);
        Aluno aluno6 = new Aluno("Jõao", 45678901);
        Aluno aluno7 = new Aluno("Marvin", 56789012);
        Aluno aluno8 = new Aluno("Paulo", 67890123);
        Aluno aluno9 = new Aluno("Eric", 78901234);
        Aluno aluno10 = new Aluno("Zé", 89012345);
        List<Aluno> alunos = new ArrayList<>();
        alunos.addAll(Lists.newArrayList(aluno,aluno2,aluno3,aluno4,aluno5,aluno6,aluno7,aluno8,aluno9,aluno10));
        return alunos;
    }

    private static List<Disciplina> getDisciplinas() {
        List<Disciplina> disciplinas = new ArrayList<>();
        Disciplina disciplina = new Disciplina("Projeto Integrador");
        Disciplina disciplina2 = new Disciplina("Estrutura de dados");
        Disciplina disciplina3 = new Disciplina("Banco de dados");
        Disciplina disciplina4 = new Disciplina("Programação");
        Disciplina disciplina5 = new Disciplina("Sistemas Operacionais");
        disciplinas.addAll(Lists.newArrayList(disciplina,disciplina2,disciplina3,disciplina4,disciplina5));
        return disciplinas;
    }

    private static List<Avaliacao> getAvaliacoes(List<Aluno> alunos, List<Disciplina> disciplinas){
        List<Avaliacao> avaliacaoList =  new ArrayList<>();
        createAvaliacao(alunos, disciplinas, avaliacaoList);
        return avaliacaoList;
    }

    private static void createAvaliacao(List<Aluno> alunos, List<Disciplina> disciplinas, List<Avaliacao> avaliacaoList) {
        boolean canPass = false;
        int qtd = 1;
        int count = 0;
        for (Disciplina disciplina: disciplinas){
            for (Aluno aluno: alunos){
                if (!canPass){
                    count++;
                    avaliacaoList.add(new Avaliacao(aluno, disciplina, (double) random.nextInt(6)));
                    if (count == qtd){
                        canPass = true;
                    }
                } else {
                    avaliacaoList.add(new Avaliacao(aluno, disciplina, 9.0));
                }
            }
            qtd++;
            canPass = false;
            count = 0;
        }
    }

}
