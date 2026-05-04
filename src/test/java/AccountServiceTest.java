import org.junit.jupiter.api.*; 
import static org.junit.jupiter.api.Assertions.*; 

public class AccountServiceTest {

    private AccountService service;

    @BeforeEach
    void setUp() {
        // Requirement: Setup method
        service = new AccountService();
    }

    @AfterEach
    void tearDown() {
        // Requirement: Tear-down method
        service = null;
    }

    @Test
    @DisplayName("EP Test: Valid Submission")
    void testValidSubmission() {
        String result = service.validateSubmission("John", "Doe", "test@mail.com",
                "01/01/2000", "pass1234", "pass1234");
        assertEquals("SUCCESS", result); // Requirement: Assertion
    }

    @Test
    @DisplayName("EP Test: Empty First Name")
    void testEmptyFirstName() {
        String result = service.validateSubmission("", "Doe", "test@mail.com",
                "01/01/2000", "pass1234", "pass1234");
        assertEquals("First Name is required", result);
    }

    @Test
    @DisplayName("EP Test: Invalid Email Format")
    void testInvalidEmail() {
        // CASE: Email missing the '@' symbol
        String result = service.validateSubmission("John", "Doe", "invalid-email.com",
                "01/01/2000", "pass1234", "pass1234");
        assertEquals("Invalid Email Format", result);
    }

    @Test
    @DisplayName("EP Test: Passwords Do Not Match")
    void testPasswordMismatch() {
        // CASE: Password and Confirm Password are different
        String result = service.validateSubmission("John", "Doe", "test@mail.com",
                "01/01/2000", "password123", "different456");
        assertEquals("Passwords do not match", result);
    }

    @Test
    @DisplayName("EP Test: Password Too Short")
    void testPasswordTooShort() {
        // CASE: Password length is less than 8 (e.g., 5 characters)
        String result = service.validateSubmission("John", "Doe", "test@mail.com",
                "01/01/2000", "short", "short");
        assertEquals("Password too short", result);
    }

    @Test
    @DisplayName("EP Test: Null Email")
    void testNullEmail() {
        // CASE: What if the email field is null?
        String result = service.validateSubmission("John", "Doe", null,
                "01/01/2000", "pass1234", "pass1234");
        assertEquals("Invalid Email Format", result);
    }

    @Test
    @DisplayName("EP Test: First Name is Only Spaces")
    void testFirstNameSpaces() {
        // CASE: A user enters "   " instead of a name
        String result = service.validateSubmission("   ", "Doe", "test@mail.com",
                "01/01/2000", "pass1234", "pass1234");
        assertEquals("First Name is required", result);
    }

    @Test
    @DisplayName("EP Test: Valid Submission with Different Email")
    void testAnotherValidSubmission() {
        // CASE: Another valid "Happy Path" to ensure consistency
        String result = service.validateSubmission("Jane", "Smith", "jane.smith@service.org",
                "12/12/1995", "securePass99", "securePass99");
        assertEquals("SUCCESS", result);
    }
}
