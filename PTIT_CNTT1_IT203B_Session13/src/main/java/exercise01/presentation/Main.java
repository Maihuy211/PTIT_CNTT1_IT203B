package exercise01.presentation;

import exercise01.dao.MedicineDAO;

public class Main {
    public static void main(String[] args) {
        MedicineDAO medicineDAO = new MedicineDAO();
        int medicineId = 1;
        int patientId = 1;
        medicineDAO.capPhatThuoc(medicineId,patientId);
    }
}
