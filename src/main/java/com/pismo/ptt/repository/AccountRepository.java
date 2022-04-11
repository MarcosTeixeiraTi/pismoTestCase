package com.pismo.ptt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pismo.ptt.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	
//	@Query("SELECT acc from accounts acc WHERE acc.accountId = :accountId")
//	public Account findAccountById(@Param("accountId") Long accountId);

}
