# Week 6 Shell Scripting

## What is a script?

- In computing, the term "script" refers to a file containing a list of commands or instructions that can be executed by a certain program or scripting engine without needing prior compilation. 
- Essentially, a script is a program written in a scripting language.

## What is a shell?

- The term "shell" in computing has a rich history and multiple layers of meaning. At its core, a shell provides a user environment where commands can be entered, allowing users to interact with the operating system or a program.
- That’s why we say python “shell”, because it serves as an interactive interface layer that facilitates direct communication between the user and the software.
- The shell we’re dealing with today is any command-line interpreter used in Unix-like operating systems, including [Linux](https://www.linux.org/) and [macOS](https://www.apple.com/hk/en/macos/macos-sequoia/), as well as shells available on [Windows](https://www.microsoft.com/en-us/windows "No one wants to use Windows"), like PowerShell.

## What is a shell script?

- A shell is a user environment where the user uses commands to interact with the operating system.
- A script is a list of commands that can be executed.
- When commands that can be run in a shell are strung together and executed in batch, we have a **shell script**.

### Example: A Simple Backup Script

Here's an example of a bash script that creates a backup of Word files:

```bash
#!/bin/bash -- the shebang line, which specifies the interpreter

# List word files on Desktop and save it into file
ls ~/Desktop/*.docx > ~/word_files

# Create a new directory
mkdir ~/word_files_backup

# Copy word files on Desktop into new directory
cp ~/Desktop/*.docx ~/word_files_backup

# Print complete message
echo "Backup created for all word files on Desktop!"
```

And here's the equivalent PowerShell script:

```powershell
# List word files on Desktop and save it into file
ls ~/Desktop/*.docx > ~/word_files

# Create a new directory
mkdir ~/word_files_backup

# Copy word files on Desktop into new directory
cp ~/Desktop/*.docx ~/word_files_backup

# Print complete message
echo "Backup created for all word files on Desktop!"
```

## Running a shell script

While unix-like systems reads the shebang (#!) line to determine which interpreter should be used to execute a script, Windows Powershell relies on the extension name of the file for that decision.<br>
To run a shell script in a unix shell, first make it executable
```bash
chmod +x <script_name>.sh
```
Then invoke the script path
```bash
./<script_name>.sh
```
To run a shell script in powershell, we need to change the execution policy, as powershell restricts script execution by default.
```powershell
Set-ExecutionPolicy -Scope CurrentUser RemoteSigned
```
Then invoke the script path
```powershell
.\<script_name>.ps1
```

## Shell scripts are used for:

- Automation of development tasks (build, test, deploy etc);
- Continuous integration and development (CI/CD);
- System configuration and provisioning;
- Database management;
- Process control and management;
- File manipulation and data processing;
- And more…

## Things we can do in a shell script

- Print a message;
- Define a variable;
- Use a variable;
- Get user input;
- Use conditionals;
- Use loops;
- Run another script.

## Define and use variables

Here's how to define and use variables in bash:

```bash
#!/bin/bash

echo "Hello world!"
greeting="Hello"
name="Alice"

echo "$greeting, $name!"
```

And here's the equivalent in PowerShell:

```powershell
echo "Hello world!"

$greeting = "Hello"
$name = "Alice"

echo "$greeting, $name!"
```

## Get user input

Here's how to get user input in bash:

```bash
#!/bin/bash

echo "Hello world!"
greeting="Hello"
echo "What's your name?"
read name

echo "$greeting, $name!"
```

And here's the equivalent in PowerShell:

```powershell
echo "Hello world!"

$greeting = "Hello"
$name = Read-Host -Prompt "What's your name?"

echo "$greeting, $name!"
```

## Conditionals

Here's how to use conditionals in bash:

```bash
#!/bin/bash

echo "What's your score?"
read score

if [ $score -ge 70 ]; then
    echo "You passed with distinction."
elif [ $score -ge 40 ]; then
    echo "You passed."
else
    echo "You failed."
fi
```

And here's the equivalent in PowerShell:

```powershell
$score = Read-Host -Prompt "Enter your score"

if ([int]$score -ge 70) {
    echo "You passed with distinction."
} elseif ([int]$score -ge 40) {
    echo "You passed."
} else {
    echo "You failed."
}
```

## For loops

Here's how to use for loops in bash:

```bash
# Loop through a list of names
for name in Alice Bob Charlie; do
    echo $name
done

# Loop through numbers
for i in {1..5}; do
    echo "Number $i"
done

# Loop through files
for file in *.sh; do
    echo "Processing $file..."
done
```

And here's the equivalent in PowerShell:

```powershell
# Loop through a list of names
$names = "Alice", "Bob", "Charlie"
foreach ($name in $names) {
    echo $name
}

# Loop through numbers
for ($i = 1; $i -le 5; $i++) {
    echo "Number $i"
}

# Loop through files
ls *.ps1 | foreach-object {
    echo "Processing $($_.FullName)..."
}
```

## While loops

Here's how to use while loops in bash:

```bash
#!/bin/bash

count=1
echo "Count: $count"
echo "Continue counting? [Y/N]"
read user_input
while [ $user_input = "Y" ]; do
    count=$((count + 1))
    echo "Count: $count"
    echo "Continue counting? [Y/N]"
    read user_input
done
echo "Good bye!"
```

And here's the equivalent in PowerShell:

```powershell
# While loop that counts from 1 to 5
$count = 1
echo "Count: $count"
$user_input = Read-Host -Prompt "Continue? [Y/N]"
while ($user_input -eq "Y") {
    $count++
    echo "Count: $count"
    $user_input = Read-Host -Prompt "Continue? [Y/N]"
}
echo "Good bye!"
```

### Running another script

Here's how to run another script in bash:

```bash
#!/bin/bash

./unix/conditional.sh

script_name="variables.sh"
./unix/$script_name
```

And here's the equivalent in PowerShell:

```powershell
./powershell/conditional.ps1

$script_name = "variables.ps1"
& "./powershell/$script_name"
```

### Other things we can do in a shell script

- Define a function
- Call a function
- Accept parameters
- Run other programs
- Redirect input and output
- Access environment variables

## Define and call a function

Here's how to define and call functions in bash:

```bash
#!/bin/bash

# Function definition
greet() {
    echo "Hello, $1!"
}

# Call the function with an argument
greet "Alice"

# Function that outputs a value
calculate() {
    echo $(( $1 + $2 ))
}

# Capturing the output of the function
result=$(calculate 5 3)
echo "The result is: $result"
```

And here's the equivalent in PowerShell:

```powershell
# Function definition
function Greet {
    param (
        [string]$Name
    )
    echo "Hello, $Name!"
}

# Call the function with an argument
Greet -Name "Alice"

function Add-Numbers {
    param (
        [int]$Number1,
        [int]$Number2
    )
    return $Number1 + $Number2
}

$result = Add-Numbers -Number1 5 -Number2 3
echo "The result is: $result"
```

## Accept parameters

Here's how to accept parameters in bash:

```bash
#!/bin/bash

script_name=$0
name=$1
hobby=$2
param_count=$#

echo "Running $script_name"
echo "with $param_count parameters!"
echo "$name likes $hobby!"
```

And here's the equivalent in PowerShell:

```powershell
param (
    [string]$name,
    [string]$hobby
)

echo "$name likes $hobby!"
```

# The PATH

- The PATH environment variable is a critical system variable that lists *directories where the operating system looks for executable files*.
- When a command is entered in the shell, the directories in the PATH variable are searched in the order they are listed. Once the executable is found, the search stops, and the system attempts to execute the found file.

## Adding Java to the PATH

For Windows Powershell:
```powershell
$env:PATH += ";<Java_installation_path>"
```
For Unix shell:
```bash
export PATH=$PATH:<Java_installation_path>
```

## Output redirection

Let’s start by saving the printed message to a file:
```bash
java ./Hello.java > out.txt
```
You should see the message “Hello world!” if you open out.txt.

To open a file with the default application, use <br>
`start <file_path> `<br>
in Windows Powershell, and <br>
`open <file_path>`<br>
in a Unix shell.<br>

- Output redirection allows the standard output (stdout) and/or standard error (stderr) streams of a command or program to be directed to a location other than the terminal or console. 
- This can be a file, another command (via piping), or even ignored (discarded).
- In output redirection, `>` overwrites the existing content and `>>` appends after the existing content.

### output redirection is used for:

- Logging and debugging
    - Developers often redirect stderr to a separate file to isolate error messages from regular program output.
- Data processing pipelines
    - Output from one command or program can be redirected to serve as input to another, forming a pipeline that processes data in stages.
- Continuous integration and deployment(CI/CD)
    - In CI/CD pipelines, output from build processes, tests, or deployment scripts can be redirected to files or tools that monitor and analyze the process.
- Testing and quality assurance
    - Output redirection can be used to capture the output of tests and compare it against expected outcomes or to generate reports.

Many applications keeps a running log when in execution. During development, developers look at the log in real time to get an idea of how the application is working and to debug errors.  

When the application is running on production server, it is usually redirected into a log file so that when an error is reported, the developer can look into the log file and understand what happened at the time of the error.  

## Input redirection

### Input redirection is used for:

- Data Processing Pipelines
    - When combined with output redirection and piping, the output of one program becomes the input to another, allowing for complex data transformations and analyses.
- Scripting and Automation
    - Scripts that automate system tasks or data processing can use input redirection to read from configuration files or data sources.
- Streamlining Database Operations
    - Database utilities that interact with SQL databases often allow executing SQL commands from a file, making input redirection useful for automating database backups, restores, queries, and script executions.

# Environment variables

- Environment variables are key-value pairs stored in the operating system's environment where running processes can access them. 
- They play a vital role in software development, system administration, and the daily operation of systems by providing a way to influence the behavior of software and scripts without modifying code.

## Environment variables are used for:

- Configuration
    - Allow applications to behave differently in different execution environments (development, testing, production), without changing the application's source code.
- Secret management
    - Store sensitive information, such as API keys, passwords, and other credentials, keeping them out of source code to enhance security.
- System information
    - Provide information about the system, like the current user's home directory (HOME on Unix/Linux, USERPROFILE on Windows), or the system's path variable (PATH), which dictates where the operating system looks for executable files.

Reading environment variable:<br>
Unix shell:
```bash
$<variable_name>
```
Windows Powershell:
```powershell
$env:<variable_name>
```
Setting environment variable:<br>
Unix shell:
```bash
export <variable_name>=<variable_value>
```
Windows Powershell:
```powershell
$env:<variable_name> = <variable_value>
```
In your own shell, set the environment variable “user” to your name, then print the message “The current user is <your_name>” by reading that environment variable.

> [!TIP]
> 🔗 [Practice](week-6-practices.md)

