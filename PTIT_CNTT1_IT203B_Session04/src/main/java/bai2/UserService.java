package bai2;

public class UserService {

    public boolean checkRegistrationAge(int age) {
        // nếu tuổi âm -> ném ngoại lệ
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        // đủ 18 tuổi mới đăng ký được
        return age >= 18;
    }
}