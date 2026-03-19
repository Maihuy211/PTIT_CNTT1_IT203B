package exercise05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Light light = new Light();
        Fan fan = new Fan();
        AirConditioner airConditioner = new AirConditioner();
        TemperatureSensor sensor = new TemperatureSensor();

        sensor.attach(fan);
        sensor.attach(airConditioner);

        SleepModeCommand sleepModeCommand = new SleepModeCommand();
        sleepModeCommand.addCommand(new TurnOffLightCommand(light));
        sleepModeCommand.addCommand(new SetACTemperatureCommand(airConditioner, 28));
        sleepModeCommand.addCommand(new SetFanLowCommand(fan));

        while (true) {
            System.out.println("\n===== SMART HOME - SLEEP MODE =====");
            System.out.println("1. Kích hoạt chế độ ngủ");
            System.out.println("2. Thay đổi nhiệt độ phòng");
            System.out.println("3. Xem trạng thái thiết bị");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Vui lòng nhập số hợp lệ.");
                continue;
            }

            switch (choice) {
                case 1:
                    sleepModeCommand.execute();
                    break;

                case 2:
                    System.out.print("Nhập nhiệt độ phòng mới: ");
                    try {
                        int newTemp = Integer.parseInt(scanner.nextLine());
                        sensor.setTemperature(newTemp);
                    } catch (Exception e) {
                        System.out.println("Nhiệt độ không hợp lệ.");
                    }
                    break;

                case 3:
                    System.out.println("----- TRẠNG THÁI THIẾT BỊ -----");
                    System.out.println("Đèn: " + light.getStatus());
                    System.out.println("Điều hòa: " + airConditioner.getStatus());
                    System.out.println("Quạt: " + fan.getStatus());
                    break;

                case 0:
                    System.out.println("Thoát chương trình.");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}