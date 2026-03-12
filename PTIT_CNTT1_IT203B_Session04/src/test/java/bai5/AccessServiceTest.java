package bai5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;


public class AccessServiceTest {

    private AccessService service;
    private User admin;
    private User moderator;
    private User user;

    @BeforeEach
    void setUp() {
        service = new AccessService();
        admin = new User("Admin", Role.ADMIN);
        moderator = new User("Mod", Role.MODERATOR);
        user = new User("User", Role.USER);
    }

    @AfterEach
    void tearDown() {
        admin = null;
        moderator = null;
        user = null;
    }

    // ADMIN DELETE_USER
    @Test
    void testAdminDeleteUser() {
        boolean result = service.canPerformAction(admin, Action.DELETE_USER);
        assertTrue(result);
    }

    // ADMIN LOCK_USER
    @Test
    void testAdminLockUser() {
        boolean result = service.canPerformAction(admin, Action.LOCK_USER);
        assertTrue(result);
    }

    // ADMIN VIEW_PROFILE
    @Test
    void testAdminViewProfile() {
        boolean result = service.canPerformAction(admin, Action.VIEW_PROFILE);
        assertTrue(result);
    }

    // MODERATOR DELETE_USER
    @Test
    void testModeratorDeleteUser() {
        boolean result = service.canPerformAction(moderator, Action.DELETE_USER);
        assertFalse(result);
    }

    // MODERATOR LOCK_USER
    @Test
    void testModeratorLockUser() {
        boolean result = service.canPerformAction(moderator, Action.LOCK_USER);
        assertTrue(result);
    }

    // MODERATOR VIEW_PROFILE
    @Test
    void testModeratorViewProfile() {
        boolean result = service.canPerformAction(moderator, Action.VIEW_PROFILE);
        assertTrue(result);
    }

    // USER DELETE_USER
    @Test
    void testUserDeleteUser() {
        boolean result = service.canPerformAction(user, Action.DELETE_USER);
        assertFalse(result);
    }

    // USER LOCK_USER
    @Test
    void testUserLockUser() {
        boolean result = service.canPerformAction(user, Action.LOCK_USER);
        assertFalse(result);
    }

    // USER VIEW_PROFILE
    @Test
    void testUserViewProfile() {
        boolean result = service.canPerformAction(user, Action.VIEW_PROFILE);
        assertTrue(result);
    }
}