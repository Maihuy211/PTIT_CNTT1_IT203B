package exercise05.presentation;

import exercise05.business.HospitalBusiness;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HospitalBusiness bs = new HospitalBusiness();
        int choice = 0;
        do {
            System.out.println("1. Xem giường");
            System.out.println("2. Tiếp nhận");
            System.out.println("3. Thoát");
            System.out.println("CHọn: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    bs.hienThiGiuong();
                    break;
                case 2:
                    sc.nextLine();
                    System.out.print("Tên: ");
                    String name = sc.nextLine();

                    System.out.print("Tuổi: ");
                    int age = sc.nextInt();

                    System.out.print("Giường: ");
                    int bed = sc.nextInt();

                    System.out.print("Tiền: ");
                    double money = sc.nextDouble();

                    bs.tiepNhan(name, age, bed, money);
                    break;
                case 3:
                    System.out.println("Thoát chương trình");
                    break;
                default:
                    System.out.println("Mời nhập lại");
            }
        }while (choice != 3) ;
    }
}