package tn.numeryx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import tn.numeryx.configuration.JenkinsProperties;
import tn.numeryx.dto.JenkinsJob;
import tn.numeryx.dto.JenkinsJobReq;
import tn.numeryx.dto.JenkinsJobResp;
import tn.numeryx.dto.JenkinsUserReq;
import tn.numeryx.dto.JenkinsUserResp;

import java.util.List;

@Service
public class JenkinsService {

    private JenkinsClient jenkinsClient;
    private JenkinsProperties jenkinsProperties;

    @Autowired
    public JenkinsService(JenkinsClient jenkinsClient, JenkinsProperties jenkinsProperties) {
        this.jenkinsClient = jenkinsClient;
        this.jenkinsProperties = jenkinsProperties;
    }

    public JenkinsJobResp createJob(JenkinsJobReq request) {
        String authorization = "Basic " + Base64Utils
                .encodeToString((jenkinsProperties.getUsername() + ":" +
                        jenkinsProperties.getPassword()).getBytes());

        String jobName = request.getJobName();
        String projectUrl = request.getGitLabUrl();
        String branch = request.getBranch();

        String jobConfigXml = "<project>\n" +
                " <actions/>\n" +
                " <description>My Jenkins Job</description>\n" +
                " <keepDependencies>false</keepDependencies>\n" +
                " <properties/>\n" +
                " <scm class=\"hudson.plugins.git.GitSCM\" >\n" +
                " <userRemoteConfigs>\n" +
                " <hudson.plugins.git.UserRemoteConfig>\n" +
                " <url>" + projectUrl + "</url>\n" +
                " </hudson.plugins.git.UserRemoteConfig>\n" +
                " </userRemoteConfigs>\n" +
                " <branches>\n" +
                " <hudson.plugins.git.BranchSpec>\n" +
                " <name>" + branch + "</name>\n" +
                " </hudson.plugins.git.BranchSpec>\n" +
                " </branches>\n" +
                " </scm>\n" +
                " <canRoam>true</canRoam>\n" +
                " <disabled>false</disabled>\n" +
                " <blockBuildWhenUpstreamBuilding>false</blockBuildWhenUpstreamBuilding>\n" +
                " <triggers/>\n" +
                " <concurrentBuild>false</concurrentBuild>\n" +
                " <builders/>\n" +
                " <publishers/>\n" +
                " <buildWrappers/>\n" +
                " <displayName>" + jobName + "</displayName>\n" +
                " <fullDisplayName/>\n" +
                " <fullName/>\n" +
                " <name/>\n" +
                "</project>";

        return jenkinsClient.createJob(authorization, request.getJobName(),
                jobConfigXml);
    }

    public List<JenkinsJobResp> getAllJobs() {
        String authorization = "Basic " + Base64Utils
                .encodeToString((jenkinsProperties.getUsername() + ":" +
                        jenkinsProperties.getPassword()).getBytes());

        JenkinsJob response = jenkinsClient.getAllJobs(authorization);
        return response.getJobs();
    }

    public void deleteJob(String jobName) {
        String authorization = "Basic " + Base64Utils
                .encodeToString((jenkinsProperties.getUsername() + ":" +
                        jenkinsProperties.getPassword()).getBytes());

        jenkinsClient.deleteJob(authorization, jobName);
    }
}

// package tn.numeryx.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import org.springframework.util.Base64Utils;
// import tn.numeryx.configuration.JenkinsProperties;
// import tn.numeryx.dto.JenkinsJob;
// import tn.numeryx.dto.JenkinsJobReq;
// import tn.numeryx.dto.JenkinsJobResp;
// import tn.numeryx.dto.JenkinsUserReq;
// import tn.numeryx.dto.JenkinsUserResp;

// import java.util.List;

// @Service
// public class JenkinsService {

// private JenkinsClient jenkinsClient;
// private JenkinsProperties jenkinsProperties;

// @Autowired
// public JenkinsService(JenkinsClient jenkinsClient, JenkinsProperties
// jenkinsProperties) {
// this.jenkinsClient = jenkinsClient;
// this.jenkinsProperties = jenkinsProperties;
// }

// public JenkinsJobResp createJob(JenkinsJobReq request) {
// // Vérifier si le nom de l'emploi existe déjà
// if (isJobNameExists(request.getJobName())) {
// throw new IllegalArgumentException("Le nom de l'emploi existe déjà.");
// }

// String authorization = "Basic " + Base64Utils
// .encodeToString((jenkinsProperties.getUsername() + ":" +
// jenkinsProperties.getPassword()).getBytes());

// String jobName = request.getJobName();
// String projectUrl = request.getGitLabUrl();
// String branch = request.getBranch();

// String jobConfigXml = "<project>\n" +
// " <actions/>\n" +
// " <description>My Jenkins Job</description>\n" +
// " <keepDependencies>false</keepDependencies>\n" +
// " <properties/>\n" +
// " <scm class=\"hudson.plugins.git.GitSCM\" >\n" +
// " <userRemoteConfigs>\n" +
// " <hudson.plugins.git.UserRemoteConfig>\n" +
// " <url>" + projectUrl + "</url>\n" +
// " </hudson.plugins.git.UserRemoteConfig>\n" +
// " </userRemoteConfigs>\n" +
// " <branches>\n" +
// " <hudson.plugins.git.BranchSpec>\n" +
// " <name>" + branch + "</name>\n" +
// " </hudson.plugins.git.BranchSpec>\n" +
// " </branches>\n" +
// " </scm>\n" +
// " <canRoam>true</canRoam>\n" +
// " <disabled>false</disabled>\n" +
// " <blockBuildWhenUpstreamBuilding>false</blockBuildWhenUpstreamBuilding>\n" +
// " <triggers/>\n" +
// " <concurrentBuild>false</concurrentBuild>\n" +
// " <builders/>\n" +
// " <publishers/>\n" +
// " <buildWrappers/>\n" +
// " <displayName>" + jobName + "</displayName>\n" +
// " <fullDisplayName/>\n" +
// " <fullName/>\n" +
// " <name/>\n" +
// "</project>";

// return jenkinsClient.createJob(authorization, request.getJobName(),
// jobConfigXml);
// }

// // Méthode pour vérifier l'existence du nom de l'emploi
// public boolean isJobNameExists(String jobName) {
// String authorization = "Basic " + Base64Utils.encodeToString(
// (jenkinsProperties.getUsername() + ":" +
// jenkinsProperties.getPassword()).getBytes());

// List<JenkinsJobResp> jobs =
// jenkinsClient.getAllJobs(authorization).getJobs();

// // Vérifiez si le nom de l'emploi existe déjà dans la liste des emplois
// for (JenkinsJobResp job : jobs) {
// if (jobName.equals(job.getName())) {
// return true; // Le nom de l'emploi existe déjà
// }
// }

// return false; // Le nom de l'emploi n'existe pas
// }

// public List<JenkinsJobResp> getAllJobs() {
// String authorization = "Basic " + Base64Utils
// .encodeToString((jenkinsProperties.getUsername() + ":" +
// jenkinsProperties.getPassword()).getBytes());

// JenkinsJob response = jenkinsClient.getAllJobs(authorization);
// return response.getJobs();
// }

// public void deleteJob(String jobName) {
// String authorization = "Basic " + Base64Utils
// .encodeToString((jenkinsProperties.getUsername() + ":" +
// jenkinsProperties.getPassword()).getBytes());

// jenkinsClient.deleteJob(authorization, jobName);
// }
// }
