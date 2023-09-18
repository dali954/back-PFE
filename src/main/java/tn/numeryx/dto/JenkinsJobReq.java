package tn.numeryx.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class JenkinsJobReq {

    @JsonProperty("jobName")
    private String jobName;

    @JsonProperty("gitLabUrl")
    private String gitLabUrl;

    @JsonProperty("Branch")
    private String Branch;

}
