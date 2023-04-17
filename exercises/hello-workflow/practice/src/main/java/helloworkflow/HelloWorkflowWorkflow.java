package helloworkflow;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface HelloWorkflowWorkflow {
    
    @WorkflowMethod
    String greetSomeone(String name);
}
