# Greeting Example
This example shows a basic Java Interface and Implementation with a method named `greetSomeone`, included in a Java package named `greeting`.
It takes a string, representing a person's name, as input. It returns a greeting that includes
this name as output.

The example also includes a file `Starter` that will invoke this method, using a name
supplied as a command-line argument. For example, you may run this program by passing the name
"Donna" to the program:

```
$ mvn exec:java -Dexec.mainClass="greeting.Starter" -Dexec.args="Mason"
```

This will output the greeting:

```
Hello Mason!
```

Although this example is not a Temporal Workflow, you will use this code
to create a Temporal Workflow during the first exercise in this course.
