package pl.sundayprogrammer.broker.mock.service;

import org.springframework.beans.factory.annotation.Autowired;
import pl.sundayprogrammer.broker.mock.db.MockDB;
import pl.sundayprogrammer.broker.mock.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class UserService implements MockService {

    @Override
    public User getUserById(Long id) {

        for (Map.Entry<Long, User> entry : MockDB.db.entrySet()) {
            Long userId = entry.getKey();
            User user = entry.getValue();
            if (userId == id) {
                return user;
            }
        }

        return null;
    }

    @Override
    public User getUserByUuid(UUID id) {

        for (Map.Entry<Long, User> entry : MockDB.db.entrySet()) {
            User user = entry.getValue();
            if (user.getUuid() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User getUserByName(String name) {

        for (Map.Entry<Long, User> entry : MockDB.db.entrySet()) {
            User user = entry.getValue();
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User getUserBySocialSecurityNumber(String socialNumber) {

        for (Map.Entry<Long, User> entry : MockDB.db.entrySet()) {
            User user = entry.getValue();
            if (user.getSocialSecurityNumber().equals(socialNumber)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getUsersByGroup(String group) {

        ArrayList<User> users = new ArrayList<>();
        for (Map.Entry<Long, User> entry : MockDB.db.entrySet()) {
            User user = entry.getValue();
            if (user.getCategory().contains(group)) {
                users.add(user);
            }
        }
        return users;
    }

    @Override
    public List<User> getUsersInCity(String city) {

        ArrayList<User> users = new ArrayList<>();
        for (Map.Entry<Long, User> entry : MockDB.db.entrySet()) {
            User user = entry.getValue();
            if (user.getCity().equals(city)) {
                users.add(user);
            }
        }
        return users;
    }

    @Override
    public boolean addUser(User user) {

        if (!MockDB.db.containsKey(user.getId())) {
            MockDB.db.put(user.getId(), user);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        if (MockDB.db.containsKey(user.getId())) {
            MockDB.db.put(user.getId(), user);
            return true;
        }
        return false;
    }
}
