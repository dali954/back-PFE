package tn.numeryx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.numeryx.model.Equipe;
import tn.numeryx.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByNameContaining(String name);

    List<Project> findByEquipe(Equipe equipe);

    boolean existsByName(String name);

}
