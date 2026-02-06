package com.example.bank;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class BankServiceTest {

    @Test
    void createAccountStoresIt() {
        BankService bank = new BankService();
        Account acc = bank.createAccount("A1", BigDecimal.valueOf(200));
        assertNotNull(acc);
        assertTrue(bank.findAccount("A1").isPresent());
    }

    @Test
    void duplicateAccountThrows() {
        BankService bank = new BankService();
        bank.createAccount("A1", BigDecimal.TEN);
        assertThrows(IllegalArgumentException.class,
                () -> bank.createAccount("A1", BigDecimal.ONE));
    }

    @Test
    void transferMovesMoney() {
        BankService bank = new BankService();
        bank.createAccount("A1", BigDecimal.valueOf(100));
        bank.createAccount("A2", BigDecimal.valueOf(50));

        bank.transfer("A1", "A2", BigDecimal.valueOf(30));

        assertEquals(BigDecimal.valueOf(70), bank.findAccount("A1").get().getBalance());
        assertEquals(BigDecimal.valueOf(80), bank.findAccount("A2").get().getBalance());
    }
}