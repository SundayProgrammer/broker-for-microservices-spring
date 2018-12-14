package pl.sundayprogrammer.broker.mock.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.joda.time.format.DateTimeFormat;

import javax.persistence.Entity;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
public class User {

    private static Long GENERATOR = 0L;

    private Long id;
    private UUID uuid;
    private String name;
    private String surname;
    private String city;
    private String socialSecurityNumber;
    private String password;
    private Date birthday;
    private List<String> category;

    public User() {

        id = GENERATOR++;
        uuid = UUID.randomUUID();
        name = RandomStringUtils.randomAlphabetic(6, 14);
        surname = RandomStringUtils.randomAlphabetic(6, 14);
        socialSecurityNumber = RandomStringUtils.randomNumeric(10);
        city = RandomStringUtils.randomNumeric(5);
        birthday = DateTimeFormat.forPattern("yyyy-MM-dd").parseDateTime("2016-01-01").plusDays(RandomUtils.nextInt(0, 3000)).toDate();
        password = RandomStringUtils.randomAscii(4);
        if (RandomUtils.nextDouble(0, 1) < 0.1) {
            category.add("worker");
        }
        if (RandomUtils.nextDouble(0, 1) < 0.01) {
            category.add("admin");
        }
        category.add("group_" + RandomStringUtils.randomNumeric(1));
    }
}
