import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AccountServiceTest {
    AccountService service;

    @BeforeEach
    void setUp() {
        // We use the class name from Student A
        service = new AccountService();
    }

    // --- PASSWORD LIMIT TESTS (BVA) ---
    @Test
    void testPasswordExactlyEight() {
        // Exactly 8 characters should work
        String result = service.validateSubmission("John", "Doe", "test@mail.com", "01/01/2000", "12345678", "12345678");
        assertEquals("SUCCESS", result);
    }

    @Test
    void testPasswordSevenChars() {
        // 7 characters is too short
        String result = service.validateSubmission("John", "Doe", "test@mail.com", "01/01/2000", "1234567", "1234567");
        assertEquals("Password too short", result);
    }

    // --- AGE / DATE TESTS (BVA) ---
    // Note: Since our logic currently checks strings, we test the error messages.
    
    @Test
    void testNameEmpty() {
        // Empty name should fail
        String result = service.validateSubmission("", "Doe", "test@mail.com", "01/01/2000", "pass1234", "pass1234");
        assertEquals("First Name is required", result);
    }

    @Test
    void testNameOnlyOneChar() {
        // Testing the smallest valid name
        String result = service.validateSubmission("A", "Doe", "test@mail.com", "01/01/2000", "pass1234", "pass1234");
        assertEquals("SUCCESS", result);
    }

    // --- HACKER TESTS / SPECIAL CASES ---
    @Test
    void testPasswordMismatch() {
        // Testing if passwords do not match
        String result = service.validateSubmission("John", "Doe", "test@mail.com", "01/01/2000", "pass1234", "wrong999");
        assertEquals("Passwords do not match", result);
    }

    @Test
    void testEmailWithoutAtSymbol() {
        // Testing email missing @
        String result = service.validateSubmission("John", "Doe", "myemail.com", "01/01/2000", "pass1234", "pass1234");
        assertEquals("Invalid Email Format", result);
    }
}
