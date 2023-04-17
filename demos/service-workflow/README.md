# Service Workflow Demo
This demo shows an Activity that invokes a translation microservice, accessible via HTTP, to provide a Spanish greeting for the specified name.

Before continuing, kill all Worker instances still running from previous exercises.

### Build the workflow
Before you can execute the workflow you need to compile it by running the following command in a terminal window:

```
mvn compile
```

### Run the Workflow
Since this Workflow depends on the translation microservice, start that 
first by running this command in a terminal window:

```
$ mvn exec:java -Dexec.mainClass="greetingworkflow.Microservice"
```

Next, use a separate terminal window to start the Worker:

```
$ mvn exec:java -Dexec.mainClass="greetingworkflow.GreetingWorker"
```

Finally, use another terminal window to start the Workflow,
using the supplied code, specifying your name as input.

```
$ mvn exec:java -Dexec.mainClass="greetingworkflow.Starter" -Dexec.args="Mason"
```

#### This is the end of the demo
