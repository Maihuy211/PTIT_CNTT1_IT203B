package bai4;

import java.io.IOException;

public class Main {
    public static void saveToFile() throws IOException {
        throw new IOException("Lỗi: ghi dữ liệu vào file");
    }
    public static void processUserData() throws IOException {
        System.out.println("Đang sử lí dữ liệu..");
        saveToFile();
    }

    public static void main(String[] args) {
        try{
            processUserData();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
