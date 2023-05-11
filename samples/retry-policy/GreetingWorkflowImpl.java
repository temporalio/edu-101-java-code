package greetingworkflow;

// This example illustrates how to use a retry policy in a Workflow.
// Since the code change is entirely within the Workflow Implementation, only that
// file is provided here.
import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;
import io.temporal.common.RetryOptions;

import java.time.Duration;

public class GreetingWorkflowImpl implements GreetingWorkflow {

    RetryOptions retryOptions = RetryOptions.newBuilder()
        .setInitialInterval(Duration.ofSeconds(15))   // first retry will occur after 15 seconds
        .setBackoffCoefficient(2.0)                   // double the delay after each retry
        .setMaximumInterval(Duration.ofSeconds(60))   // up to a maximum delay of 60 seconds
        .setMaximumAttempts(100)                      // fail the Activity after 100 attempts
        .build()

    ActivityOptions options = ActivityOptions.newBuilder()
            .setStartToCloseTimeout(Duration.ofSeconds(5))
            .setRetryOptions(retryOptions)
            .build();

    private final GreetingActivities activities = Workflow.newActivityStub(GreetingActivities.class, options);

    @Override
    public String greetSomeone(String name) {
        String spanishGreeting = activities.greetInSpanish(name);
        String spanishFarewell = activities.farewellInSpanish(name);

        return "\n" + spanishGreeting + "\n" + spanishFarewell;
    }
}
