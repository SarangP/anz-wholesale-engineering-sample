package com.anz.wholesale.service;

import com.anz.wholesale.domain.Account;
import com.anz.wholesale.repoaitory.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service to handle account fetches
 */
@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;


    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public Optional<Account> findById(Long id) {
        return accountRepository.findById(id);
    }
}
