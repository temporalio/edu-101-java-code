package finale;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.client.WorkflowStub;
import io.temporal.serviceclient.WorkflowServiceStubs;

public class Starter {
    public static void main(String[] args) throws Exception {

        WorkflowServiceStubs service = WorkflowServiceStubs.newLocalServiceStubs();

        WorkflowClient client = WorkflowClient.newInstance(service);        

        WorkflowOptions options = WorkflowOptions.newBuilder()
                    .setWorkflowId("generate-certificate-workflow")
                    .setTaskQueue("generate-certificate-taskqueue")
                    .build();
       
        CertificateGeneratorWorkflow workflow = client.newWorkflowStub(CertificateGeneratorWorkflow.class, options);

        System.out.println("Calling workflow with " + args[0]);
        String greeting = workflow.createPdf(args[0]);

        String workflowId = WorkflowStub.fromTyped(workflow).getExecution().getWorkflowId();

        System.out.println(workflowId + " " + greeting);
        System.exit(0);
    }
}
