package helloworkflow;

import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;

public class HelloWorkflowWorker {
    
    public static void main(String[] args) {

        WorkflowServiceStubs service = WorkflowServiceStubs.newLocalServiceStubs();
        WorkflowClient client = WorkflowClient.newInstance(service);
        WorkerFactory factory = WorkerFactory.newInstance(client);

        // TODO: modify the statement below to specify the task queue name
        Worker worker = factory.newWorker("TODO");

        worker.registerWorkflowImplementationTypes(HelloWorkflowWorkflowImpl.class);

        factory.start();

    }
}
