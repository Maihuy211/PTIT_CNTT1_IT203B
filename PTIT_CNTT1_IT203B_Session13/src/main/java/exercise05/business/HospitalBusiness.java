package exercise05.business;

import exercise05.dao.HospitalDAO;

import java.util.List;

public class HospitalBusiness {
    public void hienThiGiuong() {
        HospitalDAO dao = new HospitalDAO();
        List<String> list = dao.getBeds();

        for (String s : list) {
            System.out.println(s);
        }
    }

    public void tiepNhan(String name, int age, int bedId, double money) {
        HospitalDAO dao = new HospitalDAO();

        if (dao.tiepNhan(name, age, bedId, money)) {
            System.out.println("Tiếp nhận thành công");
        } else {
            System.out.println("Tiếp nhận thất bại");
        }
    }
}
