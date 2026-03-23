package exercise06.presentation;

import exercise06.business.MedicineBusiness;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do{
            System.out.println("1. Cập nhật kho");
            System.out.println("2. Tìm theo giá");
            System.out.println("3. Tổng tiền đơn thuốc");
            System.out.println("4. Doanh thu theo ngày");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    MedicineBusiness.updateStock(sc);
                    break;
                case 2:
                    MedicineBusiness.findByPrice(sc);
                    break;
                case 3:
                    MedicineBusiness.calculateTotal(sc);
                    break;
                case 4:
                    MedicineBusiness.getRevenue(sc);
                    break;
                case 5:
                    System.out.println("Thoát chương trình");
                    break;
                default:
                    System.out.println("Mời bạn nhập lại");
            }
        }while (choice != 5);
    }
}
