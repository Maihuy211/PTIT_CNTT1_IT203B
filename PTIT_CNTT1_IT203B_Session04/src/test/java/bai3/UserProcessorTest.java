package bai3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserProcessorTest {
    private UserProcessor processor;
    // chạy trước mỗi test
    @BeforeEach
    void setUp() {
        processor = new UserProcessor();
    }
    // TC01: email hợp lệ
    @Test
    void testValidEmail() {
        String email = "user@gmail.com";
        String result = processor.processEmail(email);
        assertEquals("user@gmail.com", result);
    }
    // TC02: email thiếu @
    @Test
    void testEmailMissingAtSymbol() {
        String email = "usergmail.com";
        assertThrows(IllegalArgumentException.class, () -> {
            processor.processEmail(email);
        });
    }
    // TC03: email có @ nhưng không có domain
    @Test
    void testEmailMissingDomain() {
        String email = "user@";
        assertThrows(IllegalArgumentException.class, () -> {
            processor.processEmail(email);
        });
    }
    // TC04: kiểm tra chuẩn hóa lowercase
    @Test
    void testEmailNormalizationToLowercase() {
        String email = "Example@Gmail.com";
        String result = processor.processEmail(email);
        assertEquals("example@gmail.com", result);
    }
}