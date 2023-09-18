package tn.numeryx.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class GitlabProjectMemberReq {

    @JsonProperty("id")
    private String id;
    @JsonProperty("accessLevel")
    private int accessLevel;

}
