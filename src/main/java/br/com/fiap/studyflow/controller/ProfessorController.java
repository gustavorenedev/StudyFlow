package br.com.fiap.studyflow.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.studyflow.models.Professor;
import br.com.fiap.studyflow.repository.ProfessorRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("professor")
@Slf4j
public class ProfessorController {

    @Autowired
    ProfessorRepository repository;

    @GetMapping
    public List<Professor> index(){
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Professor create(@RequestBody @Valid Professor professor) {
        log.info("cadastrando professor {} ", professor);
        return repository.save(professor);
    }

    @GetMapping("{id}")
    public ResponseEntity<Professor> show(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Long id){
        log.info("apagando professor");

        verificarSeExisteProfessor(id);
        repository.deleteById(id);
    }

    @PutMapping("{id}")
    public Professor update(@PathVariable Long id, @RequestBody Professor professor) {
        log.info("atualizando professor com id {} para {}", id, professor);

        verificarSeExisteProfessor(id);
        professor.setId(id);
        return repository.save(professor);
    }
    
    private void verificarSeExisteProfessor(Long id) {
        repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Não existe professor com o id informado. Consulte lista em /professor"));
    }
}
