package workflowdefinition;

public class Starter {

    public static void main(String[] args) {
        Greeting greeting = new GreetingImpl();
        String greetingMsg = greeting.greetSomeone(args[0]);
        System.out.println(greetingMsg);
    }
}
