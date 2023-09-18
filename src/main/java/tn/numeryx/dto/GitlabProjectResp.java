package tn.numeryx.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "GitlabProjectResp")
@ToString
public class GitlabProjectResp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int gitlabId;

    @JsonProperty("id")
    private int Id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    // @JsonProperty("webUrl")
    // private String webUrl;
    // @JsonProperty("sshUrl")
    // private String sshUrl;
    // @JsonProperty("httpUrl")
    // private String httpUrl;

}
