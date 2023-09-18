package tn.numeryx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.numeryx.model.Collaborateur;
import tn.numeryx.model.Equipe;

@Repository
public interface CollabRepository extends JpaRepository<Collaborateur, Long> {
    List<Collaborateur> findByUsernameContaining(String username);

    List<Collaborateur> findByEquipe(Equipe equipe);

    // Ajoutez la méthode pour récupérer tous les e-mails des collaborateurs
    @Query("SELECT c.email FROM Collaborateur c")
    List<String> getAllEmails();
}
