package bai2;

import org.junit.jupiter.api.Test;

import static org.testng.Assert.assertThrows;
import static org.testng.AssertJUnit.assertEquals;

public class UserServiceTest {
    UserService service = new UserService();
    // TC01: tuổi = 18
    @Test
    void testAge18() {
        int age = 18;
        boolean result = service.checkRegistrationAge(age);
        assertEquals(true, result);
    }
    @Test
    void testAge17() {
        int age = 17;
        boolean result = service.checkRegistrationAge(age);
        assertEquals(false, result);
    }
    @Test
    void testNegativeAge() {
        int age = -1;
        assertThrows(IllegalArgumentException.class, () -> {
            service.checkRegistrationAge(age);
        });
    }
}