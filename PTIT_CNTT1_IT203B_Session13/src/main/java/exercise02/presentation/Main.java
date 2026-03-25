package exercise02.presentation;

import exercise02.dao.PaymentDAO;

public class Main {
    public static void main(String[] args) {
        PaymentDAO paymentDAO = new PaymentDAO();
        int patientId = 1;
        int invoiceId = 1;
        double amount = 500000;
        paymentDAO.thanhToanVienPhi(patientId, invoiceId, amount);
    }
}
