package ra.presentation;

import ra.business.MovieBusiness;

import java.util.Scanner;

public class MovieManagement {
    static Scanner sc = new Scanner(System.in);
    static MovieBusiness movieBusiness = MovieBusiness.getInstance();
    public static void main(String[] args) {
        int choice = 0;
        do {
            System.out.println("*****************QUẢN LÍ DANH MỤC PHIM*****************");
            System.out.println("1. Hiển thị danh sách toàn bộ phim");
            System.out.println("2. Thêm mới phim");
            System.out.println("3. Cập nhật thông tin phim theo mã phim");
            System.out.println("4. Xoá phim theo tên");
            System.out.println("5. Tìm kiếm phim theo tên");
            System.out.println("6. Lọc danh sách phim thịnh hành(Lượt xem >= 10000)");
            System.out.println("7. Sắp xếp danh sách phim giảm dần theo lượt xem");
            System.out.println("8. Thoát");
            System.out.println();
            System.out.println("Lựa chọn của bạn: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    showMovie();
                    break;
                case 2:
                    addMovie();
                    break;
                case 3:
                    updateMovie();
                    break;
                case 4:
                    deleteMovie();
                    break;
                case 5:
                    findMovie();
                    break;
                case 6:
                    filterMovie();
                    break;
                case 7:
                    sortMovie();
                    break;
                case 8:
                    System.out.println("Thoát chương trình");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }while (choice != 8);
    }
    public static void showMovie(){
        try {
            movieBusiness.displayMovie();
        } catch (Exception e){
            System.out.println("Lỗi hiển thị");
        }
    }
    public static void addMovie(){
        try {
            String choice;
            do {
                movieBusiness.addMovies(sc);
                System.out.print("Thêm tiếp (y/n): ");
                choice = sc.nextLine();
            } while (choice.equalsIgnoreCase("y"));
        } catch (Exception e){
            System.out.println("Lỗi thêm phim");
        }
    }

    public static void updateMovie(){
        try {
            System.out.print("Nhập ID: ");
            String id = sc.nextLine();
            movieBusiness.updateMovie(id, sc);
        } catch (Exception e){
            System.out.println("Lỗi cập nhật");
        }
    }

    public static void deleteMovie(){
        try {
            System.out.print("Nhập tên: ");
            String name = sc.nextLine();
            movieBusiness.deleteMovie(name);
        } catch (Exception e){
            System.out.println("Lỗi xóa");
        }
    }

    public static void findMovie(){
        try {
            System.out.print("Nhập tên: ");
            String name = sc.nextLine();
            movieBusiness.findMovie(name);
        } catch (Exception e){
            System.out.println("Lỗi tìm kiếm");
        }
    }

    public static void filterMovie(){
        try {
            movieBusiness.filterMovie();
        } catch (Exception e){
            System.out.println("Lỗi lọc");
        }
    }

    public static void sortMovie(){
        try {
            movieBusiness.sortMovie();
        } catch (Exception e){
            System.out.println("Lỗi sắp xếp");
        }
    }
}
