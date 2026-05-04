# Software-Verification-Assignment

Topic: Create New Account Page Testing
Project Overview
This project is for our 3rd-year Software Engineering class. Our goal is to act as Quality Engineers to test the "Create New Account" feature. We wrote a Java program that validates user inputs like Name, Email, and Password, and then we wrote automated tests to try and "break" the code before a real user does.

Group Members
Student A: Logic Development and Equivalence Partitioning (EP) Tests.

Student B: Automation (GitHub Actions) and Boundary Value Analysis (BVA) Tests.

How We Tested
We used JUnit 5 to create 15 different test cases. We focused on two main techniques:

Equivalence Partitioning (EP): Grouping inputs into categories (like valid vs. invalid emails) to make sure each type of input is handled correctly.

Boundary Value Analysis (BVA): Testing the "edges" of the rules, such as passwords that are exactly 8 characters long or names that are empty.

Requirements Met
Unit Testing: Created in Java using the JUnit 5 framework.

Setup & Teardown: Used @BeforeEach to reset the system and @AfterEach to clean up after every test.

Assertions: Used assertEquals and assertTrue to verify if the results matched our expectations.

Automation: Integrated with GitHub Actions to run all tests automatically whenever we push new code.

How to Run the Code
In an IDE: Open the project in IntelliJ IDEA as a Maven project. Navigate to src/test/java/AccountServiceTest.java, right-click, and select Run.

On GitHub: Go to the Actions tab in this repository to see the history of automated test runs and results.

Features Validated
First Name: Cannot be empty or just spaces.

Email: Must contain an @ symbol and follow a valid format.

Password: Must be at least 8 characters long.

Confirm Password: Must match the original password exactly.
