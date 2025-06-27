package com.capgemini.ocp.springbootdemo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.ocp.springbootdemo.dto.Account;
import com.capgemini.ocp.springbootdemo.dto.CreateAccountRequest;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api/bank")
public class BankingController {
	private final Map<Long, Account> accounts = new HashMap<>();
	private Long nextId = 3L;

	@PostConstruct
	public void init() {
		Account account1 = new Account(591998L, "Alice", 10000);
		Account account2 = new Account(15122000L, "Bob", 5000);
		accounts.put(account1.getAccountId(), account1);
		accounts.put(account2.getAccountId(), account2);
	}

	@PostMapping("/create")
	@Operation(summary = "Create a new bank account")
	public ResponseEntity<Account> createAccount(@RequestBody CreateAccountRequest request) {
		Account account = new Account(nextId, request.getAccountHolderName(), request.getInitialBalance());
		accounts.put(nextId, account);
		nextId++;
		return ResponseEntity.ok(account);
	}

	@GetMapping("/{accountId}")
	@Operation(summary = "Get account details by account ID")
	public ResponseEntity<Account> getAccount(@PathVariable Long accountId) {
		Account account = accounts.get(accountId);
		if (account == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(account);
	}
}