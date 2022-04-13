package com.pismo.ptt.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pismo.ptt.config.ApplicationConfigConstants;
import com.pismo.ptt.dto.AccountDTO;
import com.pismo.ptt.model.Account;
import com.pismo.ptt.repository.AccountRepository;
import com.pismo.ptt.utils.exceptions.AccountNotFoundException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;


@RestController
@RequestMapping(ApplicationConfigConstants.API_VERSION + "/accounts")
public class AccountController {

	@Autowired
	private AccountRepository accountRepository;

	@Operation(summary = "Criação de uma conta.")
	@PostMapping("")
	public Account createAccount(@RequestBody AccountDTO accountDTO) {
		return this.accountRepository.save(new Account(accountDTO.getDocumentNumber(), LocalDateTime.now()));
	}

	// Utilizando esse endpoint apenas para testar e verificar quais contas existem.
	@GetMapping("/list")
	public List<Account> allAccounts() {
		return this.accountRepository.findAll();
	}

	@Operation(summary = "Consulta de informações de uma conta pelo ID.")
	@GetMapping("/{accountId}")
	public Account findAccountById(@Parameter(description = "Id da conta procurada") @PathVariable("accountId") Long accountId) {
		
		try {
			return accountRepository.findById(accountId).orElseThrow(() -> new AccountNotFoundException("Conta não encontrada"));
		} catch (AccountNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

}
