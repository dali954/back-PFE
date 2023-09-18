package tn.numeryx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.numeryx.model.ProfilCollab;
import tn.numeryx.repository.ProfilCollabRepository;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8082")
@RestController
@RequestMapping("/api/profilCollabs")
public class ProfilCollabController {

    private final ProfilCollabRepository profilCollabRepository;

    @Autowired
    public ProfilCollabController(ProfilCollabRepository profilCollabRepository) {
        this.profilCollabRepository = profilCollabRepository;
    }

    @GetMapping()
    public ResponseEntity<List<ProfilCollab>> getAllProfilCollab() {
        List<ProfilCollab> profilCollabs = profilCollabRepository.findAll();
        return new ResponseEntity<>(profilCollabs, HttpStatus.OK);
    }
}
