package exercise05.business;

import exercise05.dao.PatientDAO;
import exercise05.model.Patients;

import java.util.List;
import java.util.Scanner;

public class PatientBusiness {
    public static void displayPatients(Scanner sc){
        List<Patients> list = PatientDAO.getPatients();

        if(list.isEmpty()){
            System.out.println("Không có bệnh nhân");
        }else{
            System.out.println("Danh sách bệnh nhân:");
            list.forEach(System.out::println);
        }
    }

    public static void addPatients(Scanner sc){
        Patients patient = new Patients();

        System.out.println("Nhập tên:");
        patient.setName(sc.nextLine());

        System.out.println("Nhập tuổi:");
        patient.setAge(Integer.parseInt(sc.nextLine()));

        System.out.println("Nhập khoa:");
        patient.setDepartment(sc.nextLine());

        System.out.println("Nhập bệnh:");
        patient.setDisease(sc.nextLine());

        boolean rs = PatientDAO.addPatients(patient);

        if(rs){
            System.out.println("Thêm thành công");
        }else{
            System.out.println("Thêm thất bại");
        }
    }

    public static void updatePatients(Scanner sc){
        System.out.println("Nhập id bệnh nhân:");
        int id = Integer.parseInt(sc.nextLine());

        System.out.println("Nhập bệnh mới:");
        String disease = sc.nextLine();

        boolean rs = PatientDAO.updatePatients(id, disease);

        if(rs){
            System.out.println("Cập nhật thành công");
        }else{
            System.out.println("Cập nhật thất bại");
        }
    }

    public static void calculatePatientsFee(Scanner sc){
        System.out.println("Nhập id bệnh nhân:");
        int id = Integer.parseInt(sc.nextLine());

        double fee = PatientDAO.calculatePatientsFee(id);

        if(fee > 0){
            System.out.println("Viện phí: " + fee);
        }else{
            System.out.println("Không tính được phí");
        }
    }

}
