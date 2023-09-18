package tn.numeryx.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import feign.Headers;
import tn.numeryx.dto.GitLabProjectReq;
import tn.numeryx.dto.GitLabUserReq;
import tn.numeryx.dto.GitlabProjectMemberReq;
import tn.numeryx.dto.GitlabProjectMemberResp;
import tn.numeryx.dto.GitlabProjectResp;
import tn.numeryx.dto.GitlabUserResp;

@FeignClient(name = "gitlab", url = "http://192.168.195.128/api/v4")
public interface GitlabClient {

        @Headers("Content-Type: application/json")
        @RequestMapping(method = RequestMethod.POST, value = "/projects")
        GitlabProjectResp createProject(
                        @RequestHeader("PRIVATE-TOKEN") String authorization,
                        @RequestBody GitLabProjectReq requestBody);

        @Headers("Content-Type: application/json")
        @RequestMapping(method = RequestMethod.POST, value = "/users")
        GitlabUserResp createUser(
                        @RequestHeader("PRIVATE-TOKEN") String authorization,
                        @RequestBody GitLabUserReq requestBody);

        @Headers("Content-Type: application/json")
        @RequestMapping(method = RequestMethod.POST, value = "/projects/{projectId}/members")
        GitlabProjectMemberResp addProjectMember(
                        @RequestHeader("PRIVATE-TOKEN") String authorization,
                        @PathVariable("projectId") String projectId,
                        @RequestBody GitlabProjectMemberReq requestBody);
}

// Ajouter d'autres méthodes pour les autres endpoints de l'API GitLab
