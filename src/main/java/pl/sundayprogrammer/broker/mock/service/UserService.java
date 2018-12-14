package pl.sundayprogrammer.broker.mock.service;

import pl.sundayprogrammer.broker.mock.db.MockDB;
import pl.sundayprogrammer.broker.mock.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class UserService implements MockService {

    @Override
    public User GetUserById(Long id) {

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
    public User GetUserByUuid(UUID id) {

        for (Map.Entry<Long, User> entry : MockDB.db.entrySet()) {
            User user = entry.getValue();
            if (user.getUuid() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User GetUserByName(String name) {

        for (Map.Entry<Long, User> entry : MockDB.db.entrySet()) {
            User user = entry.getValue();
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User GetUserBySocialSecurityNumber(String socialNumber) {

        for (Map.Entry<Long, User> entry : MockDB.db.entrySet()) {
            User user = entry.getValue();
            if (user.getSocialSecurityNumber().equals(socialNumber)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> GetUsersByGroup(String group) {

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
    public List<User> GetUsersInCity(String city) {

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
    public boolean AddUser(User user) {

        if (!MockDB.db.containsKey(user.getId())) {
            MockDB.db.put(user.getId(), user);
            return true;
        }
        return false;
    }

    @Override
    public boolean UpdateUser(User user) {
        if (MockDB.db.containsKey(user.getId())) {
            MockDB.db.put(user.getId(), user);
            return true;
        }
        return false;
    }
}
