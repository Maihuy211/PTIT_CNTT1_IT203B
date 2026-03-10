import java.util.ArrayList;
import java.util.List;

public class Bai2 {
    record User(String username, String email, String status) {}
    public static void main(String[] args) {
        List<Bai1.User> users = new ArrayList<>();
        users.add(new Bai1.User("alice", "alice@gmail.com", "ACTIVE"));
        users.add(new Bai1.User("bob", "bob@gmail.com", "INACTIVE"));
        users.add(new Bai1.User("charlie", "charlie@gmail.com", "ACTIVE"));

        users.stream()
                .filter(user -> user.email().endsWith("@gmail.com"))
                .forEach(user -> System.out.println(user.username()));
    }
}
