package farewellworkflow;

import io.temporal.activity.ActivityInterface;

@ActivityInterface
public interface GreetingActivities {

    String greetInSpanish(String name);

    String farewellInSpanish(String name);

}
