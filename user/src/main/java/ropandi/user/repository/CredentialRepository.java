package ropandi.user.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ropandi.user.entity.MstUserCredential;
@Repository
public interface CredentialRepository extends JpaRepository<MstUserCredential, Long> {

	@Query("select p from MstCredential p where p.username =:username")
	public Optional<MstUserCredential> findByUsername(@Param("username") String username);
}
