package helloworkflow;

public class HelloWorkflowWorkflowImpl implements HelloWorkflowWorkflow {
    
    @Override
    public String greetSomeone(String name){
        return "Hello " + name + "!";
    }
}
