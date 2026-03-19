import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ProductDatabase db = ProductDatabase.getInstance();
    public static void main(String[] args){
        int choice = 0;
        do {
            System.out.println("---------------------- QUẢN LÝ SẢN PHẨM ----------------------");
            System.out.println("1. Thêm mới sản phẩm");
            System.out.println("2. Xem danh sách sản phẩm");
            System.out.println("3. Cập nhật thông tin sản phẩm");
            System.out.println("4. Xoá sản phẩm");
            System.out.println("5. Thoát");
            System.out.println("-----------------------------------------------------------------------");
            System.out.print("Lựa chọn của bạn: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    addProduct();
                    break;
                case 2:
                    db.showProduct();
                    break;
                case 3:
                    updateProduct();
                    break;
                case 4:
                    deleteProduct();
                    break;
                case 5:
                    System.out.println("Thoát chương trình");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }while (choice != 5);
    }
    public static void addProduct() {
        System.out.print("Nhập ID: ");
        String id = sc.nextLine();

        System.out.print("Nhập tên: ");
        String name = sc.nextLine();

        System.out.print("Nhập giá: ");
        double price = sc.nextDouble();

        System.out.print("Loại (1: Physical, 2: Digital): ");
        int type = sc.nextInt();

        Product p = ProductFactory.createProduct(type, id, name, price);
        db.addProduct(p);
    }

    public static void updateProduct() {
        System.out.print("Nhập ID: ");
        String id = sc.nextLine();

        System.out.print("Tên mới: ");
        String name = sc.nextLine();

        System.out.print("Giá mới: ");
        double price = sc.nextDouble();

        db.updateProduct(id, name, price);
    }

    public static void deleteProduct() {
        System.out.print("Nhập ID: ");
        String id = sc.nextLine();
        db.deleteProduct(id);
    }
}
