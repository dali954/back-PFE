package tn.numeryx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.numeryx.dto.GitlabUserResp;

@Repository
public interface GitlabUserRepo extends JpaRepository<GitlabUserResp, Long> {

}
