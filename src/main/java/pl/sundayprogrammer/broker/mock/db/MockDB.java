package pl.sundayprogrammer.broker.mock.db;

import org.springframework.beans.factory.annotation.Value;
import pl.sundayprogrammer.broker.mock.model.User;

import java.util.HashMap;
import java.util.Map;

public class MockDB {

    /*
        Nie wiem jaki plik stworzyć żeby wstrzyknąć wartość, więc podaje jakaś domyślną
    */
    @Value("${services.count}")
    private static Integer MOCK_DB_COUNT = 1000;
    public static Map<Long, User> db;

    /*
        Statyczny inicjalizator
     */
    static {
        db = new HashMap<>();
        User user;
        for (int i = 0; i < MOCK_DB_COUNT; i++) {
            user = new User();
            db.put(user.getId(), user);
        }

    }
}
