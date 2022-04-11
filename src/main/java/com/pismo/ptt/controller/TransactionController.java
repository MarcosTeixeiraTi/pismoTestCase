package com.pismo.ptt.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Transaction createTransaction(@RequestBody TransactionDTO transactionDTO) {

		Transaction newTransaction = new Transaction();
		OperationTypeConverter converter = new OperationTypeConverter();
		
		try {
			newTransaction.setAccount(accountRepository.findById(transactionDTO.getAccountId())
					.orElseThrow(() -> new AccountNotFoundException(
							"Conta não encontrada. Não foi possível realizar a transação.")));
		} catch (AccountNotFoundException e) {
			e.printStackTrace();
		}
		
		newTransaction.setOperationTypeId(converter.convertToEntityAttribute(transactionDTO.getOperationTypeId()));
		newTransaction.setAmount(transactionDTO.getAmount());
		newTransaction.setEventDate(LocalDateTime.now());
		return this.transactionRepository.save(newTransaction);
	}

}
