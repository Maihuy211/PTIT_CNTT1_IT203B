package exercise06.business;

import exercise06.dao.MedicineDAO;
import exercise06.model.Medicine;

import java.util.List;
import java.util.Scanner;

public class MedicineBusiness {

    public static void updateStock(Scanner sc){
        System.out.println("Nhập ID thuốc:");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập số lượng thêm:");
        int qty = Integer.parseInt(sc.nextLine());
        boolean rs = MedicineDAO.updateMedicineStock(id, qty);
        if(rs){
            System.out.println("Cập nhật thành công");
        }else{
            System.out.println("Thất bại");
        }
    }

    public static void findByPrice(Scanner sc){
        System.out.println("Nhập giá min:");
        double min = Double.parseDouble(sc.nextLine());
        System.out.println("Nhập giá max:");
        double max = Double.parseDouble(sc.nextLine());
        List<Medicine> list = MedicineDAO.findByPrice(min, max);
        if(list.isEmpty()){
            System.out.println("Không có thuốc");
        }else{
            list.forEach(System.out::println);
        }
    }

    public static void calculateTotal(Scanner sc){
        System.out.println("Nhập ID đơn thuốc:");
        int id = Integer.parseInt(sc.nextLine());

        double total = MedicineDAO.calculateTotal(id);
        System.out.println("Tổng tiền: " + total);
    }

    public static void getRevenue(Scanner sc){
        System.out.println("Nhập ngày (yyyy-MM-dd):");
        String date = sc.nextLine();

        double revenue = MedicineDAO.getRevenue(date);
        System.out.println("Doanh thu: " + revenue);
    }
}