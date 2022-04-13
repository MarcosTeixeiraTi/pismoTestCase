package com.pismo.ptt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pismo.ptt.config.ApplicationConfigConstants;
import com.pismo.ptt.dto.TransactionDTO;
import com.pismo.ptt.model.Transaction;
import com.pismo.ptt.repository.TransactionRepository;
import com.pismo.ptt.service.TransactionService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(ApplicationConfigConstants.API_VERSION + "/transactions")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@Autowired
	private TransactionRepository transactionRepository;

	@Operation(summary = "Criação de uma nova transação.")
	@PostMapping("")
	public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDTO transactionDTO) {
		Transaction t = this.transactionRepository.save(transactionService.createTransactionFromDTO(transactionDTO));
		return new ResponseEntity<>(t, HttpStatus.CREATED);
	}

	

}
