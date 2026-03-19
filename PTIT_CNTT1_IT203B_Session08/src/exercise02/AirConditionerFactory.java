package exercise02;

public class AirConditionerFactory extends DeviceFactory {
    @Override
    Device createDevice() {
        System.out.println("AirConditionerFactory: Tạo máy lạnh");
        return new AirConditioner();
    }
}
