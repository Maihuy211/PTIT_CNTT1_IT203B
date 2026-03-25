package exercise04.business;

import exercise04.dao.RkHospitalDAO;
import exercise04.model.BenhNhan;
import exercise04.model.DichVu;

import java.util.List;

public class RkHospitaBusiness {
    public void hienThi() {
        RkHospitalDAO rkHospitalDAO = new RkHospitalDAO();
        List<BenhNhan> list = rkHospitalDAO.getAll();

        for (BenhNhan bn : list) {
            System.out.println("Bệnh nhân: " + bn.getTenBenhNhan());
            if (bn.getDsDichVu().size() == 0) {
                System.out.println("  Không có dịch vụ");
            } else {
                for (DichVu dv : bn.getDsDichVu()) {
                    System.out.println("  - " + dv.getTenDichVu());
                }
            }
        }
    }
}
