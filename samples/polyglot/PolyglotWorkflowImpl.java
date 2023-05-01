import io.temporal.workflow.ActivityStub;
import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.ExternalWorkflowStub;
import io.temporal.workflow.Workflow;

import java.time.Duration;


public class PolyglotWorkflowImpl implements PolyglotWorkflow{

    ActivityOptions options =
        ActivityOptions.newBuilder()
                .setStartToCloseTimeout(Duration.ofSeconds(10))
                .setTaskQueue("polyglot-taskqueue")
                .build();

    private final ActivityStub externalActivity = Workflow.newUntypedActivityStub(options);

    @Override
    public String pythonActivity(String name) {

        String result = externalActivity.execute("PythonHelloWorld", String.class, name);

        return result;
    }


}