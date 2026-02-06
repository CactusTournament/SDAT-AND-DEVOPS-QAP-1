package com.example.bank;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BankService {

    private final Map<String, Account> accounts = new HashMap<>();

    public Account createAccount(String id, BigDecimal initialBalance) {
        if (accounts.containsKey(id)) {
            throw new IllegalArgumentException("Account already exists: " + id);
        }
        Account account = new Account(id, initialBalance);
        accounts.put(id, account);
        return account;
    }

    public Optional<Account> findAccount(String id) {
        return Optional.ofNullable(accounts.get(id));
    }

    public void transfer(String fromId, String toId, BigDecimal amount) {
        if (fromId.equals(toId)) {
            throw new IllegalArgumentException("Cannot transfer to the same account");
        }

        Account from = accounts.get(fromId);
        Account to = accounts.get(toId);

        if (from == null || to == null) {
            throw new IllegalArgumentException("Both accounts must exist");
        }

        from.withdraw(amount);
        to.deposit(amount);
    }
}