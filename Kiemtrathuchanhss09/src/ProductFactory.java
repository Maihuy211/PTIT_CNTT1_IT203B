public class ProductFactory {
    public static Product createProduct(int type, String id, String name, double price) {
        switch (type) {
            case 1:
                return new PhysicalProduct(id, name, price);
            case 2:
                return new DigitalProduct(id, name, price);
            default:
                System.out.println("Sản phẩm ko hợp lệ");
        }
        return null;
    }
}
