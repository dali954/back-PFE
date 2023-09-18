
package tn.numeryx.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@ToString
public class JenkinsJob {

    @JsonProperty("jobs")
    private List<JenkinsJobResp> jobs;
}
