# Exercise 3: Greeting & Farewell Workflow

During this exercise, you will create an Activity interface, an Activity class that
implements the interface, register it with the Worker, and modify a Workflow to execute it.

Before continuing, kill any Worker instances still running from any
previous exercises (you can do this by pressing Ctrl-C in the terminals
where they are running).

As with other exercises, you should make your changes in the `practice`
directory. Look for "TODO" comments, which will provide hints about what
you'll need to change. If you get stuck and need additional hints, or
if you want to check your work, look at the completed example in the
`solution` directory.

## GitPod Environment Shortcuts

If you are executing the exercises in the provided GitPod environment, you
can take advantage of certain aliases to aid in navigation and execution of
the code.

| Command           | Action                                                                                                                                                |
| :---------------- | :---------------------------------------------------------------------------------------------------------------------------------------------------- |
| `ex3`             | Change to Exercise 3 Practice Directory                                                                                                               |
| `ex3s`            | Change to Exercise 3 Solution Directory                                                                                                               |
| `ex3m`            | Execute the Exercise 3 Microservice. Must be within the appropriate directory for this to succeed. (either `practice` or `solution`)                  |
| `ex3w`            | Execute the Exercise 3 Worker. Must be within the appropriate directory for this to succeed. (either `practice` or `solution`)                        |
| `ex3st YOUR_NAME` | Execute the Exercise 3 Starter, passing in your name. Must be within the appropriate directory for this to succeed. (either `practice` or `solution`) |

## Part A: Write an Activity Function

The `GreetingActivities.java` file defines an interface with the Activity method signatures.
The `GreetingActivitiesImpl.java` implements the Activity methods and any other utility methods.
`GreetingActivitiesImpl.java` contains a function (`GreetInSpanish`) that uses a
microservice to get a customized greeting in Spanish. This file also contains a utility method
(`callService`) that the Activity uses to call the microservice.

1. Open the `GreetingActivities.java` file (located in the `practice/src/main/java/farewellworkflow` subdirectory) in the editor.
2. Define a new Activity method signature (using any valid name you like) that will get a custom farewell message from the microservice.
   1. Save your changes to the file
3. Open the `GreetingActivitiesImpl.java` file (located in the `practice/src/main/java/farewellworkflow` subdirectory) in the editor.
4. Create a new Activity that will get a custom farewell message from the microservice.
   1. Copy the `greetInSpanish` method
   2. Rename the new method using the name that matches the new method signature you defined in `GreetingActivities.java`.
   3. Change `get-spanish-greeting` in this new method to `get-spanish-farewell`
   4. Save your changes to this file

## Part B: Register the Activity Methods

1. Open the `GreetingWorker.java` file (located in the `practice/src/main/java/greetingworker` subdirectory) in the editor
2. Modify the line below the `//TODO:` comment to register your new Activities with the Worker (hint: you'll create a new object of the Activity Implementation).
3. Save your changes to this file

## Part C: Modify the Workflow to Execute Your New Activity

1. Open the `GreetingWorkflowImpl.java` file (located in the `practice/src/main/java/greetingworker` subdirectory) in the editor
2. Look for the TODO message, uncomment the line below it, and then change that line
   to execute the Activity function you created
3. Save your changes to this file

## Part D: Start the Microservice and Run the Workflow

All commands below must be run from the `practice` subdirectory. Ensure your temporal cluster is running
before executing the following commands:

1. Compile the code using the command `mvn clean compile`
2. Start the microservice by running `mvn exec:java -Dexec.mainClass="farewellworkflow.Microservice"` in a terminal
   1. **Note:** If you're using GitPod, you can run the shortcut `ex3m`
3. In another terminal, start your Worker by running `mvn exec:java -Dexec.mainClass="farewellworkflow.GreetingWorker"`
   1. **Note:** If you're using GitPod, you can run the shortcut `ex3w`
4. In a third terminal, execute your Workflow by running `mvn exec:java -Dexec.mainClass="farewellworkflow.Starter" -Dexec.args="Mason"`
   (replacing `Mason` with your own name)
   1. **Note:** If you're using GitPod, you can run the shortcut `ex3st Mason` (replacing `Mason` with your own name)

If there is time remaining, experiment with Activity failures and retries
by stopping the microservice (press Ctrl-C in its terminal) and re-running
the Workflow. Look at the Web UI to see the status of the Workflow and its
Activities. After a few seconds, restart the microservice by running the
same command used to start it earlier. You should find that the Workflow
will now complete successfully following the next Activity retry.
