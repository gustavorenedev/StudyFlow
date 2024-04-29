package br.com.fiap.studyflow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Professor {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "{professor.nome.notblank}")
    @Size(min = 3, max = 255, message = "{professor.nome.size}")
    private String nome;
    @NotBlank(message = "{professor.nome.notblank}")
    @Size(min = 3, max = 255, message = "{professor.nome.size}")
    private String materia;
    private String foto;

}
