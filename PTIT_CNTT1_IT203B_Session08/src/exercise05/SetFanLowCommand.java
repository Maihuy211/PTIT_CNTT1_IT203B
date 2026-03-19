package exercise05;

public class SetFanLowCommand implements Command {
    private final Fan fan;

    public SetFanLowCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        System.out.println("SleepMode: Quạt tốc độ thấp");
        fan.setLowSpeed();
    }
}