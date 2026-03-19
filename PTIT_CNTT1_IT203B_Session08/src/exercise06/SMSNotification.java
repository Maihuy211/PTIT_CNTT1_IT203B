package exercise06;

public class SMSNotification implements NotificationService {
    @Override
    public void notifyCustomer(String message) {
        System.out.println("Gửi SMS: " + message);
    }
}
