package br.com.fiap.studyflow.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.List;

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

import br.com.fiap.studyflow.models.Task;
import br.com.fiap.studyflow.repository.TaskRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;



@RestController
@RequestMapping("task")
@Slf4j
public class TaskController {

    @Autowired
    TaskRepository repository;
    
    @GetMapping
    public List<Task> index(){
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Task create(@RequestBody @Valid Task task) {
        log.info("cadastrando tarefa {} ", task);
        return repository.save(task);
    }

    @GetMapping("{id}")
    public ResponseEntity<Task> show(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Long id){
        log.info("apagando tarefa");

        verificarSeExisteLicao(id);
        repository.deleteById(id);
    }

    @PutMapping("{id}")
    public Task update(@PathVariable Long id, @RequestBody Task task) {
        log.info("atualizando tarefa com id {} para {}", id, task);

        verificarSeExisteLicao(id);
        task.setId(id);
        return repository.save(task);
    }
    
    private void verificarSeExisteLicao(Long id) {
        repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Não existe tarefa com o id informado. Consulte lista em /tarefa"));
    }

}
