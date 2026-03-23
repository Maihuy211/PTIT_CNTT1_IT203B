package exercise06;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        AppointmentRepository repo = new AppointmentRepository();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Them lich kham");
            System.out.println("2. Cap nhat lich kham");
            System.out.println("3. Xoa lich kham");
            System.out.println("4. Tim theo ID");
            System.out.println("5. Hien thi tat ca");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");

            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    // Thêm
                    System.out.print("Nhap ten benh nhan: ");
                    String name = sc.nextLine();

                    System.out.print("Nhap ngay (yyyy-mm-dd): ");
                    String dateStr = sc.nextLine();

                    System.out.print("Nhap ten bac si: ");
                    String doctor = sc.nextLine();

                    System.out.print("Nhap trang thai: ");
                    String status = sc.nextLine();

                    Appointment ap = new Appointment(
                            name,
                            Date.valueOf(dateStr),
                            doctor,
                            status
                    );
                    repo.addAppointment(ap);
                    break;

                case 2:
                    // Update
                    System.out.print("Nhap ID can sua: ");
                    int idUpdate = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nhap ten moi: ");
                    String newName = sc.nextLine();

                    System.out.print("Nhap ngay moi (yyyy-mm-dd): ");
                    String newDate = sc.nextLine();

                    System.out.print("Nhap bac si moi: ");
                    String newDoctor = sc.nextLine();

                    System.out.print("Nhap trang thai moi: ");
                    String newStatus = sc.nextLine();

                    Appointment updateAp = new Appointment(
                            idUpdate,
                            newName,
                            Date.valueOf(newDate),
                            newDoctor,
                            newStatus
                    );
                    repo.updateAppointment(updateAp);
                    break;

                case 3:
                    // Delete
                    System.out.print("Nhap ID can xoa: ");
                    int idDelete = sc.nextInt();
                    repo.deleteAppointment(idDelete);
                    break;

                case 4:
                    // Get by ID
                    System.out.print("Nhap ID can tim: ");
                    int idFind = sc.nextInt();

                    Appointment found = repo.getAppointmentById(idFind);
                    if (found != null) {
                        System.out.println("Tim thay:");
                        System.out.println(found.getId() + " | " +
                                found.getPatientName() + " | " +
                                found.getAppointmentDate() + " | " +
                                found.getDoctorName() + " | " +
                                found.getStatus());
                    } else {
                        System.out.println("Khong tim thay!");
                    }
                    break;

                case 5:
                    // Get all
                    List<Appointment> list = repo.getAllAppointments();
                    for (Appointment a : list) {
                        System.out.println(a.getId() + " | " +
                                a.getPatientName() + " | " +
                                a.getAppointmentDate() + " | " +
                                a.getDoctorName() + " | " +
                                a.getStatus());
                    }
                    break;

                case 0:
                    System.out.println("Thoat chuong trinh!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while (choice != 0);

        sc.close();
    }
}