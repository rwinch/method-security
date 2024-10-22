package org.example.methodsecurity;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authorization.method.HandleAuthorizationDenied;

public class BankAccount {
	final int id;
	final String owner;
	final String accountNumber;
	final double balance;


	public BankAccount(int id, String owner, String accountNumber, double balance) {
		this.id = id;
		this.owner = owner;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public String getOwner() {
		return owner;
	}

	@PreAuthorize("this.owner == authentication?.name")
	@HandleAuthorizationDenied(handlerClass = MaskMethodAuthorizationDeniedHandler.class)
	public String getAccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}
}
