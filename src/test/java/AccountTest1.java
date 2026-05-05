import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {
    Account account;

    @BeforeEach
    void setUp() {
        account = new Account();
    }

    // --- ŞİFRE SINIR TESTLERİ (BVA) ---
    @Test
    void testPasswordExactlyEight() {
        assertTrue(account.validatePassword("12345678"));
    }

    @Test
    void testPasswordSevenChars() {
        assertFalse(account.validatePassword("1234567"));
    }

    // --- YAŞ SINIR TESTLERİ (BVA) ---
    @Test
    void testAgeExactlyEighteen() {
        assertTrue(account.validateAge(18));
    }

    @Test
    void testAgeSeventeen() {
        assertFalse(account.validateAge(17));
    }

    @Test
    void testAgeExactlyOneHundredTwenty() {
        assertTrue(account.validateAge(120));
    }

    @Test
    void testAgeOneHundredTwentyOne() {
        assertFalse(account.validateAge(121));
    }

    // --- İSİM SINIR TESTLERİ (BVA) ---
    @Test
    void testNameEmpty() {
        assertFalse(account.validateName(""));
    }

    @Test
    void testNameFiftyOneChars() {
        String longName = "a".repeat(51);
        assertFalse(account.validateName(longName));
    }
}
