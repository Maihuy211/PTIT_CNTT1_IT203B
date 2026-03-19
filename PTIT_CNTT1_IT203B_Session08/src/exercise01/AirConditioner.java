package exercise01;

public class AirConditioner implements Device{
    @Override
    public void turnoff() {
        System.out.println("AirConditioner: Tắt máy lạnh");
    }

    @Override
    public void turnon() {
        System.out.println("AirConditioner: Bật máy lạnh");
    }
}
