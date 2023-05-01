
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface PolyglotWorkflow {

    @WorkflowMethod
    String pythonActivity(String name);
}