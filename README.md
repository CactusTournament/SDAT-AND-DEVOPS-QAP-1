# Simple Banking Application  
## User Documentation

**Final Sprint -- SDAT & DevOps QAP 1**

---

## 1. Overview of the Application

### What Is the Simple Banking Application?

The **Simple Banking Application** is a Java-based, console-driven system for managing basic banking operations. It demonstrates object-oriented design, clean code practices, automated testing, and CI/CD integration using Maven and GitHub Actions.

This application allows users to:

- Create and manage bank accounts
- Deposit and withdraw funds
- Check balances
- Transfer money between accounts

All operations are performed through a text-based menu interface.

---

### Who Is This Application For?

This application is designed for:

- **Developers**: To learn and demonstrate Java OOP, testing, and CI/CD
- **Students**: As a reference for clean code and DevOps practices
- **Anyone**: Wanting a simple, extensible banking simulation

---

### What Does the Application Do?

The Simple Banking Application enables users to:

- Create new accounts with an initial balance
- Deposit and withdraw money (with validation)
- Check account balances
- Transfer funds between accounts (bonus feature)

All data is managed in-memory for simplicity.

---

### How the System Works (Simple Explanation)

```
User --> Menu Selection --> Perform Banking Action --> Data Updated in Memory
```

1. User selects an action from the menu  
2. The system processes the request  
3. Account data is updated and displayed  
4. Automated tests verify all logic  
5. CI pipeline ensures code quality on every pull request

---

## 2. Features and Capabilities

### Core Features

- **Account Creation**: Open new accounts with an initial deposit
- **Deposit**: Add funds to an account
- **Withdraw**: Remove funds (with overdraft and negative amount checks)
- **Balance Inquiry**: View current account balance
- **Transfer**: Move funds between accounts (bonus)

---

## 3. Project Structure

```
src/main/java/com/example/bank/
    Account.java
    BankService.java
    Main.java

src/test/java/com/example/bank/
    AccountTest.java
    BankServiceTest.java

.github/workflows/
    maven.yml

pom.xml
```

---

## 4. Clean Code Practices

### Examples

1. **Single Responsibility Principle**  
   - `Account.java` handles only account logic (deposit, withdraw, validation)
2. **Descriptive Naming**  
   - Methods like `deposit()`, `withdraw()`, `transfer()` clearly state their purpose
3. **Guard Clauses for Validation**  
   ```java
   if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
       throw new IllegalArgumentException("Amount must be positive");
   }
   ```
   Prevents invalid state early and keeps methods clean

---

## 5. Unit Testing

### Test Classes

- **AccountTest.java**:  
  Tests deposit, withdraw, negative amounts, and overdraft errors
- **BankServiceTest.java**:  
  Tests account creation, duplicate accounts, and transfers

### Assertions Used

- `assertEquals`
- `assertTrue`
- `assertNotNull`
- `assertThrows`

### Scenarios

- **Positive**: Valid deposit, withdrawal, transfer
- **Negative**: Overdraft, negative deposit, duplicate account

---

## 6. Dependencies

All dependencies are from Maven Central.

**JUnit 5**
```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.10.2</version>
    <scope>test</scope>
</dependency>
```

**Maven Surefire Plugin**  
Ensures JUnit 5 tests run correctly.

---

## 7. GitHub Actions CI

A workflow file is located at `.github/workflows/maven.yml`.

**Workflow:**
- Runs on every Pull Request to `main`
- Builds the project
- Runs all tests automatically

**Sample Workflow File:**
```yaml
name: Java CI with Maven

on:
  pull_request:
    branches: [ "main" ]

jobs:
  build:
    runs-on: ubuntu-latest

    steps:
      - name: Checkout repository
        uses: actions/checkout@v4

      - name: Set up JDK 17
        uses: actions/setup-java@v4
        with:
          distribution: 'temurin'
          java-version: '17'

      - name: Build with Maven
        run: mvn -B test
```

---

## 8. Dev/Trunk-Based Workflow

- Create `dev` branch
- Commit changes to `dev`
- Open Pull Requests into `main`
- GitHub Actions runs tests
- Merge when green

Demonstrates proper branching and CI integration.

---

## 9. Problems Encountered

1. **Maven Archetype Would Not Generate Project**  
   - PowerShell misinterpreted the Maven command due to spaces in the user directory  
   - **Fix**: Use CMD instead of PowerShell, or run Maven from a folder without spaces

2. **JUnit 3 was included by default**  
   - The Maven quickstart archetype uses outdated JUnit 3  
   - **Fix**: Replaced with JUnit 5 and added Surefire plugin

---

## 10. Conclusion

This project meets all QAP requirements:

- Java application with clean OOP design
- At least 3 unit tests (more included)
- GitHub Actions CI pipeline
- Clean code examples
- Dev/trunk workflow
- Clear documentation

---

## 11. How to Set Up GitHub Actions CI

**Step 1 — Create folders**
```sh
mkdir .github
mkdir .github/workflows
```

**Step 2 — Create the workflow file**
```sh
notepad .github/workflows/maven.yml
```

**Step 3 — Paste this inside:**
```yaml
name: Java CI with Maven

on:
  pull_request:
    branches: [ "main" ]

jobs:
  build:
    runs-on: ubuntu-latest

    steps:
      - name: Checkout repository
        uses: actions/checkout@v4

      - name: Set up JDK 17
        uses: actions/setup-java@v4
        with:
          distribution: 'temurin'
          java-version: '17'

      - name: Build with Maven
        run: mvn -B test
```

---

## 12. Summary

The **Simple Banking Application** is a concise, well-structured Java project that demonstrates:

- Core banking operations
- Clean code and OOP principles
- Automated unit testing
- Continuous integration with GitHub Actions
- Modern development workflow

It is designed to be **reliable**, **maintainable**, and **easy to extend** for future enhancements.

Author: Brandon Maloney & SD14
Date: 2026-02-05

