package tn.numeryx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.numeryx.model.Equipe;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Long> {

}
