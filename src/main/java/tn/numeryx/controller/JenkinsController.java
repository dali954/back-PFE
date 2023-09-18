package tn.numeryx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.numeryx.dto.JenkinsJobReq;
import tn.numeryx.dto.JenkinsJobResp;
import tn.numeryx.service.JenkinsService;

@CrossOrigin(origins = "http://localhost:8082")
@RestController
@RequestMapping("/api/jenkins")
public class JenkinsController {

    private final JenkinsService jenkinsService;

    @Autowired
    public JenkinsController(JenkinsService jenkinsService) {
        this.jenkinsService = jenkinsService;
    }

    @PostMapping("/createJob")
    public ResponseEntity<JenkinsJobResp> createJob(@RequestBody JenkinsJobReq request) {
        JenkinsJobResp response = jenkinsService.createJob(request);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/getAllJobs")
    public ResponseEntity<List<JenkinsJobResp>> getAllJobs() {
        List<JenkinsJobResp> jobs = jenkinsService.getAllJobs();
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }

    @PostMapping("/deleteJob/{jobName}")
    public ResponseEntity<Void> deleteJob(@PathVariable("jobName") String jobName) {
        jenkinsService.deleteJob(jobName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

// package tn.numeryx.controller;

// import java.util.List;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;
// import tn.numeryx.dto.JenkinsJobReq;
// import tn.numeryx.dto.JenkinsJobResp;
// import tn.numeryx.service.JenkinsService;

// @CrossOrigin(origins = "http://localhost:8082")
// @RestController
// @RequestMapping("/api/jenkins")
// public class JenkinsController {

// private final JenkinsService jenkinsService;

// @Autowired
// public JenkinsController(JenkinsService jenkinsService) {
// this.jenkinsService = jenkinsService;
// }

// @PostMapping("/createJob")
// public ResponseEntity<?> createJob(@RequestBody JenkinsJobReq request) {
// String jobName = request.getJobName();

// // Vérifiez si le nom de l'emploi existe déjà
// if (jenkinsService.isJobNameExists(jobName)) {
// return new ResponseEntity<>("Le nom de l'emploi existe déjà.",
// HttpStatus.BAD_REQUEST);
// }

// JenkinsJobResp response = jenkinsService.createJob(request);

// return new ResponseEntity<>(response, HttpStatus.CREATED);
// }

// @GetMapping("/getAllJobs")
// public ResponseEntity<List<JenkinsJobResp>> getAllJobs() {
// List<JenkinsJobResp> jobs = jenkinsService.getAllJobs();
// return new ResponseEntity<>(jobs, HttpStatus.OK);
// }

// @PostMapping("/deleteJob/{jobName}")
// public ResponseEntity<Void> deleteJob(@PathVariable("jobName") String
// jobName) {
// jenkinsService.deleteJob(jobName);
// return new ResponseEntity<>(HttpStatus.NO_CONTENT);
// }
// }
