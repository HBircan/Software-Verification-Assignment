import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AccountServiceTest {

    private AccountService service;

    @BeforeEach
    void setUp() {
        service = new AccountService();
    }

    @AfterEach
    void tearDown() {
        service = null;
    }

    // --- STUDENT A: EQUIVALENCE PARTITIONING (EP) ---

    @Test
    @DisplayName("EP Test: Valid Submission")
    void testValidSubmission() {
        String result = service.validateSubmission("John", "Doe", "test@mail.com", "01/01/2000", "pass1234", "pass1234");
        assertEquals("SUCCESS", result);
    }

    @Test
    @DisplayName("EP Test: Empty First Name")
    void testEmptyFirstName() {
        String result = service.validateSubmission("", "Doe", "test@mail.com", "01/01/2000", "pass1234", "pass1234");
        assertEquals("First Name is required", result);
    }

    @Test
    @DisplayName("EP Test: Invalid Email Format")
    void testInvalidEmail() {
        String result = service.validateSubmission("John", "Doe", "invalid-email.com", "01/01/2000", "pass1234", "pass1234");
        assertEquals("Invalid Email Format", result);
    }

    @Test
    @DisplayName("EP Test: Passwords Do Not Match")
    void testPasswordMismatchEP() {
        String result = service.validateSubmission("John", "Doe", "test@mail.com", "01/01/2000", "password123", "different456");
        assertEquals("Passwords do not match", result);
    }

    @Test
    @DisplayName("EP Test: Password Too Short")
    void testPasswordTooShortEP() {
        String result = service.validateSubmission("John", "Doe", "test@mail.com", "01/01/2000", "short", "short");
        assertEquals("Password too short", result);
    }

    @Test
    @DisplayName("EP Test: Null Email")
    void testNullEmail() {
        String result = service.validateSubmission("John", "Doe", null, "01/01/2000", "pass1234", "pass1234");
        assertEquals("Invalid Email Format", result);
    }

    @Test
    @DisplayName("EP Test: First Name is Only Spaces")
    void testFirstNameSpaces() {
        String result = service.validateSubmission("   ", "Doe", "test@mail.com", "01/01/2000", "pass1234", "pass1234");
        assertEquals("First Name is required", result);
    }

    @Test
    @DisplayName("EP Test: Valid Submission with Different Email")
    void testAnotherValidSubmission() {
        String result = service.validateSubmission("Jane", "Smith", "jane.smith@service.org", "12/12/1995", "securePass99", "securePass99");
        assertEquals("SUCCESS", result);
    }

    // --- STUDENT B: BOUNDARY VALUE ANALYSIS (BVA) ---

    @Test
    @DisplayName("BVA Test: Password Exactly 8 Chars")
    void testPasswordExactlyEight() {
        String result = service.validateSubmission("John", "Doe", "test@mail.com", "01/01/2000", "12345678", "12345678");
        assertEquals("SUCCESS", result);
    }

    @Test
    @DisplayName("BVA Test: Password 7 Chars")
    void testPasswordSevenChars() {
        String result = service.validateSubmission("John", "Doe", "test@mail.com", "01/01/2000", "1234567", "1234567");
        assertEquals("Password too short", result);
    }

    @Test
    @DisplayName("BVA Test: Name Empty")
    void testNameEmpty() {
        String result = service.validateSubmission("", "Doe", "test@mail.com", "01/01/2000", "pass1234", "pass1234");
        assertEquals("First Name is required", result);
    }

    @Test
    @DisplayName("BVA Test: Name One Char")
    void testNameOnlyOneChar() {
        String result = service.validateSubmission("A", "Doe", "test@mail.com", "01/01/2000", "pass1234", "pass1234");
        assertEquals("SUCCESS", result);
    }

    @Test
    @DisplayName("BVA Test: Wrong Confirm Password")
    void testPasswordMismatchBVA() {
        String result = service.validateSubmission("John", "Doe", "test@mail.com", "01/01/2000", "pass1234", "wrong999");
        assertEquals("Passwords do not match", result);
    }

    @Test
    @DisplayName("BVA Test: Missing @ in Email")
    void testEmailWithoutAtSymbol() {
        String result = service.validateSubmission("John", "Doe", "myemail.com", "01/01/2000", "pass1234", "pass1234");
        assertEquals("Invalid Email Format", result);
    }
}
