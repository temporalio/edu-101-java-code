# Exercise 4: Finale Workflow

One of the benefits of Temporal is that it provides SDKs for several
languages and you can use multiple languages in the context of a single
Workflow. For example, you might write your Workflow in Go but use
Java or TypeScript for an Activity in that workflow.

The last exercise in this workshop does exactly that. The Workflow
itself is written in Go, but the Activity that is executed as part
of this Workflow is written in Java, as is the Worker that runs it.
Since the Activity is written in Java, it's able to use a Java graphics
library that would otherwise be would be incompatible with a typical
Go program. Since the Workflow and Activities are implemented in two
different languages, you'll need to start two Worker programs, one
written in Java that will execute the Activity code and one written
in Go that will execute the Workflow code.

## GitPod Environment Shortcuts

If you are executing the exercises in the provided GitPod environment, you
can take advantage of certain aliases to aid in navigation and execution.

| Command           | Action                                                                                                                                                     |
| :---------------- | :--------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `ex4`             | Change to Exercise 4 Practice Directory                                                                                                                    |
| `ex4j`            | Execute the Exercise 4 jar file Directory                                                                                                                  |
| `ex4w`            | Execute the Exercise 4 Worker.                                                                                                                             |
| `ex4st YOUR_NAME` | Execute the Exercise 4 Starter, passing in your name. If you provide a name with spaces in it, be sure to enclose it in quotation marks. Ex: "Mason Egger" |

# Run the Activity Worker (implemented in Java):

In one terminal, run the following command:

```
$ java -classpath \
    java-activity-and-worker-1.1.jar \
    io.temporal.training.PdfCertWorker
```

**Note:** If you're using GitPod, you can run the shortcut `ex4j`

# Run the Workflow Worker (implemented in Go):

In another terminal, run these commands:

```
$ cd go
$ go run worker/main.go
```

**Note:** If you're using GitPod, you can run the shortcut `ex4w`

# Start the Workflow (Go)

In another terminal, run the following commands,
but be sure to replace `Mason Egger` with your
full name.

```
$ cd go
$ go run start/main.go "Mason Egger"
```

**Note:** If you're using GitPod, you can run the shortcut `ex4st "Mason Egger"`

- Once the workflow is complete, use the explorer
  view on the left side of the exercise environment
  to locate the file created by this workflow. It
  will have a name similar to `101_certificate_sally_jiang.pdf`,
  only with your name in place of `sally_jiang`.
- Right-click its icon in the explorer view and choose
  **Download...**.
- After you've downloading it to your
  computer, open it with your preferred PDF viewer.

Thank you for participating in Temporal 101!

### This is the end of the exercise.
