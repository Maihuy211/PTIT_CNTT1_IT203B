package baiktrthuchanh;

import java.util.ArrayList;
import java.util.Optional;

public class ProductService {

    private ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        boolean check = products.stream()
                .anyMatch(product -> product.getId() == p.getId());
        if (check) {
            throw new InvalidProductException("ID sản phẩm đã tồn tại!");
        }
        products.add(p);
    }
    public void showProducts() {
        if (products.isEmpty()) {
            System.out.println("Danh sách trống");
            return;
        }
        products.forEach(System.out::println);
    }
    public void updateQuantity(int id, int quantity) {
        Optional<Product> optionalProduct =
                products.stream()
                        .filter(p -> p.getId() == id)
                        .findFirst();

        Product product = optionalProduct.orElseThrow(
                () -> new InvalidProductException("Không tìm thấy sản phẩm!")
        );
        product.setQuantity(quantity);
    }
    public void deleteOutOfStock() {
        products.removeIf(p -> p.getQuantity() == 0);
    }
}