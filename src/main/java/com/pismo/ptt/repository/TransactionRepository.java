package com.pismo.ptt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pismo.ptt.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
