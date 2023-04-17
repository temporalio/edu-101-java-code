package finale;

import io.temporal.workflow.ActivityStub;
import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.ExternalWorkflowStub;
import io.temporal.workflow.Workflow;

import java.time.Duration;


public class CertificateGeneratorWorkflowImpl implements CertificateGeneratorWorkflow{

    ActivityOptions options =
        ActivityOptions.newBuilder()
                .setStartToCloseTimeout(Duration.ofSeconds(10))
                .setTaskQueue("generate-certificate-taskqueue")
                .build();

    private final ActivityStub externalActivity = Workflow.newUntypedActivityStub(options);

    @Override
    public String createPdf(String name) {
        
        String result = externalActivity.execute("CreatePdf", String.class, name);

        return result;
    }
    

}
