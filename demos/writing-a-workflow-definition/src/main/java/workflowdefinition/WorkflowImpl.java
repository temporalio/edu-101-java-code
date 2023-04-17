package workflowdefinition;


public class WorkflowImpl implements Workflow
{
    public String greetSomeone(String name){
        return "Hello " + name + "!";
    }
}
