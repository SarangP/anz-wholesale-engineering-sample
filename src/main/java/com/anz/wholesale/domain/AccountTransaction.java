package com.anz.wholesale.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.*;

/**
 * 
 *Account transaction entity, holds the account transaction data
 *
 */
@Entity
public class AccountTransaction {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long transactionId;

	@ManyToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	@JsonIgnore
	Account account;

	private Date valueDate;

	private BigDecimal creditAmount;

	private BigDecimal debitAmount;

	@Enumerated(EnumType.STRING)
	private DebitCredit debitOrCredit;

	private String transactionNarrative;

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Date getValueDate() {
		return valueDate;
	}

	public void setValueDate(Date valueDate) {
		this.valueDate = valueDate;
	}

	public BigDecimal getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(BigDecimal creditAmount) {
		this.creditAmount = creditAmount;
	}

	public BigDecimal getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(BigDecimal debitAmount) {
		this.debitAmount = debitAmount;
	}

	public DebitCredit getDebitOrCredit() {
		return debitOrCredit;
	}

	public void setDebitOrCredit(DebitCredit debitOrCredit) {
		this.debitOrCredit = debitOrCredit;
	}

	public String getTransactionNarrative() {
		return transactionNarrative;
	}

	public void setTransactionNarrative(String transactionNarrative) {
		this.transactionNarrative = transactionNarrative;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}