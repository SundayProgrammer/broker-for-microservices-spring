package pl.sundayprogrammer.broker.core;

import pl.sundayprogrammer.broker.mock.service.MockService;

import java.lang.reflect.Method;
import java.util.List;

public interface ReasoningStrategy {

    Method reason(MockService service, List<String> features);
}
