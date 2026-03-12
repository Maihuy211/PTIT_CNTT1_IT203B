package bai6;

import java.time.LocalDate;
import java.util.List;

public class ProfileService {
    public User updateProfile(User existingUser, UserProfile newProfile, List<User> allUsers) {
        // kiểm tra ngày sinh trong tương lai
        if (newProfile.getBirthDate().isAfter(LocalDate.now())) {
            return null;
        }
        // kiểm tra email trùng
        if (allUsers != null) {
            for (User u : allUsers) {
                if (u != existingUser && u.getEmail().equals(newProfile.getEmail())) {
                    return null;
                }
            }
        }
        // cập nhật thông tin
        existingUser.setEmail(newProfile.getEmail());
        existingUser.setBirthDate(newProfile.getBirthDate());

        return existingUser;
    }
}