import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AccountServiceTest {

    private AccountService service;

    @BeforeEach
    void setUp() {
        // Her testten önce yeni bir servis nesnesi oluşturulur (Requirement: Setup)
        service = new AccountService();
    }

    @AfterEach
    void tearDown() {
        // Test sonrası kaynaklar temizlenir (Requirement: Tear-down)
        service = null;
    }

    // =========================================================================
    // STUDENT A: EQUIVALENCE PARTITIONING (EP) TESTS
    // =========================================================================

    @Test
    @DisplayName("EP Test: Valid Submission")
    void testValidSubmission() {
        String result = service.validateSubmission("John", "Doe", "test@mail.com",
                "01/01/2000", "pass1234", "pass1234");
        assertEquals("SUCCESS", result);
    }

    @Test
    @DisplayName("EP Test: Invalid Email Format")
    void testInvalidEmail() {
        String result = service.validateSubmission("John", "Doe", "invalid-email.com",
                "01/01/2000", "pass1234", "pass1234");
        assertEquals("Invalid Email Format", result);
    }

    @Test
    @DisplayName("EP Test: Passwords Do Not Match")
    void testPasswordMismatch() {
        String result = service.validateSubmission("John", "Doe", "test@mail.com",
                "01/01/2000", "password123", "different456");
        assertEquals("Passwords do not match", result);
    }

    // =========================================================================
    // STUDENT B: BOUNDARY VALUE ANALYSIS (BVA) TESTS
    // =========================================================================

    @Test
    @DisplayName("BVA Test: Password Exactly 8 Characters (Min Boundary)")
    void testPasswordExactlyEight() {
        // Tam 8 karakter: Sınır noktası (Geçerli olmalı)
        String result = service.validateSubmission("Damla", "Zirek", "test@mail.com",
                "01/01/2000", "12345678", "12345678");
        assertEquals("SUCCESS", result);
    }

    @Test
    @DisplayName("BVA Test: Password 7 Characters (Below Min Boundary)")
    void testPasswordSevenChars() {
        // 7 karakter: Sınırın hemen altı (Hata vermeli)
        String result = service.validateSubmission("Damla", "Zirek", "test@mail.com",
                "01/01/2000", "1234567", "1234567");
        assertEquals("Password too short", result);
    }

    @Test
    @DisplayName("BVA Test: Age Exactly 18 (Boundary)")
    void testAgeExactlyEighteen() {
        // Bugün 5 Mayıs 2026. 18 yaş için doğum tarihi 05/05/2008 olmalı.
        String result = service.validateSubmission("Damla", "Zirek", "test@mail.com",
                "05/05/2008", "pass1234", "pass1234");
        assertEquals("SUCCESS", result);
    }

    @Test
    @DisplayName("BVA Test: Age 17 (Just Below Boundary)")
    void testAgeSeventeen() {
        // 06/05/2008 tarihi 17 yaş yapar (Reddedilmeli)
        String result = service.validateSubmission("Damla", "Zirek", "test@mail.com",
                "06/05/2008", "pass1234", "pass1234");
        assertNotEquals("SUCCESS", result);
    }

    @Test
    @DisplayName("BVA Test: First Name is Empty (Min Boundary)")
    void testNameEmpty() {
        // Boş isim: Alt sınır (Hata vermeli)
        String result = service.validateSubmission("", "Zirek", "test@mail.com",
                "01/01/2000", "pass1234", "pass1234");
        assertEquals("First Name is required", result);
    }

    @Test
    @DisplayName("BVA Test: First Name 51 Characters (Above Max Boundary)")
    void testNameFiftyOneChars() {
        // 51 karakter: Üst sınırın hemen üstü (Hata vermeli)
        String longName = "a".repeat(51);
        String result = service.validateSubmission(longName, "Zirek", "test@mail.com",
                "01/01/2000", "pass1234", "pass1234");
        assertNotEquals("SUCCESS", result);
    }
}
