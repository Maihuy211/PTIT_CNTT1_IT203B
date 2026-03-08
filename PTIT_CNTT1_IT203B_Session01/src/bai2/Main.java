package bai2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập vào tổng số người dùng: ");
        int totalUser = sc.nextInt();

        System.out.println("Nhập số lượng nhóm: ");
        int numberGroup = sc.nextInt();

        try{
            int numberUser = totalUser / numberGroup;
            System.out.println("Mỗi nhóm có: " + numberUser);
        }catch (ArithmeticException e) {
            System.out.println("Không thể chia cho 0;");
        }
    }
}
