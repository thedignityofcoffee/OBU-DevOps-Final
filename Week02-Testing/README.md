# Week 2 Testing

**Software is error-prone because**

- Software developers are human (maybe not for much longer :p), and humans make mistakes.
- When software gets more complex, the likelihood of error increases.
- Software undergoes frequent changes during its lifecycle, which can lead to inconsistencies and conflicts.
- Software running in the real world is subject to a diverse range of input, some of which may not have been anticipated by the developer and may disrupt software behaviour.

**Syntax Errors**
- The simplest kind of error: when a command is not a legal command or statement in the programming language.
- However, because of the way programming languages are parsed, errors are not always reported at the point they occur.
- When searching for syntax errors, check where the computer tells you the problem is; but if you don’t find the error there, track back through the previous lines.

**Run time and specification testing**

- We also need to test for:
    - *Run Time errors* – where the error can only be detected when the program runs.
    - *Specification/Semantic errors* – where the program does not crash or halt but does not do the right thing.
- Only basic programs with no input (which are really only written when learning) can be tested just by running them once.
- If a program has input, even for a very simple program, it would be impossible to test all possible input values.
- Run-time and specification errors may only appear *when certain values are entered, and not all the time*.

## Types of Testing

### Black Box Testing
> focus on testing its functionality based on input and expected output rather then internal code.

- Treats the program as a ‘black box’ that cannot be seen into
    - The actual lines of code are not considered.
    - The testing takes no account of how the program does what it does.
- The purpose of the testing is to check that the behaviour of the program matches:
    - the outcomes of the algorithm, and/or
    - the requirements specification.
- We can determine what to test before the program is written.
- A set of “test cases” is developed that will cover every different scenario (not every possible set of inputs).
- Test data is then produced and used to carry out the tests.

#### Testing Procedures

- Create test **cases**
- Create test **data**
- Carry out testing and obtain test **results**

##### Step 1 : Create test cases

- These are human statements of particular circumstances in which the program/algorithm will need to run
- Must check that all necessary cases are covered

Test Cases

- We need to be sure that we are testing every type of situation the software will face.
- In creating a set of test cases, we attempt to put together a comprehensive set of different situations and say what is to be tested.
- In black box testing, we look at the program specification and use this to allow us to work out the test cases.

Determining Test Cases:

---

Specification

- Develop a program that will ask the user for information about two events in the form of four integers, as whole hours: start of event A, duration of event A, start of event B, duration of event B. You may assume that the events occur entirely within one calendar day.
- The program will then determine whether the timing of these events overlaps and report it to the user.

Test Cases
- the two events overlap and A starts earlier than B
- the two events overlap and B starts earlier than A
- the two events do not overlap and A starts earlier than B
- the two events do not overlap and B starts earlier than A
- A ends at the same time that B starts
- B ends at the same time that A starts

---

Fuzz testing

- Fuzz testing is testing attempts to deliberately crash the program, at varying levels of aggression.
- When learning, fuzz testing is not necessary, and writing software to withstand it can be very hard. But it is worth being aware of it because it is critically important in secure systems such as websites.

Test Cases
- Start time or end time is bigger than 23
- Start time or duration is a negative integer
- Start time or duration is a float
- Start time or duration is a non-numerical string, like “cow”
- Headbutt the keyboard

---

##### Step 2 : Create test data

> - These are specific inputs or conditions used to test the program and make sure it behaves as expected. 
> - You need to check that all tests are actually performed and none are missed or made too easy by mistake.

From test cases to test data

- Once we have a set of test cases, we can then determine data to try out the test case.
- We draw up a table to show what we expect to happen and what actually happens so that we can see if the behaviour is correct. The next slide shows this.
- We can then run the program and test it. When there are errors, stepping though the program and watching variables is a very good way of determining what is going wrong.

Testing table

| Test Case | Input Data      | Expected Output | Actual Output |
|-----------|-----------------|-----------------|---------------|
| 1         | 8, 4, 11, 2     | True            |               |
| 2         | 16, 3, 13, 4    | True            |               |
| 3         | 7, 4, 11, 2     | False           |               |
| ...       |                 |                 |               |
| 10        | cat, dog, one, two | Error message   |               |

##### Step 3 : Carry out testing and obtain test results

- Run the program test data and note the results
- Analyze the results and check they are what is expected; if not, attempt to identify the error
- This process can be performed on the algorithm before implementation by working it through by hand - although this is slower it avoids wasting time implementing a doomed algorithm

> [!WARNING]
> Be careful not to create test cases that accidentally allow the program to pass without actually working correctly.

For example, consider the following set of test data:
- 8, 4, 11, 2 => True
- 16, 3, 13, 4 => True
- 7, 4, 11, 2 => False
- 17, 3, 13, 4 => False
- 9, 4, 13, 1 => False
- 15, 5, 12, 3 => False

How confident are we that the program is behaving correctly, if all the test inputs yield expected results?
> For example, if we test a program with a set of inputs and always get the expected results, it might seem like the program is correct. However, if the test cases are too similar or don’t cover all possible scenarios, the program might still have hidden bugs.

### White Box Testing

- White Box testing is testing based on a programs internal code and infrastructure.
- It is called white box or clear box as the tester inspects the actual code, unlike in black box testing.
- As the tester knows the actual code, the testing can be tailored *to ensuring that the lines of code are correct*; unlike black box testing which only worries about matching the specification.

White box testing can be used to test for the following:
- Security holes
- Broken or poorly structured paths in the code
- Correct flow of inputs through the code
- Expected output
- Correct functionality in conditional loops
- Correctness of each statement

There are two steps involved in this:
- Understand the source code.
    - Unlike black box testing, **knowledge of the code is required** to carry out white box testing effectively.
- Create test cases and execute.
    - By looking at the code, the tester can determine what needs to be tested and provide tests for it.
    - Each part of the code will be looked at and used to inform test cases.
    - **Code coverage** determines how well the code has been covered by the testing.

#### Code Coverage Criteria

Here are some of the common coverage criteria that can be used:
- Statement Coverage
    - Have the set of tests together caused every part of the program/algorithm to run or take effect?

- Decision Coverage
    - Have the set of tests together caused every decision the program/algorithm makes to be decided in every possibly way?

- Condition Coverage
    - Similar to decision coverage but refers to decisions that are stored as well as immediately acted on.

- Parameter Value Coverage
    - If a sub-program takes inputs, have all common values for such inputs been considered?

### Combination Testing

- You should usually use both black box and white box testing on each program.
- Black box testing alone can fail to test all parts of the code.
- White box testing alone can fail to allow for all aspects of the specification, become “lost” in the code’s structure, or miss faults caused by errors in the algorithm rather than the implementation.

### More Types of Testing

Whichever method of testing we use, there are also different contexts in which programs are tested.
- Unit Testing
- Integration Testing
- System Testing
- Regression Testing

#### Unit Testing

- In unit testing we think of our program as being composed of units and test each one individually
- Some larger programs might be naturally divided into parts, but this is not essential
- The key point is that we test small parts of the overall program
- If the unit does not itself take input from the user or produce output, we can create a “test harness” that takes input, passes it to the unit, and prints the result – this enables us to control testing and quickly see the results

#### Integration Testing

- Once we have unit tested each part, we can combine them and ensure that **they run together**.
- This is integration testing.
- Unit testing is useful as we develop.
- Integration testing comes towards **the end of the software development process**.

#### System Testing

- Testing **the whole system** at once.
- Usually necessary for parts of the specification that refer to the whole system or for properties that apply to the whole system, such as performance and security.
- Much harder to do than unit testing. The whole system is likely to contain large numbers of interactions and input possibilities, thus unit and integration testing is used first to try to eliminate as many potential problems as possible.

#### Regression Testing

- Regression testing means **retesting a software after making changes** to make sure everything still works as expected.
- Usually a special case of unit and integration testing.
- The difference is that regular testing checks that the new patch or feature works in itself; regression testing tests everything else to make sure it hasn’t been broken.
- The kind of test where automated testing can help the most.

#### User Acceptance Testing

- Not all forms of testing are purely technical.
- We may want to test our software by **asking users to interact with it**.
- This is often done for testing non-technical properties such as user friendliness, or subjective ones such as performance.
- Usually has to be done with care as it can be expensive and take time to involve users. 

For example, asking the user to enter a new value if they entered an invalid one is not considered user friendly on modern systems.

The user might also want to:
- Stop the program completely
- Change their answer to a previous question
- Get more explanation about the range

At this stage you do not need to worry about this. You will learn to create more modern user interfaces later. User Acceptance Testing would detect this kind of issue.

#### Automated Testing

- Some development systems allow us to set up tests that run automatically.
- When we tell the program to run tests it automatically runs a series of tests and reports the results.

## Validation and Source Inspection

### Testing and Validation

- Finding mistakes in the software before it is released, checking if the software meets user needs and does what it was supposed to do. 
- When defining an algorithm we usually limit the range of values to which it applies.
- In an implementation or requirements specification we may have to decide what the program should do if an invalid value is input.
- Invalid data can be either
  - Of the right type but outside of the applicable range (eg, `a_start_time = 25`)
        - This may produce a result but it will be incorrect or nonsensical. It may crash the program unless caught
  - Of the wrong type (eg, `a_start_time = “Felix the cat”`)
        - This is very likely to crash the program unless caught and any results will be meaningless.

Usually if invalid data is input by the user we should give the user a warning and move on.

If the invalid data is supplied by another programmer (because we are writing code to put in a library) then there are several choices:
- Return some kind of signal value that their program could detect (but we need to choose a suitable value and they need to know how to allow for it)
- Controlled crash (this warns the other programmer that they are using the library wrong and puts the onus on them to add validation if it’s appropriate)
- Return an arbitrary value (this usually only applies in performance critical code where checking the validity of the input would take substantial time, or where the function may be called multiple times on the same values meaning that checking them over and over is a waste of time)

#### Source Inspection

- Source code inspection is not technically a form of testing, but it can prevent problems in the same way.
- Having someone else, or an automated system, examine the source code for potential errors or suspicious sections.
- Most IDEs now perform some source inspection automatically while the program is being typed. This can detect things like:
    - Variables not being initialized;
    - If conditions or loops that can never actually run;
    - Etc.

#### Source Inspection: Code Smell

- A code smell occurs when the structure of a piece of source code is not wrong, but is a bad idea, and its necessity indicates that there may be design issues in the code as a whole that should be fixed.
- Typical code smells you might encounter at this level:
    - Cutting and pasting code at all (should it be a function?) or to create similar structures with different functionality (use options or higher order?)
    - Functions with too many parameters (if the parameters are always needed together, should they be merged into a data structure?)
    - Excessive type casting

#### Source Inspection: Antipatterns

- Antipatterns are more definite than code smells; commonly used, but wrong, solutions to problems, usually due to programmer inexperience; but not all antipatterns are technical – some are caused by management or external forces.
- For example, the following code shows a common beginner antipattern:
```python
for (int x=0; x<3; x++) {
  if (x==0) System.out.println("Hello!");
  if (x==1) System.out.println("I am Bob!");
  if (x==2) System.out.println("Bye!");
}
```

An antipattern is a bad practice in coding or management that can cause problems in software development.
Common Beginner Mistakes (Coding Antipatterns):
- Forgetting Important Steps – If a function only works correctly when you manually set up things before or after calling it, it’s easy to forget and cause errors.     
   - Example: A function that calculates tax but only works if you set a global variable first.
- Overloading a Class – Putting too many methods or properties in a single class makes the code hard to manage and understand.
   - Example: A "User" class that handles login, payments, emails, and reporting instead of just managing user data.

Common Management Mistakes (Management Antipatterns)\

1. Thinking "Neat Code" Means "Easy Work" – Just because a developer writes well-structured, clean code, some managers assume they should have finished the task much faster.
   - Reality: Clean code takes time and skill, but it helps avoid future problems.
2. Making Software Too Flexible – Some managers demand too much flexibility, making the software overcomplicated and inefficient. This is called an "inner platform" problem.

> [!NOTE]
> Keywords:<br>
> syntax error<br>
> runtime error<br>
> semantic/specification error<br>
> black box testing<br>
> white box testing<br>
> unit testing<br>
> integration testing<br>
> regression testing<br>
> user acceptance testing<br>
> automated testing<br>
> Test data<br>
> code coverage<br>
> validation<br>

> [!TIP]
> 🔗 [Practice](week-2-practical-solution.md)

