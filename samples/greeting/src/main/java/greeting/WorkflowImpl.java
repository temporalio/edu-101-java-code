package greeting;

public class WorkflowImpl implements Workflow {

    @Override
    public String greetSomeone(String name) {
        return "Hello " + name + "!";
    }
}
