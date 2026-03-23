package exercise05.presentation;

import exercise05.business.PatientBusiness;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("1. Danh sách bệnh nhân");
            System.out.println("2. Thêm bệnh nhân");
            System.out.println("3. Cập nhật bệnh án");
            System.out.println("4. Xuất viện & tính phí");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    PatientBusiness.displayPatients(sc);
                    break;
                case 2:
                    PatientBusiness.addPatients(sc);
                    break;
                case 3:
                    PatientBusiness.updatePatients(sc);
                    break;
                case 4:
                    PatientBusiness.calculatePatientsFee(sc);
                    break;
                case 5:
                    System.out.println("thoát chương trình");
                    break;
                default:
                    System.out.println("Mời bạn nhập lại");
            }
        }while (choice != 5);
        sc.close();
    }
}
