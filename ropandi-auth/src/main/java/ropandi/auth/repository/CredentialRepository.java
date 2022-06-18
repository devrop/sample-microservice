package ropandi.auth.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.google.common.base.Optional;

import ropandi.auth.entity.MstCredential;
@Repository
public interface CredentialRepository extends JpaRepository<MstCredential,String> {

	
	
}
