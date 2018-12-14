package pl.sundayprogrammer.broker.mock.service;

import pl.sundayprogrammer.broker.mock.model.User;

import java.util.List;
import java.util.UUID;

public interface MockService {

    User GetUserById(Long id);
    User GetUserByUuid(UUID id);
    User GetUserByName(String name);
    User GetUserBySocialSecurityNumber(String socialNumber);
    List<User> GetUsersByGroup(String group);
    List<User> GetUsersInCity(String city);
    boolean AddUser(User user);
    boolean UpdateUser(User user);
}
