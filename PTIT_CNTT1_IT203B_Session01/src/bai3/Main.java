package bai3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User u = new User();
        try{
            System.out.println("Nhập tuổi: ");
            int age = sc.nextInt();
            u.setAge(age);
            System.out.println("Tuổi: " + u.getAge());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
