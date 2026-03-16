package gioi2;

import java.util.List;

public interface OrderRepository {
    void save(String orderId);
    List<String> findAll();

}