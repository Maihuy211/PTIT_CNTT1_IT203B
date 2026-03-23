package exercise02.business;

import exercise02.dao.DoctorDao;

public class DoctorBusiness {
    public static void update(int patientId, double temperature, int heartRate) {
        boolean result = DoctorDao.update(temperature, heartRate, patientId);
        if (result) {
            System.out.println("Cập nhật thành công");
        } else {
            System.out.println("Cập nhật thất bại");
        }
    }
}
