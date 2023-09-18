package tn.numeryx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.numeryx.configuration.GitlabProperties;
import tn.numeryx.dto.GitLabProjectReq;
import tn.numeryx.dto.GitLabUserReq;
import tn.numeryx.dto.GitlabProjectMemberReq;
import tn.numeryx.dto.GitlabProjectMemberResp;
import tn.numeryx.dto.GitlabProjectResp;
import tn.numeryx.dto.GitlabUserResp;
import tn.numeryx.repository.GitlabProjectRepo;
import tn.numeryx.repository.GitlabUserRepo;

@Service
public class GitlabService {

    @Autowired
    private GitlabClient gitlabClient;

    @Autowired
    private GitlabProperties gitlabProperties;

    @Autowired
    private GitlabProjectRepo gitlabProjectRepo;

    @Autowired
    private GitlabUserRepo gitlabUserRepo;

    public GitlabService(GitlabClient gitlabClient, GitlabProperties gitlabProperties) {
        this.gitlabClient = gitlabClient;
        this.gitlabProperties = gitlabProperties;
    }

    public GitlabProjectResp createProject(GitLabProjectReq request) {
        System.out.println(request);
        String authorization = gitlabProperties.getPersonalAccessToken();
        GitlabProjectResp response = gitlabClient.createProject(authorization, request);
        System.out.println(response);
        gitlabProjectRepo.save(response);

        return response;
    }

    public GitlabUserResp createUser(GitLabUserReq request) {
        String authorization = gitlabProperties.getPersonalAccessToken();
        GitlabUserResp response = gitlabClient.createUser(authorization, request);

        // Enregistrement dans la base de données
        gitlabUserRepo.save(response);

        return response;
    }

    public GitlabProjectMemberResp addProjectMember(String projectId, GitlabProjectMemberReq request) {
        String authorization = gitlabProperties.getPersonalAccessToken();
        return gitlabClient.addProjectMember(authorization, projectId, request);
    }

    public List<GitlabUserResp> getAllUsers() {
        return gitlabUserRepo.findAll();
    }

    public List<GitlabProjectResp> getAllProjects() {
        return gitlabProjectRepo.findAll();
    }
    // Ajouter d'autres méthodes pour les autres endpoints de l'API GitLab

}
