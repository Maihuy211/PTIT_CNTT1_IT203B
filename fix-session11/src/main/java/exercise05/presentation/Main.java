package exercise05.presentation;

import exercise05.business.DoctorService;
import exercise05.dao.DoctorDAO;
import exercise05.model.Doctor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/Hospital_DB";
    private static final String USER = "root";
    private static final String PASS = "Mhuy2110";

    public static void main(String[] args) {

        try (
                Connection conn = DriverManager.getConnection(URL, USER, PASS);
                Scanner sc = new Scanner(System.in)
        ) {

            DoctorDAO dao = new DoctorDAO(conn);
            DoctorService service = new DoctorService(dao);

            int choice;

            do {
                System.out.println("\n===== MENU =====");
                System.out.println("1. Xem danh sách bác sĩ");
                System.out.println("2. Thêm bác sĩ");
                System.out.println("3. Thống kê chuyên khoa");
                System.out.println("4. Thoát");
                System.out.print("Chọn: ");

                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        service.showAll();
                        break;

                    case 2:
                        System.out.print("Nhập ID: ");
                        String id = sc.nextLine();

                        System.out.print("Nhập tên: ");
                        String name = sc.nextLine();

                        System.out.print("Nhập chuyên khoa: ");
                        String specialty = sc.nextLine();

                        Doctor d = new Doctor(id, name, specialty);
                        service.addDoctor(d);
                        System.out.println("✔ Thêm thành công!");
                        break;

                    case 3:
                        service.statistics();
                        break;

                    case 4:
                        System.out.println("Thoát chương trình!");
                        break;

                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }

            } while (choice != 4);

        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}