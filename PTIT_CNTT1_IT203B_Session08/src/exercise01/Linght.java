package exercise01;

public class Linght implements Device{

    @Override
    public void turnoff() {
        System.out.println("Linght: Tắt đèn");
    }

    @Override
    public void turnon() {
        System.out.println("Linght: Bật đèn");
    }
}
