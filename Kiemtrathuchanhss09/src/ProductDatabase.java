import java.util.ArrayList;
import java.util.List;

public class ProductDatabase {
    private static ProductDatabase instance;
    private List<Product> products;

    private ProductDatabase() {
        products = new ArrayList<>();
    }

    public static ProductDatabase getInstance() {
        if (instance == null) {
            instance = new ProductDatabase();
        }
        return instance;
    }

    public void addProduct(Product p) {
        products.add(p);
        System.out.println("Thêm thành công!");
    }

    public void showProduct() {
        if (products.isEmpty()) {
            System.out.println("Danh sách trống!");
            return;
        }
        for (Product p : products) {
            p.displayInfo();
        }
    }

    public void updateProduct(String id, String newName, double newPrice) {
        for (Product p : products) {
            if (p.getId().equals(id)) {
                p.setName(newName);
                p.setPrice(newPrice);
                System.out.println("Cập nhật thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm!");
    }

    public void deleteProduct(String id) {
        for (Product p : products) {
            if (p.getId().equals(id)) {
                products.remove(p);
                System.out.println("Xoá thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm!");
    }
}