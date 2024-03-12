package br.com.fiap.studyflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.studyflow.models.Materia;

public interface MateriaRepository extends JpaRepository<Materia, Long>{
    
}
