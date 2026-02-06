package com.example.bank;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void depositIncreasesBalance() {
        Account account = new Account("A1", BigDecimal.valueOf(100));
        account.deposit(BigDecimal.valueOf(50));
        assertEquals(BigDecimal.valueOf(150), account.getBalance());
    }

    @Test
    void withdrawDecreasesBalance() {
        Account account = new Account("A1", BigDecimal.valueOf(100));
        account.withdraw(BigDecimal.valueOf(40));
        assertEquals(BigDecimal.valueOf(60), account.getBalance());
    }

    @Test
    void withdrawMoreThanBalanceThrows() {
        Account account = new Account("A1", BigDecimal.valueOf(50));
        assertThrows(IllegalStateException.class,
                () -> account.withdraw(BigDecimal.valueOf(100)));
    }

    @Test
    void negativeDepositThrows() {
        Account account = new Account("A1", BigDecimal.valueOf(100));
        assertThrows(IllegalArgumentException.class,
                () -> account.deposit(BigDecimal.valueOf(-10)));
    }
}