package ropandi.auth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ropandi.auth.entity.MstScope;
import ropandi.auth.entity.MstScopePK;
@Repository
public interface ScopeRepository  extends JpaRepository<MstScope,MstScopePK>{

	@Query("select s from MstScope s where s.mstScopePK.clientId =:clientId")
	List<MstScope> findByClientId(@Param("clientId") String clientId);
}
