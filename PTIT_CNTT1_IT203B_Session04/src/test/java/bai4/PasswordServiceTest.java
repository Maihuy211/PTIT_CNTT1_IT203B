package bai4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.testng.AssertJUnit.assertEquals;


public class PasswordServiceTest {

    private PasswordService service;

    @BeforeEach
    void setUp() {
        service = new PasswordService();
    }

    // TC01 Mật khẩu có đủ: ≥8 ký tự, chữ hoa, chữ thường, số và ký tự đặc biệt
    @Test
    void testStrongPassword() {
        String result = service.evaluatePasswordStrength("Abc123!@");
        assertEquals("Mạnh", result);
    }

    // TC02 Thiếu chữ hoa
    @Test
    void testMissingUppercase() {
        String result = service.evaluatePasswordStrength("abc123!@");
        assertEquals("Trung bình", result);
    }

    // TC03 Thiếu chữ thường
    @Test
    void testMissingLowercase() {
        String result = service.evaluatePasswordStrength("ABC123!@");
        assertEquals("Trung bình", result);
    }

    // TC04 Thiếu số
    @Test
    void testMissingDigit() {
        String result = service.evaluatePasswordStrength("Abcdef!@");
        assertEquals("Trung bình", result);
    }

    // TC05 Thiếu ký tự đặc biệt
    @Test
    void testMissingSpecialCharacter() {
        String result = service.evaluatePasswordStrength("Abc12345");
        assertEquals("Trung bình", result);
    }

    // TC06 Mật khẩu quá ngắn (<8 ký tự)
    @Test
    void testShortPassword() {
        String result = service.evaluatePasswordStrength("Ab1!");
        assertEquals("Yếu", result);
    }

    // TC07 Chỉ có chữ thường
    @Test
    void testOnlyLowercase() {
        String result = service.evaluatePasswordStrength("password");
        assertEquals("Yếu", result);
    }

    // TC08 Chỉ có chữ hoa và số
    @Test
    void testUppercaseAndDigitsOnly() {
        String result = service.evaluatePasswordStrength("ABC12345");
        assertEquals("Yếu", result);
    }
}