# Exercise 4: Finale Workflow
One of the benefits of Temporal is that it provides SDKs for several
languages and you can use multiple languages in the context of a single
Workflow. For example, you might write your Workflow in Go but use
Java or TypeScript for an Activity in that workflow. Or you may have
an Activity implemented by one team and a Workflow that wants to make
use of that Activity by implementing it.

The last exercise in this workshop does exactly that. The Workflow
is written in Java, but the Activity that is executed as part
of this Workflow is a precompiled jar, as is the Worker that runs it.
Since the Workflow and Activities are two separate implementations, 
you'll need to start two Worker programs, one in each implementation.


# Compile the code
Before running this exercise, compile your Java code with the following
command:

```
mvn compile
```


# Run the Activity Worker (implemented in Java):
In one terminal, run the following command:

```
$ java -classpath \
    java-activity-and-worker-1.1.jar \
    io.temporal.training.PdfCertWorker
```


# Run the Workflow Worker (implemented in Go):
In another terminal, run this command:

```
$ mvn exec:java -Dexec.mainClass="finale.FinaleWorker"
```

# Start the Workflow (Go)
In another terminal, run the following command,
but be sure to replace `Mason Egger` with your
full name.

```
$ mvn exec:java -Dexec.mainClass="finale.Starter" -Dexec.args="Mason Egger"
```

* Once the workflow is complete, use the explorer
view on the left side of the exercise environment
to locate the file created by this workflow. It
will have a name similar to `101_certificate_sally_egger.pdf`,
only with your name in place of `mason_egger`.
* Right-click its icon in the explorer view and choose
**Download...**. 
* After you've downloading it to your
computer, open it with your preferred PDF viewer.

Thank you for participating in Temporal 101!

### This is the end of the exercise.
