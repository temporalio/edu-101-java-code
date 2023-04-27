package greeting;

public class Starter {

    public static void main(String[] args) {
        Workflow workflow = new WorkflowImpl();
        String greeting = workflow.greetSomeone(args[0]);
        System.out.println(greeting);
    }
}
