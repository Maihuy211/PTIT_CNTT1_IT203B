package bai1;

public class UserValidator {
    public boolean isValidUsername(String username) {
        if (username == null) {
            return false;
        }
        // độ dài từ 6 -> 20
        if (username.length() < 6 || username.length() > 20) {
            return false;
        }
        // không chứa khoảng trắng
        if (username.contains(" ")) {
            return false;
        }
        return true;
    }
}
