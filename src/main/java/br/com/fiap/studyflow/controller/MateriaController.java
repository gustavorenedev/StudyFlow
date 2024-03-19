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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.studyflow.models.Materia;
import br.com.fiap.studyflow.repository.MateriaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("materia")
@Slf4j
public class MateriaController {

    @Autowired
    MateriaRepository repository;
    
    Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping
    public List<Materia> index(){
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Materia create(@RequestBody Materia materia) {
        log.info("cadastrando materia {} ", materia);
        return repository.save(materia);
    }

    @GetMapping("{id}")
    public ResponseEntity<Materia> show(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Long id){
        log.info("apagando materia");

        verificarSeExisteMateria(id);
        repository.deleteById(id);
    }

    @PutMapping("{id}")
    public Materia update(@PathVariable Long id, @RequestBody Materia materia) {
        log.info("atualizando materia com id {} para {}", id, materia);

        verificarSeExisteMateria(id);
        materia.setId(id);
        return repository.save(materia);
    }
    
    private void verificarSeExisteMateria(Long id) {
        repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Não existe materia com o id informado. Consulte lista em /materia"));
    }

}
