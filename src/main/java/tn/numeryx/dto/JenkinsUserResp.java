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
@Table(name = "JenkinsUserResp")
@ToString
public class JenkinsUserResp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer id; // Identifiant généré automatiquement dans la base de données

    @JsonProperty("id")
    private String jenkinsId; // Identifiant de l'utilisateur dans GitLab

    @JsonProperty("username")
    private String username;

    @JsonProperty("email")
    private String email;

}
