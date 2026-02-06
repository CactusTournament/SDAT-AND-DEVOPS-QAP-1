package com.example.bank;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BankService bank = new BankService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Simple Banking Application ===");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Transfer");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter account ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter initial balance: ");
                        BigDecimal balance = scanner.nextBigDecimal();
                        bank.createAccount(id, balance);
                        System.out.println("Account created successfully.");
                    }
                    case 2 -> {
                        System.out.print("Enter account ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter deposit amount: ");
                        BigDecimal amount = scanner.nextBigDecimal();
                        Optional<Account> acc = bank.findAccount(id);
                        acc.ifPresentOrElse(
                                a -> {
                                    a.deposit(amount);
                                    System.out.println("Deposit successful.");
                                },
                                () -> System.out.println("Account not found.")
                        );
                    }
                    case 3 -> {
                        System.out.print("Enter account ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter withdrawal amount: ");
                        BigDecimal amount = scanner.nextBigDecimal();
                        Optional<Account> acc = bank.findAccount(id);
                        acc.ifPresentOrElse(
                                a -> {
                                    try {
                                        a.withdraw(amount);
                                        System.out.println("Withdrawal successful.");
                                    } catch (Exception e) {
                                        System.out.println("Error: " + e.getMessage());
                                    }
                                },
                                () -> System.out.println("Account not found.")
                        );
                    }
                    case 4 -> {
                        System.out.print("Enter account ID: ");
                        String id = scanner.nextLine();
                        Optional<Account> acc = bank.findAccount(id);
                        acc.ifPresentOrElse(
                                a -> System.out.println("Balance: " + a.getBalance()),
                                () -> System.out.println("Account not found.")
                        );
                    }
                    case 5 -> {
                        System.out.print("From account ID: ");
                        String from = scanner.nextLine();
                        System.out.print("To account ID: ");
                        String to = scanner.nextLine();
                        System.out.print("Amount: ");
                        BigDecimal amount = scanner.nextBigDecimal();
                        try {
                            bank.transfer(from, to, amount);
                            System.out.println("Transfer successful.");
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                    case 6 -> {
                        System.out.println("Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}