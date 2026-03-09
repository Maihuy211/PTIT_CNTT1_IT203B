package bai6;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập tên người dùng: ");
        String name = sc.nextLine();
        if(name == null || name.trim().isEmpty()){
            System.out.println("Tên không hợp lệ");
            return;
        }
        try{
            User user = new User(name);

            if(user != null){
                System.out.println("Tên người dùng: " + user.getName());
            }
        }catch(IllegalArgumentException e){
            Logger.logError("Dữ liệu không hợp lệ: " + e.getMessage());
        }
    }
}