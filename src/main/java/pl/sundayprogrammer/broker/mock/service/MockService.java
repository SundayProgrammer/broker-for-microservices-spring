package pl.sundayprogrammer.broker.mock.service;

import pl.sundayprogrammer.broker.mock.model.User;

import java.util.List;
import java.util.UUID;

public interface MockService {

    User getUserById(Long id);
    User getUserByUuid(UUID id);
    User getUserByName(String name);
    User getUserBySocialSecurityNumber(String socialNumber);
    List<User> getUsersByGroup(String group);
    List<User> getUsersInCity(String city);
    boolean addUser(User user);
    boolean updateUser(User user);
}
