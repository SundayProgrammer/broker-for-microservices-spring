package pl.sundayprogrammer.broker.core.strategy;

import lombok.Getter;
import lombok.Setter;
import pl.sundayprogrammer.broker.core.ReasoningStrategy;
import pl.sundayprogrammer.broker.mock.service.MockService;

import java.lang.reflect.Method;
import java.util.List;

@Getter
@Setter
public class ByNameReasoner implements ReasoningStrategy {

    private String methodName;

    public ByNameReasoner(String methodName) {
        this.methodName = methodName;
    }

    @Override
    public Method reason(MockService service, List<String> features) {

        for (Method method: service.getClass().getDeclaredMethods()) {

            if (method.getName().equals(methodName) &&
                    method.getParameterCount() == Integer.parseInt(features.get(0))) {
                return method;
            }
        }

        return null;
    }
}
