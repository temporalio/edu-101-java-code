package finale;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface CertificateGeneratorWorkflow {

    @WorkflowMethod
    String createPdf(String name);
}
