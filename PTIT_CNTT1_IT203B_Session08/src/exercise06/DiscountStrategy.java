package exercise06;

public interface DiscountStrategy {
    double calculateDiscount(double amount);
    String getDescription();
}
