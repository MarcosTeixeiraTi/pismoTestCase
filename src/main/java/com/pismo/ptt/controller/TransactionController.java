package com.pismo.ptt.controller;

import java.time.LocalDateTime;

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
import com.pismo.ptt.repository.AccountRepository;
import com.pismo.ptt.repository.TransactionRepository;
import com.pismo.ptt.utils.converters.OperationTypeConverter;
import com.pismo.ptt.utils.enums.OperationTypeEnum;
import com.pismo.ptt.utils.exceptions.AccountNotFoundException;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(ApplicationConfigConstants.API_VERSION + "/transactions")
public class TransactionController {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private TransactionRepository transactionRepository;

	@Operation(summary = "Criação de uma nova transação.")
	@PostMapping("")
	public ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDTO transactionDTO) {
		Transaction t = this.transactionRepository.save(createClassFromDTO(transactionDTO));
		return new ResponseEntity<>(t, HttpStatus.CREATED);
	}

	private Transaction createClassFromDTO(TransactionDTO transactionDTO) {
		Transaction newTransaction = new Transaction();
		
		try {
			newTransaction.setAccount(accountRepository.findById(transactionDTO.getAccountId())
					.orElseThrow(() -> new AccountNotFoundException()));
		} catch (AccountNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		
		setOperationTypeAndAmount(transactionDTO, newTransaction);
		newTransaction.setEventDate(LocalDateTime.now());
		
		return newTransaction;
	}

	private void setOperationTypeAndAmount(TransactionDTO transactionDTO, Transaction newTransaction) {
		OperationTypeEnum operationType = new OperationTypeConverter().convertToEntityAttribute(transactionDTO.getOperationTypeId());
		
		newTransaction.setOperationTypeId(operationType);
		
		if(operationType.getOperationPositive()) {
			newTransaction.setAmount(transactionDTO.getAmount());
		} else {
			newTransaction.setAmount(transactionDTO.getAmount().negate());
		}
	}

}
