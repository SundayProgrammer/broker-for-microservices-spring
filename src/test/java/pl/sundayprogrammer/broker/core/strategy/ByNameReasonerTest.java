package pl.sundayprogrammer.broker.core.strategy;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import pl.sundayprogrammer.broker.mock.model.User;
import pl.sundayprogrammer.broker.mock.service.MockService;
import pl.sundayprogrammer.broker.mock.service.UserService;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class ByNameReasonerTest {

    @Value("${services.count}")
    private static Integer MOCK_DB_COUNT;

    private void userById(MockService service, Method reasonedMethod) throws InvocationTargetException, IllegalAccessException {

        for (Long i = 0L; i < MOCK_DB_COUNT; ++i) {

            User originalUser = service.getUserById(i);
            List<String> args = Arrays.asList(i.toString());
            User reasonedUser = (User) reasonedMethod.invoke(service, args);

            if (originalUser != reasonedUser) {
                Assert.fail("userById - doesn't work");
            }

        }
    }

    @Test
    public void byNameReasoner() {

        UserService service = new UserService();
        List<String> args = Arrays.asList("1");

        try {
            userById(service, new ByNameReasoner("getUserById").reason(service, args));
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}