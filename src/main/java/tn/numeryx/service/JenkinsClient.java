package tn.numeryx.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import feign.Headers;
import feign.Param;
import tn.numeryx.dto.JenkinsJob;
import tn.numeryx.dto.JenkinsJobResp;

@FeignClient(name = "jenkinsClient", url = "http://192.168.195.129:8080")
public interface JenkinsClient {

        @Headers("Content-Type: application/xml")
        @RequestMapping(method = RequestMethod.POST, value = "/createItem", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
        JenkinsJobResp createJob(@RequestHeader("Authorization") String authorization,
                        @RequestParam("name") String jobName,
                        @RequestBody String jobConfigXml);

        @RequestMapping(method = RequestMethod.GET, value = "/api/json", produces = MediaType.APPLICATION_JSON_VALUE)
        JenkinsJob getAllJobs(@RequestHeader("Authorization") String authorization);

        @RequestMapping(method = RequestMethod.POST, value = "/job/{jobName}/doDelete")
        void deleteJob(@RequestHeader("Authorization") String authorization,
                        @PathVariable("jobName") String jobName);
}
