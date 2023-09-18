package tn.numeryx.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.numeryx.model.Collaborateur;
import tn.numeryx.repository.CollabRepository;
import tn.numeryx.repository.EquipeRepository;
import tn.numeryx.repository.ProfilCollabRepository;

@CrossOrigin(origins = "http://localhost:8082")
@RestController
@RequestMapping("/api/collaborateurs")
public class CollabController {

    @Autowired
    CollabRepository collabRepository;

    @Autowired
    EquipeRepository equipeRepository;

    @Autowired
    ProfilCollabRepository profilCollabRepository;

    @GetMapping()
    public ResponseEntity<List<Collaborateur>> getAllCollaborateurs() {

        List<Collaborateur> collaborateurs = collabRepository.findAll();
        return new ResponseEntity<>(collaborateurs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Collaborateur> getCollaborateurById(@PathVariable Long id) {
        System.out.println("===================" + id);
        Collaborateur collaborateur = collabRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid collaborateur id: " + id));
        return new ResponseEntity<>(collaborateur, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Collaborateur> createCollaborateur(@RequestBody Collaborateur collaborateur) {
        System.out.println(collaborateur);
        Collaborateur savedCollaborateur = collabRepository.save(collaborateur);
        return new ResponseEntity<>(savedCollaborateur, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Collaborateur> updateCollaborateur(@PathVariable Long id,
            @RequestBody Collaborateur collaborateurDetails) {
        Collaborateur collaborateur = collabRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid collaborateur id: " + id));
        collaborateur.setProfilCollab(collaborateurDetails.getProfilCollab());
        collaborateur.setEquipe(collaborateurDetails.getEquipe());
        collaborateur.setEmail(collaborateurDetails.getEmail());
        collaborateur.setUsername(collaborateurDetails.getUsername());
        collaborateur.setPassword(collaborateurDetails.getPassword());

        Collaborateur updatedCollaborateur = collabRepository.save(collaborateur);
        return new ResponseEntity<>(updatedCollaborateur, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCollaborateur(@PathVariable Long id) {
        collabRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping()
    public ResponseEntity<HttpStatus> deleteAllCollaborateurs() {
        collabRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/emails")
    public ResponseEntity<List<String>> getAllEmails() {
        List<String> emails = collabRepository.getAllEmails(); // Remplacez avec la méthode appropriée de votre
                                                               // repository
        return new ResponseEntity<>(emails, HttpStatus.OK);
    }

    // @GetMapping("/collaborateurs/published")
    // public ResponseEntity<List<Collaborateur>> findByPublished() {
    // ...
    // }

    // @GetMapping()
    // public ResponseEntity<List<Equipe>> getAllEquipe() {
    // List<Equipe> equipes = equipeRepository.findAll();
    // return new ResponseEntity<>(equipes, HttpStatus.OK);
    // }

    // @GetMapping("/profiles")
    // public ResponseEntity<List<ProfilCollab>> getAllProfilCollab() {
    // List<ProfilCollab> profilCollab = profilCollabRepository.findAll();
    // return new ResponseEntity<>(profilCollab, HttpStatus.OK);
    // }
}
