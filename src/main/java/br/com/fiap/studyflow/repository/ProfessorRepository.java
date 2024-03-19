package br.com.fiap.studyflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.studyflow.models.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{
    
}
