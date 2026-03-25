package exercise03.presentation;

import exercise03.dao.HospitalDAO;

public class Main {
    public static void main(String[] args) {
        HospitalDAO dao = new HospitalDAO();
        int maBenhNhan = 1;
        double tienVienPhi = 500000;
        dao.xuatVienVaThanhToan(maBenhNhan, tienVienPhi);
    }
}
