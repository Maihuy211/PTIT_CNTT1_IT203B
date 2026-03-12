package bai1;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class UserValidatorTest {
    UserValidator validator = new UserValidator();

    // TC01: username hợp lệ
    @Test
    void testValidUsername() {
        String username = "user123";
        boolean result = validator.isValidUsername(username);
        assertTrue(result);
    }
    // TC02: username quá ngắn
    @Test
    void testUsernameTooShort() {
        String username = "abc";
        boolean result = validator.isValidUsername(username);
        assertFalse(result);
    }
    // TC03: username chứa khoảng trắng
    @Test
    void testUsernameContainsSpace() {
        String username = "user name";
        boolean result = validator.isValidUsername(username);
        assertFalse(result);
    }
}
