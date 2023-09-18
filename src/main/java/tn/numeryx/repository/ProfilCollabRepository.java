package tn.numeryx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.numeryx.model.ProfilCollab;

@Repository
public interface ProfilCollabRepository extends JpaRepository<ProfilCollab, Long> {

}
