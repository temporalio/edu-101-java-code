alias workspace="cd ${GITPOD_REPO_ROOT}"
alias webui="gp preview $(gp url 8080)"

# Exercise 1 aliases
alias ex1="cd ${GITPOD_REPO_ROOT}/exercises/hello-workflow/practice"
alias ex1w="mvn compile exec:java -Dexec.mainClass='helloworkflow.HelloWorkflowWorker'"
alias ex1s="cd ${GITPOD_REPO_ROOT}/exercises/hello-workflow/solution"

# Exercise 2 aliases
alias ex2="cd ${GITPOD_REPO_ROOT}/exercises/hello-web-ui/"


# Exercise 3 aliases
alias ex3="cd ${GITPOD_REPO_ROOT}/exercises/farewell-workflow/practice"
alias ex3s="cd ${GITPOD_REPO_ROOT}/exercises/farewell-workflow/solution"
alias ex3m="mvn exec:java -Dexec.mainClass='farewellworkflow.Microservice'"
alias ex3w="mvn exec:java -Dexec.mainClass='farewellworkflow.GreetingWorker'"
ex3st() {
    mvn exec:java -Dexec.mainClass="farewellworkflow.Starter" -Dexec.args="${1}"
}

# Exercise 4 aliases
alias ex4="cd ${GITPOD_REPO_ROOT}/exercises/finale-workflow"
alias ex4j="java -classpath java-activity-and-worker-1.1.jar io.temporal.training.PdfCertWorker"
alias ex4w="ex4 && cd go && go run go/worker/main.go"
ex4st() {
    ex4
    cd go
    go run start/main.go "${1}"
}



export PATH="$PATH:/home/gitpod/.temporalio/bin"
echo "temporal configured! try typing temporal -v"
echo "Your workspace is located at: ${GITPOD_REPO_ROOT}"
echo "Type the command     workspace      to return to the workspace directory at any time."
