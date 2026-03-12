package baiktrthuchanh;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static ProductService productService = new ProductService();

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("========= PRODUCT MANAGEMENT SYSTEM =========");
            System.out.println("1. Thêm sản phẩm mới");
            System.out.println("2. Hiển thị danh sách sản phẩm");
            System.out.println("3. Cập nhật số lượng theo ID");
            System.out.println("4. Xóa sản phẩm hết hàng");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addProduct();
                    break;

                case 2:
                    productService.showProducts();
                    break;

                case 3:
                    updateProduct();
                    break;

                case 4:
                    productService.deleteOutOfStock();
                    System.out.println("Đã xóa sản phẩm hết hàng!");
                    break;

                case 5:
                    System.out.println("Thoát chương trình");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (choice != 5);
    }

    // ADD
    public static void addProduct() {

        try {

            System.out.print("Nhập ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Nhập Name: ");
            String name = sc.nextLine();

            System.out.print("Nhập Quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();

            System.out.print("Nhập Category: ");
            String category = sc.nextLine();

            Product product = new Product(id, name, quantity, category);

            productService.addProduct(product);

            System.out.println("Thêm sản phẩm thành công!");

        } catch (InvalidProductException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateProduct() {
        try {
            System.out.print("Nhập ID: ");
            int id = sc.nextInt();
            System.out.print("Nhập quantity mới: ");
            int quantity = sc.nextInt();
            productService.updateQuantity(id, quantity);
            System.out.println("Cập nhật thành công!");
        } catch (InvalidProductException e) {
            System.out.println(e.getMessage());
        }
    }
}