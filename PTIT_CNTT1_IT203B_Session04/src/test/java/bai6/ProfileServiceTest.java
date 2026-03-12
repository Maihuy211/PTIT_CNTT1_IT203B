package bai6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertNull;


public class ProfileServiceTest {

    private ProfileService service;
    private User existingUser;
    private List<User> users;

    @BeforeEach
    void setUp() {
        service = new ProfileService();
        existingUser = new User("user@gmail.com", LocalDate.of(2000,1,1));

        users = new ArrayList<>();
        users.add(existingUser);
        users.add(new User("other@gmail.com", LocalDate.of(1999,1,1)));
    }

    // Email hợp lệ + ngày sinh hợp lệ
    @Test
    void testValidUpdate() {
        UserProfile newProfile =
                new UserProfile("new@gmail.com", LocalDate.of(1998,1,1));

        User result = service.updateProfile(existingUser, newProfile, users);

        assertNotNull(result);
    }

    // Ngày sinh trong tương lai
    @Test
    void testFutureBirthDate() {
        UserProfile newProfile =
                new UserProfile("new@gmail.com", LocalDate.now().plusDays(1));

        User result = service.updateProfile(existingUser, newProfile, users);

        assertNull(result);
    }

    // Email trùng
    @Test
    void testDuplicateEmail() {
        UserProfile newProfile =
                new UserProfile("other@gmail.com", LocalDate.of(1998,1,1));

        User result = service.updateProfile(existingUser, newProfile, users);

        assertNull(result);
    }

    // Email giống email cũ
    @Test
    void testSameEmailUpdate() {
        UserProfile newProfile =
                new UserProfile("user@gmail.com", LocalDate.of(1995,1,1));

        User result = service.updateProfile(existingUser, newProfile, users);

        assertNotNull(result);
    }
}