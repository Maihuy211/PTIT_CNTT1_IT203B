package exercise02;

public class LightFactory extends DeviceFactory {
    @Override
    Device createDevice() {
        System.out.println("LightFactory: Tạo đèn");
        return new Linght();
    }
}
