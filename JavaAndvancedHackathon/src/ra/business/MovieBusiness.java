package ra.business;

import ra.entity.Moive;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


public class MovieBusiness {
    private static MovieBusiness instance;
    private List<Moive> moives = new ArrayList<>();

    public static MovieBusiness getInstance(){
        if(instance == null){
            instance = new MovieBusiness();
        }
        return instance;
    }

    public boolean isDuplicate(String id){
        return moives.stream().anyMatch(m -> m.getMovieId().equals(id));
    }

    public void displayMovie(){
        if(moives.isEmpty()){
            System.out.println("Danh sách trống");
            return;
        }

        moives.forEach(Moive::displayData);
    }

    public void addMovies(Scanner sc){
        Moive m = new Moive();
        m.inputData(sc);
        if(isDuplicate(m.getMovieId())){
            System.out.println("Mã phim đã tồn tại");
        }else{
            moives.add(m);
        }
    }

    public void updateMovie(String id, Scanner sc){
        Optional<Moive> optional = moives.stream().filter(x -> x.getMovieId().equals(id)).findFirst();
        if (!optional.isPresent()){
            System.out.println("Không tìm thấy!");
            return;
        }
        Moive m = optional.get();

        int choice;
        do {
            System.out.println("1. Sửa Movie Name");
            System.out.println("2. Sửa Duration");
            System.out.println("3. Sửa Views");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    System.out.print("Movie Name mới: ");
                    m.setMovieName(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Duration mới: ");
                    m.setDuration(sc.nextInt());
                    sc.nextLine();
                    break;
                case 3:
                    System.out.print("Views mới: ");
                    m.setViews(sc.nextInt());
                    sc.nextLine();
                    break;
                case 0:
                    System.out.println("Thoát");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (choice != 0);
    }

    public void deleteMovie(String name){
        if (moives.isEmpty()) {
            System.out.println("Trống");
            return;
        }
        boolean removed = moives.removeIf(m -> m.getMovieName().equalsIgnoreCase(name));
        if (removed){
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Không tìm thấy phim");
        }
    }

    public void findMovie(String name){
        List<Moive> list = moives.stream().filter(m -> m.getMovieName().toLowerCase().contains(name.toLowerCase())).toList();
        if (list.isEmpty()){
            System.out.println("Trống");
        }else{
            list.forEach(Moive::displayData);
        }
    }

    public void filterMovie(){
        List<Moive> list = moives.stream().filter(m -> m.getViews() >= 10000).toList();
        if (list.isEmpty()){
            System.out.println("Không tìm thấy phim");
        }else{
            list.forEach(Moive::displayData);
        }
    }
    public void sortMovie(){
        moives.sort((a,b) -> b.getViews() - a.getViews());
        moives.forEach(Moive::displayData);
    }
}