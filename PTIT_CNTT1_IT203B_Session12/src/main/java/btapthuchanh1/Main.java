package btapthuchanh1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // tìm kếm
        DoctorBuisiness.findDoctorBySpecialty(sc);
        // update mật khẩu
        DoctorBuisiness.updatePassword(sc);
        // tính phí

        sc.close();
    }
}
