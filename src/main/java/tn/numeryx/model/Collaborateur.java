package tn.numeryx.model;

import java.io.Serializable;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Collaborateur")
public class Collaborateur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_collab;

    @ManyToOne
    @JoinColumn(name = "id_profil_collab", referencedColumnName = "id_profil_collab")
    private ProfilCollab profilCollab;

    @ManyToOne
    @JoinColumn(name = "id_equipe", referencedColumnName = "id_equipe")
    private Equipe equipe;

    private String email;
    private String username;
    private String password;

    // private Collaborateur(ProfilCollab profilCollab, Equipe equipe, String email,
    // String username, String password) {
    // this.profilCollab = profilCollab;
    // this.equipe = equipe;
    // this.email = email;
    // this.username = username;
    // this.password = password;
    // }

}
