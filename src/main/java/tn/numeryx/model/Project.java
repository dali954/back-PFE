package tn.numeryx.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "project")
public class Project implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_project;

    @ManyToOne
    @JoinColumn(name = "id_equipe", referencedColumnName = "id_equipe")
    private Equipe equipe;

    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date date_debut_project;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date date_fin_project;

}
