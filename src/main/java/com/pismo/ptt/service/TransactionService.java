package com.pismo.ptt.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pismo.ptt.dto.TransactionDTO;
import com.pismo.ptt.model.Account;
import com.pismo.ptt.model.Transaction;
import com.pismo.ptt.repository.AccountRepository;
import com.pismo.ptt.utils.converters.OperationTypeConverter;
import com.pismo.ptt.utils.enums.OperationTypeEnum;
import com.pismo.ptt.utils.exceptions.AccountNotFoundException;
import com.pismo.ptt.utils.exceptions.LimitNotAvailableException;

@Service
public class TransactionService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	
	public Transaction createTransactionFromDTO(TransactionDTO transactionDTO) {
		Transaction newTransaction = new Transaction();
		
		Account account;
		try {
			account = accountRepository.findById(transactionDTO.getAccountId())
					.orElseThrow(() -> new AccountNotFoundException());
		} catch (AccountNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		
		newTransaction.setAccount(account);
		newTransaction.setEventDate(LocalDateTime.now());
		setOperationTypeAndAmount(transactionDTO, newTransaction);
		
		try {
			changeLimitAccount(account, newTransaction);
		} catch (LimitNotAvailableException e) {
			//Handler limitNotAvailableException
		}
		
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
	
	private void changeLimitAccount(Account account, Transaction newTransaction) throws LimitNotAvailableException {
		BigDecimal newLimit = account.getAvailableCreditLimit().add(newTransaction.getAmount());
		if(newLimit.compareTo(BigDecimal.ZERO) < 0) {
			throw new LimitNotAvailableException();
		}
		
		
	}
	

}
