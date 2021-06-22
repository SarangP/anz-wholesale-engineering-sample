package com.anz.wholesale.resource;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.anz.wholesale.domain.Account;
import com.anz.wholesale.domain.AccountTransaction;
import com.anz.wholesale.exception.AccountException;
import com.anz.wholesale.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * Account resource to control all account specific requests
 *
 */
@RestController
public class AccountResource {

	@Autowired
	private AccountService accountService;
	
	/**
	 * 
	 * Retrieves all the accounts
	 * 
	 * @return
	 */
	@GetMapping("/accounts")
	public ResponseEntity<List<Account>> retrieveAllAccounts() {
		return new ResponseEntity<>(accountService.findAll(), HttpStatus.OK);
	}

	/**
	 *
	 * Retrieves the account by id
	 *
	 * @return
	 */
	@GetMapping("/account/{id}")
	public ResponseEntity<Account> retrieveOneAccount(@PathVariable Long id) {

		Optional<Account> acc = accountService.findById(id);
		if(acc.isPresent()) {
			return new ResponseEntity<>(acc.get(), HttpStatus.OK);
		} else {
			throw new AccountException();
		}
	}
	
	@GetMapping(path="account/{accountNumber}/transactions")
	public ResponseEntity<Set<AccountTransaction>> retrieveAllTransactions(@PathVariable long accountNumber) {
		Optional<Account> accountOptional = accountService.findById(accountNumber);
		if (!accountOptional.isPresent()) {
			throw new AccountException();
		}
		return new ResponseEntity<>(accountOptional.get().getTransactions(), HttpStatus.OK);
	}
}