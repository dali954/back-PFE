package tn.numeryx.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class GitLabProjectReq {

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("path")
    private String path;

    @JsonProperty("namespace")
    private String namespace;

    @JsonProperty("initialize_with_readme")
    private boolean initialize_with_readme;

}
