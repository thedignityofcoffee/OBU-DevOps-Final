# Week 3 Debugging

> Many parts of this lecture is for practice in class, here just lists out the important notes.

## Compile time error

- syntax error
- type error
- runtime error

## State

- In the context of programming, the concept of "state" or "environment" refers to the current condition or configuration of a system, program, or specific components within it. It includes all relevant data, variables, and settings that determine the behavior and output of the program at a particular moment in time.
- The state is everything that affects how a program command runs, other than the command itself
- The state of a program includes the values of every variable that is shared between parts of the program
- The state of a function may also include the values of local variables for that function
- In more complicated programs it may also include the contents of files on disk, the current other activities of the computer or of plugged‐in devices, or of other programs

## State and Bugs

- A bug is generally caused by one of two things:
    - A wrong command
    - A correct command running in the wrong state
- Wrong commands are relatively easy to find and fix
- Wrong states are much harder to fix as the state can be changed by any previous part of the program
- A general rule in programming is: **keep the state as simple as possible, to keep debugging as simple as possible**
- Ways to achieve this are:
    - Make variable scopes as small as possible (ie, use local variables when you can)
    - Avoid broken transparency (in Java any class can have state, but if a method’s purpose doesn’t include changing the object, make sure it doesn’t – or make sure its effects are identical in all circumstances to not changing it)

## Tracing - Make the debugging process faster

- Run To Cursor → Runs the program until it reaches the line where your cursor is.
    - This helps skip parts of the code you don’t need to check.
    - Useful when debugging large programs or loops instead of stepping through each line.
    - After stopping, you can check the variable values to see if they are correct.
        - If values are correct, the bug is probably somewhere else in the code.
        - If values are wrong, the bug is likely in that section, so you can debug it further.
- Resume Program → Continues running the program from where it stopped until it hits another breakpoint.
    - This helps when you want to skip ahead to the next important stop in your debugging process.

### `Assert` Statement

- Assertions are used in programming to enforce certain conditions or assumptions that should always be true at specific points in the code. They are statements that assert the correctness of certain conditions, and if the condition evaluates to false during program execution, an assertion error is thrown.
- A very helpful command for debugging is assert.
- The assert command inputs a condition (in the same way that “if” does) and halts the program if the condition is not true.
- If running in debug mode, instead of halting the program, it invokes the debugger in the same way that a breakpoint does. Because a failed assertion is not really a critical error, you can continue to execute the program.
- The main use of assert is to detect incorrect states early to prevent them causing problems with other parts of the program.
- Asserts can also be used to make it obvious to you, when you are debugging the program, what assumptions your program are making about the state.

### Using Assertions

- **Debugging Aid**: Assertions help in debugging by allowing developers to identify and locate logical errors and inconsistencies in the code quickly. When an assertion fails, it provides valuable information about the state of the program at that point, making it easier to diagnose and fix issues.
- **Documentation***: Assertions serve as documentation within the code, providing clear and explicit statements about the expected behavior or assumptions at specific points. This helps other developers understand the code and its requirements better.
- **Design by Contract**: Assertions support the concept of Design by Contract, where preconditions, postconditions, and invariants are specified for functions and methods. By using assertions to enforce these contracts, developers can ensure that the code behaves correctly under all circumstances.
- **Testing and Validation**: Assertions are valuable during testing and validation phases of software development. They help in identifying unexpected or invalid states of the program during testing, ensuring that the program functions as intended.
- **Performance Monitoring**: Assertions can be used to monitor and verify performance-related assumptions in the code. For example, assertions can check if certain operations are within expected time bounds or if certain resources are within expected limits.
- **Error Detection in Production**: Although assertions are typically disabled in production environments for performance reasons, they can still be enabled selectively to detect unexpected conditions or errors that may occur in production. This can help in diagnosing and resolving issues in real-world scenarios.

> [!TIP]
> 🔗 [Practice](week-3-practical_4.md)

