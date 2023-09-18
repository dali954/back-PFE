package tn.numeryx.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class JenkinsUserReq {

    @JsonProperty("username")
    private String username;

    @JsonProperty("password1")
    private String password1;

    @JsonProperty("password2")
    private String password2;

    @JsonProperty("fullname")
    private String fullname;

    @JsonProperty("email")
    private String email;

}
