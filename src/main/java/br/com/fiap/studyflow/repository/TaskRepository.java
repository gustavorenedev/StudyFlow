package br.com.fiap.studyflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.studyflow.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
    
}
