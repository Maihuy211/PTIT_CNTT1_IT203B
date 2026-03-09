package bai6;

public class Main {
    public static void main(String[] args) {
        UserProcessor processor = UserUtils::convertToUpperCase;
        User user = new User("huy");
        String result = processor.process(user);
        System.out.println(result);
    }
}
