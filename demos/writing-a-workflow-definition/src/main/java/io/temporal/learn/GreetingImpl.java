package io.temporal.learn;

public class GreetingImpl implements Greeting {

    @Override
    public String greetSomeone(String name) {
        return "Hello " + name + "!";
    }
}
