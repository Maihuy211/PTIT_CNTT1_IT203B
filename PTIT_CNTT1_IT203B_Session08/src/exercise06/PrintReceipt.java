package exercise06;

public class PrintReceipt implements NotificationService {
    @Override
    public void notifyCustomer(String message) {
        System.out.println("In hóa đơn: " + message);
    }
}
