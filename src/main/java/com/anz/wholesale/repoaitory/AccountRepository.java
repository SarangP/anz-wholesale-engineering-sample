package com.anz.wholesale.repoaitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anz.wholesale.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
