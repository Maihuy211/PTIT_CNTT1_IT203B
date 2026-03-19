package exercise06;

public class EmailNotification implements NotificationService {
    @Override
    public void notifyCustomer(String message) {
        System.out.println("Gửi email: " + message);
    }
}