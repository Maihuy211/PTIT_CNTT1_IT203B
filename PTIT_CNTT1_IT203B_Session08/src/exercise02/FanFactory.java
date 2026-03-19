package exercise02;

public class FanFactory extends DeviceFactory {
    @Override
    Device createDevice() {
        System.out.println("FanFactory: Tạo quạt");
        return new Fan();
    }
}
