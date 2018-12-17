package pl.sundayprogrammer.broker;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.sundayprogrammer.broker.core.strategy.ByNameReasonerTest;

@RunWith(SpringRunner.class)
@Suite.SuiteClasses({
        ByNameReasonerTest.class
})
@SpringBootTest
public class BrokerForMicroservicesApplicationTests {

    @Test
    public void contextLoads() {
    }

}

