package com.pismo.ptt.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pismo.ptt.dto.TransactionDTO;
import com.pismo.ptt.model.Transaction;
import com.pismo.ptt.repository.AccountRepository;
import com.pismo.ptt.utils.converters.OperationTypeConverter;
import com.pismo.ptt.utils.enums.OperationTypeEnum;
import com.pismo.ptt.utils.exceptions.AccountNotFoundException;

@Service
public class TransactionService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	
	public Transaction createTransactionFromDTO(TransactionDTO transactionDTO) {
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
