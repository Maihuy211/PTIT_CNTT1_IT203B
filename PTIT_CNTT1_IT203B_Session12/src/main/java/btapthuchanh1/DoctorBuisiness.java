package btapthuchanh1;

import java.util.List;
import java.util.Scanner;

public class DoctorBuisiness {
    public static void findDoctorBySpecialty(Scanner sc){
        System.out.println("Nhập chuyên khoa muốn tìm: ");
        String specialty = sc.nextLine();
        List<Doctors> list = DoctorDao.findDoctorBySpecialty(specialty);
        if(list.isEmpty()){
            System.out.println("ko tìm thấy");
        }else{
            System.out.println("Danh sách bác sĩ tìm thấy");
            list.forEach(Doctors::toString);
        }
    }
    public static void updatePassword(Scanner sc){
        System.out.println("Nhập id bác sĩ muốn sủa thông tin");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Nhập mật khẩu mới");
        String newPassword = sc.nextLine();

        boolean rs = DoctorDao.updatePassword(id,newPassword);
        if(rs){
            System.out.println("Cập nhật thành công");
        }else {
            System.out.println("Cập nhật thất bại");
        }
    }

    public static void calculateDutyFee(Scanner sc){
        System.out.println("Nhập vào id bác sĩ muốn tính phí: ");
        int id = sc.nextInt();
        sc.nextLine();


    }
}
