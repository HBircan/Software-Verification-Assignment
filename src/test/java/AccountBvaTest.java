import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * STUDENT B: Automation & Boundary Value Analysis (BVA) Tests
 */
public class AccountBvaTest {

    private AccountService service;

    @BeforeEach
    void setUp() {
        service = new AccountService();
    }

    @AfterEach
    void tearDown() {
        service = null;
    }

    // --- 1. ŞİFRE SINIRLARI (PASSWORD BVA) ---

    @Test
    @DisplayName("BVA 1: Password Exactly 8 Characters (Lower Bound)")
    void testPasswordExactlyEight() {
        // Tam 8 karakter: Sistemin kabul etmesi gereken en küçük sınır.
        String result = service.validateSubmission("John", "Doe", "test@mail.com", "01/01/2000", "12345678", "12345678");
        assertEquals("SUCCESS", result);
    }

    @Test
    @DisplayName("BVA 2: Password 7 Characters (Just Below Bound)")
    void testPasswordSevenChars() {
        // 7 karakter: Sınırın bir altı, hata vermeli.
        String result = service.validateSubmission("John", "Doe", "test@mail.com", "01/01/2000", "1234567", "1234567");
        assertEquals("Password too short", result);
    }

    // --- 2. YAŞ / TARİH SINIRLARI (AGE BVA) ---

    @Test
    @DisplayName("BVA 3: Age Exactly 18 (Lower Bound)")
    void testAgeExactlyEighteen() {
        // 2008 doğumlu birisi 2026'da tam 18 olur.
        String result = service.validateSubmission("John", "Doe", "test@mail.com", "01/01/2008", "pass1234", "pass1234");
        assertEquals("SUCCESS", result);
    }

    @Test
    @DisplayName("BVA 4: Age 17 (Just Below Bound)")
    void testAgeSeventeen() {
        // 17 yaş: Sınırın hemen altı, reddedilmeli.
        String result = service.validateSubmission("John", "Doe", "test@mail.com", "01/01/2009", "pass1234", "pass1234");
        assertEquals("User must be at least 18 years old", result);
    }

    @Test
    @DisplayName("BVA 5: Age Exactly 120 (Upper Bound)")
    void testAgeOneHundredTwenty() {
        // 120 yaş: Kabul edilen en üst sınır.
        String result = service.validateSubmission("John", "Doe", "test@mail.com", "01/01/1906", "pass1234", "pass1234");
        assertEquals("SUCCESS", result);
    }

    // --- 3. İSİM UZUNLUK SINIRLARI (NAME BVA) ---

    @Test
    @DisplayName("BVA 6: Name Exactly 1 Character (Min Valid)")
    void testNameOneChar() {
        // Tek harfli isim: En küçük geçerli sınır.
        String result = service.validateSubmission("A", "Doe", "test@mail.com", "01/01/2000", "pass1234", "pass1234");
        assertEquals("SUCCESS", result);
    }

    @Test
    @DisplayName("BVA 7: Name Empty (Below Min)")
    void testNameEmpty() {
        // 0 karakter: Sınırın altı, hata vermeli.
        String result = service.validateSubmission("", "Doe", "test@mail.com", "01/01/2000", "pass1234", "pass1234");
        assertEquals("First Name is required", result);
    }

    @Test
    @DisplayName("BVA 8: Name 51 Characters (Above Max)")
    void testNameFiftyOneChars() {
        // 51 karakter: Üst sınırın (50) bir üstü.
        String longName = "a".repeat(51);
        String result = service.validateSubmission(longName, "Doe", "test@mail.com", "01/01/2000", "pass1234", "pass1234");
        assertEquals("Invalid Name Length", result);
    }
}
