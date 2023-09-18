package tn.numeryx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.numeryx.dto.GitLabProjectReq;
import tn.numeryx.dto.GitLabUserReq;
import tn.numeryx.dto.GitlabProjectMemberReq;
import tn.numeryx.dto.GitlabProjectMemberResp;
import tn.numeryx.dto.GitlabProjectResp;
import tn.numeryx.dto.GitlabUserResp;
import tn.numeryx.service.GitlabService;

@CrossOrigin(origins = "http://localhost:8082")
@RestController
@RequestMapping("/api/gitlab")
public class GitlabController {

    @Autowired
    private GitlabService gitlabService;

    @PostMapping("/projects")
    public ResponseEntity<GitlabProjectResp> createProject(@RequestBody GitLabProjectReq request) {
        System.out.println(request);
        GitlabProjectResp response = gitlabService.createProject(request);
        System.out.println(response);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/users")
    public ResponseEntity<GitlabUserResp> createUser(@RequestBody GitLabUserReq request) {
        GitlabUserResp userResp = gitlabService.createUser(request);
        return new ResponseEntity<>(userResp, HttpStatus.CREATED);
    }

    @PostMapping("/projects/{projectId}/members")
    public ResponseEntity<GitlabProjectMemberResp> addProjectMember(
            @PathVariable("projectId") String projectId,
            @RequestBody GitlabProjectMemberReq request) {
        GitlabProjectMemberResp response = gitlabService.addProjectMember(projectId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/users")
    public ResponseEntity<List<GitlabUserResp>> getAllUsers() {
        List<GitlabUserResp> users = gitlabService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/projects")
    public ResponseEntity<List<GitlabProjectResp>> getAllProjects() {
        List<GitlabProjectResp> projects = gitlabService.getAllProjects();
        return ResponseEntity.ok(projects);
    }
}
