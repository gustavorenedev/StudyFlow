package br.com.fiap.studyflow.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.studyflow.models.Materia;
import br.com.fiap.studyflow.repository.MateriaRepository;

@RestController
@RequestMapping("materia")
public class MateriaController {
    
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    MateriaRepository repository;

    @GetMapping
    public List<Materia> index(){
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Materia create(@RequestBody Materia materia) {
        log.info("cadastrando materia {} ", materia);
        repository.save(materia);
        return materia;
    }
}
