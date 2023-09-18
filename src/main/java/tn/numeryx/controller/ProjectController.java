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

import tn.numeryx.model.Project;
import tn.numeryx.repository.EquipeRepository;
import tn.numeryx.repository.ProjectRepository;

@CrossOrigin(origins = "http://localhost:8082")
@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    EquipeRepository equipeRepository;

    @GetMapping()
    public ResponseEntity<List<Project>> getAllProjects() {

        List<Project> projects = projectRepository.findAll();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
        System.out.println("===================" + id);
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid project id: " + id));
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        System.out.println(project);
        Project savedProject = projectRepository.save(project);
        return new ResponseEntity<>(savedProject, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id,
            @RequestBody Project projectDetails) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid project id: " + id));
        project.setEquipe(projectDetails.getEquipe());
        project.setName(projectDetails.getName());
        project.setDescription(projectDetails.getDescription());
        project.setDate_debut_project(projectDetails.getDate_debut_project());
        project.setDate_fin_project(projectDetails.getDate_fin_project());

        Project updateProject = projectRepository.save(project);
        return new ResponseEntity<>(updateProject, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteProject(@PathVariable Long id) {
        projectRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping()
    public ResponseEntity<HttpStatus> deleteAllProjects() {
        projectRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/checkNameExists/{name}")
    public ResponseEntity<Boolean> checkProjectNameExists(@PathVariable String name) {
        boolean exists = projectRepository.existsByName(name);
        return new ResponseEntity<>(exists, HttpStatus.OK);
    }

}
