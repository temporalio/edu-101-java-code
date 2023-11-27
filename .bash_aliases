alias workspace="cd ${GITPOD_REPO_ROOT}"
alias webui="gp preview $(gp url 8080)"

# Exercise 1 aliases
alias ex1="cd ${GITPOD_REPO_ROOT}/exercises/hello-workflow/practice"
alias ex1w="mvn compile exec:java -Dexec.mainClass='helloworkflow.HelloWorkflowWorker'"
alias ex1s="cd ${GITPOD_REPO_ROOT}/exercises/hello-workflow/solution"

# Exercise 2 aliases
alias ex2="cd ${GITPOD_REPO_ROOT}/exercises/hello-web-ui/practice"
alias ex2s="cd ${GITPOD_REPO_ROOT}/exercises/hello-web-ui/solution"

# Exercise 3 aliases
alias ex3="cd ${GITPOD_REPO_ROOT}/exercises/farewell-workflow/practice"
alias ex3s="cd ${GITPOD_REPO_ROOT}/exercises/farewell-workflow/solution"

# Exercise 4 aliases
alias ex4="cd ${GITPOD_REPO_ROOT}/exercises/finale-workflow/practice"
alias ex4s="cd ${GITPOD_REPO_ROOT}/exercises/finale-workflow/solution"



export PATH="$PATH:/home/gitpod/.temporalio/bin"
echo "temporal configured! try typing temporal -v"
echo "Your workspace is located at: ${GITPOD_REPO_ROOT}"
echo "Type the command     workspace      to return to the workspace directory at any time."
