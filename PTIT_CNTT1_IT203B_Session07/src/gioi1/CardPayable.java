package gioi1;

public interface CardPayable extends PaymentMethod {
    void processCreditCard(double amount);
}