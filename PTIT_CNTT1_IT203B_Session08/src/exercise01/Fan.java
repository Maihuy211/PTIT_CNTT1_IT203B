package exercise01;

public class Fan implements Device{

    @Override
    public void turnoff() {
        System.out.println("Fan: Tắt quạt");
    }

    @Override
    public void turnon() {
        System.out.println("Fan: Bật quạt");
    }
}
