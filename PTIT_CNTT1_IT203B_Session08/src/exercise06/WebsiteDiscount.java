package exercise06;

public class WebsiteDiscount implements DiscountStrategy {
    @Override
    public double calculateDiscount(double amount) {
        return amount * 0.10;
    }

    @Override
    public String getDescription() {
        return "giảm giá 10%";
    }
}
