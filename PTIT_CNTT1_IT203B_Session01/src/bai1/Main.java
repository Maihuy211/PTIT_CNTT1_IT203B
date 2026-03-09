package bai1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Nhập năm sinh: ");
            String input = sc.nextLine();

            int year = Integer.parseInt(input);

            int age = 2026 - year;
            System.out.println("Số tuổi: " + age);
        }catch (NumberFormatException e){
            System.out.println("Lỗi : Phải nhập chữ thay vì số");
        }finally {
            sc.close();
            System.out.println("Thực hiện dọn dẹp tài nguyên trong finally...");
        }
    }
}