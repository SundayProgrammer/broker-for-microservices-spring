package pl.sundayprogrammer.broker.mock.db;

import org.springframework.beans.factory.annotation.Value;
import pl.sundayprogrammer.broker.mock.model.User;

import java.util.HashMap;
import java.util.Map;

public class MockDB {

    @Value("${services.count}")
    private static Integer MOCK_DB_COUNT;
    public static Map<Long, User> db;

    private MockDB() {
        db = new HashMap<>();
        User user;
        for (int i = 0; i < MOCK_DB_COUNT; i++) {
            user = new User();
            db.put(user.getId(), user);
        }
    }

}
