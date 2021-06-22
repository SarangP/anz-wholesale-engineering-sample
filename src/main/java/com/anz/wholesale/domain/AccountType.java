package com.anz.wholesale.domain;

public enum AccountType {

    Savings("Saving Account"), Current("Current Account");

    private String name;

    AccountType(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
