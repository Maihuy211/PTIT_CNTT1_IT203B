package exercise06.business;

import exercise06.dao.HospitalDAO;

public class HospitalBusiness {

    public void xuatVien(int patientId, double amount) {
        HospitalDAO dao = new HospitalDAO();

        if (dao.xuatVien(patientId, amount)) {
            System.out.println("Xuất viện thành công");
        } else {
            System.out.println("Xuất viện thất bại");
        }
    }
}