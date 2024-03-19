package br.com.fiap.studyflow.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.studyflow.models.Professor;
import br.com.fiap.studyflow.repository.ProfessorRepository;

@RestController
@RequestMapping("professor")
public class ProfessorController {

    @Autowired
    ProfessorRepository repository;

    Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping
    public List<Professor> index(){
        return repository.findAll();
    }
}
