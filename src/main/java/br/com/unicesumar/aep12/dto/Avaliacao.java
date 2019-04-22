package br.com.unicesumar.aep12.dto;

//@Author Mateus Cardozo, Gelyson Santos

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Avaliacao {

    private Aluno aluno;
    private Disciplina disciplina;
    private Double nota;

}
