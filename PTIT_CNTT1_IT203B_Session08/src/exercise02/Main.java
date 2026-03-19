package exercise02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HardwareConnection hardwareConnection = null;
        List<Device> devices = new ArrayList<>();
        int choice;
        do{
            System.out.println("\n===== MENU =====");
            System.out.println("1. Kết nối phần cứng");
            System.out.println("2. Tạo thiết bị");
            System.out.println("3. Bật thiết bị");
            System.out.println("4. Tắt thiết bị");
            System.out.println("5. Thoát");
            System.out.print("\nNhập lựa chọn: ");
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                choice = 0;
            }
            switch (choice){
                case 1:
                    hardwareConnection = HardwareConnection.getInstance();
                    hardwareConnection.connect();
                    break;
                case 2:
                    System.out.println("1.Quat");
                    System.out.println("2.Den");
                    System.out.println("3.May Lanh");
                    System.out.println("4.thoat");
                    DeviceFactory factory = null;
                    try {
                        choice = Integer.parseInt(sc.nextLine());
                    } catch (Exception e) {
                        choice = 0;
                    }
                    switch (choice) {
                        case 1:
                            factory = new LightFactory();
                            break;
                        case 2:
                            factory = new FanFactory();
                            break;
                        case 3:
                            factory = new AirConditionerFactory();
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Không hợp lệ!");
                            continue;
                    }
                    Device device=factory.createDevice();
                    devices.add(device);
                    break;
                case 3:
                    System.out.println("moi ban chon thiet bi bat :");
                    for (int i=0;i<devices.size();i++){
                        System.out.println((i+1)+"device"+(i+1));
                    }
                    try {
                        choice = Integer.parseInt(sc.nextLine());
                    } catch (Exception e) {
                        choice = 0;
                    }
                    if (choice>0 && choice<=devices.size()){
                        devices.get(choice-1).turnon();
                    }else{
                        System.out.println("Không hợp lệ!");
                    }
                    break;
                case 4:
                    System.out.println("moi ban chon thiet bi bat :");
                    for (int i=0;i<devices.size();i++){
                        System.out.println((i+1)+"device"+(i+1));
                    }
                    try {
                        choice = Integer.parseInt(sc.nextLine());
                    } catch (Exception e) {
                        choice = 0;
                    }
                    if (choice>0 && choice<=devices.size()){
                        devices.get(choice-1).turnoff();
                    }else{
                        System.out.println("Không hợp lệ!");
                    }
                    break;
                default:
                    break;
            }
        }while(choice!=0);
    }
}