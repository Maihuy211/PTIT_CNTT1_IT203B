package exercise01;

public class Main {
    public static void main(String[] args) {
        boolean result = Dao.loginDoctor("D001", "' OR '1'='1");
        if (result) {
            System.out.println("Đăng nhập thành công!");
        } else {
            System.out.println("Đăng nhập thất bại!");
        }
    }
}
