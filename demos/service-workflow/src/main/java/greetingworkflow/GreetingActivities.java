package greetingworkflow;

import io.temporal.activity.ActivityInterface;

@ActivityInterface
public interface GreetingActivities {

    String greetInSpanish(String name);

}
