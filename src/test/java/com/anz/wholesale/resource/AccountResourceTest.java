package com.anz.wholesale.resource;

import com.anz.wholesale.domain.Account;
import com.anz.wholesale.domain.AccountTransaction;
import com.anz.wholesale.domain.AccountType;
import com.anz.wholesale.domain.Currency;
import com.anz.wholesale.domain.DebitCredit;
import com.anz.wholesale.service.AccountService;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    List<Account> mockAccount = getAccount();

    Optional<Account> optionalAccount = getOptionalAccount();

    @Test
    public void testRetrieveDetailsForAccount() throws Exception {

        Mockito.when(accountService.findAll()).thenReturn(mockAccount);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/accounts").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "[{\"accountNumber\":1,\"accountName\":\"Acc Name\",\"accountType\":\"Current\",\"currency\":\"AUD\",\"balanceDate\":\"2019-12-12\",\"balance\":123.219999999999998863131622783839702606201171875}]";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void testRetrieveOneAccount() throws Exception {

        Mockito.when(accountService.findById(1l)).thenReturn(optionalAccount);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/account/1").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "{\"accountNumber\":1,\"accountName\":\"Acc Name\",\"accountType\":\"Current\",\"currency\":\"AUD\",\"balanceDate\":\"2019-12-12\",\"balance\":123.219999999999998863131622783839702606201171875}";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void testRetrieveOneAccountAndItsTransactions() throws Exception {

        Mockito.when(accountService.findById(1l)).thenReturn(optionalAccount);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/account/1/transactions").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "[{\"transactionId\":1,\"valueDate\":\"2019-12-12\",\"creditAmount\":0,\"debitAmount\":12223.120000000000800355337560176849365234375,\"debitOrCredit\":\"Debit\",\"transactionNarrative\":\"test tran\"}]";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    private List<Account> getAccount() {
        Account account = new Account();
        account.setAccountNumber(1l);
        account.setAccountName("Acc Name");
        account.setAccountType(AccountType.Current);
        account.setTransactions(getAccountTransactionsList());
        account.setBalance(new BigDecimal(123.22));
        account.setBalanceDate(new Date(ZonedDateTime.of(2019,12,12, 0, 0,0, 0, ZoneId.of("Australia/Sydney")).toInstant().toEpochMilli()));
        account.setCurrency(Currency.AUD);
        List<Account> list = new ArrayList<Account>();
        list.add(account);
        return list;
    }

    private Set<AccountTransaction> getAccountTransactionsList() {
        Set<AccountTransaction> set = new HashSet<>();
        AccountTransaction accountTransaction = new AccountTransaction();
        accountTransaction.setTransactionId(1l);
        accountTransaction.setCreditAmount(BigDecimal.ZERO);
        accountTransaction.setDebitOrCredit(DebitCredit.Debit);
        accountTransaction.setDebitAmount(new BigDecimal(12223.12));
        accountTransaction.setTransactionNarrative("test tran");
        accountTransaction.setValueDate(new Date(ZonedDateTime.of(2019,12,12, 0, 0,0, 0, ZoneId.of("Australia/Sydney")).toInstant().toEpochMilli()));
        set.add(accountTransaction);
        return set;
    }

    private Optional<Account> getOptionalAccount() {
        Optional<Account> account = Optional.of(getAccount().get(0));
        return account;
    }

}
