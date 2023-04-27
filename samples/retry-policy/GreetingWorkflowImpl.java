package greetingworkflow;

// This example illustrates how to use a retry policy in a Workflow.
// Since the code change is entirely within the Workflow Implementation, only that
// file is provided here.
import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;
import io.temporal.common.RetryOptions;

import java.time.Duration;

public class GreetingWorkflowImpl implements GreetingWorkflow {

    ActivityOptions options = ActivityOptions.newBuilder()
            .setStartToCloseTimeout(Duration.ofSeconds(5))
            .setRetryOptions(
                    RetryOptions.newBuilder()
                            .setInitialInterval(Duration.ofSeconds(15))
                            .setBackoffCoefficient(2.0)
                            .setMaximumInterval(Duration.ofSeconds(60))
                            .setMaximumAttempts(100)
                            .build())
            .build();

    private final GreetingActivities activities = Workflow.newActivityStub(GreetingActivities.class, options);

    @Override
    public String greetSomeone(String name) {
        String spanishGreeting = activities.greetInSpanish(name);
        String spanishFarewell = activities.farewellInSpanish(name);

        return "\n" + spanishGreeting + "\n" + spanishFarewell;
    }
}
