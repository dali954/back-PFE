package tn.numeryx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.numeryx.model.Equipe;
import tn.numeryx.repository.EquipeRepository;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8082")
@RestController
@RequestMapping("/api/equipes")
public class EquipeController {

    private final EquipeRepository equipeRepository;

    @Autowired
    public EquipeController(EquipeRepository equipeRepository) {
        this.equipeRepository = equipeRepository;
    }

    @GetMapping
    public ResponseEntity<List<Equipe>> getAllEquipe() {
        List<Equipe> equipes = equipeRepository.findAll();
        return new ResponseEntity<>(equipes, HttpStatus.OK);
    }
}
