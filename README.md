# 📝 Project: Create New Account Validation
**Lecture:** Software Verification and Validation  
**Group:** Student A & Student B  

---

## 🚀 Overview
This project focuses on testing the **"Submit"** feature of a registration page. We act as Quality Engineers to ensure the inputs are validated correctly and the system is robust against errors before it reaches the users.

## 🛠️ Tech Stack
* **Language:** Java 21 & 17
* **Framework:** JUnit 5
* **Build Tool:** Maven
* **Automation:** GitHub Actions (CI/CD)

---

## 🧪 Testing Strategies
We used two main techniques to reach our goal of **15+ test cases**:

### 1. Equivalence Partitioning (EP) - *Done by Student A*
We divided inputs into groups to test different categories of behavior:
* **Valid Inputs:** Testing "Happy Path" scenarios where all data is correct.
* **Invalid Formats:** Testing emails without `@` or empty name fields.
* **Logic Checks:** Ensuring the "Password" and "Confirm Password" fields match.

### 2. Boundary Value Analysis (BVA) - *Done by Student B*
We tested the "edges" of the input fields:
* **Length Limits:** Testing passwords exactly at the minimum 8-character limit.
* **Empty States:** Testing what happens when fields are left totally blank.

---

## ⚙️ How to Run the Tests
1. **Locally:** * Open the project in **IntelliJ IDEA**.
   * Right-click the `src/test/java/AccountServiceTest.java` file.
   * Select **Run 'AccountServiceTest'**.
2. **Automatically:** * Every time we "Push" code to this repository, **GitHub Actions** runs the tests automatically. 
   * You can see the results in the **[Actions]** tab above. ✅

---

## 🤝 Collaboration History
To meet the project requirements, we used:
* **Branching:** Working on separate tasks without breaking the main code.
* **Pull Requests (PRs):** We reviewed each other's code and left comments before merging.
* **Commit History:** A clear record of who added which test cases.

---

### 👨‍💻 Group Members
* **Student A:** System Logic & EP Tests
* **Student B:** Automation & BVA Tests
