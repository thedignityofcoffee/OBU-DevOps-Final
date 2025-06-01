# Week 5 Automated Testing

## Process of creating automated tests

See the lecture slides for a detailed explanation of the process of creating automated tests.

## Parts of a Test Class

- We distinguish a **test class** (which performs the tests) from a **tested class**.
- A test class is a separate class, in the testing source tree, which contains classes with particular annotated methods.
- Note that test classes do not include a main program. The main program for testing is inside the JUnit library. It runs your test classes and returns the results to your IDE.

## Why we use randomised data

- In real life, a colleague trying to cheat their way around a test is possible but not likely.
- We use randomized data for testing because:
    - Randomly generated data can cover a wider range of scenarios, including edge cases that might not be immediately obvious, thus revealing flaws that would not have been discovered through a set of predictable, hardcoded tests.
    - It's easier to generate large datasets dynamically, allowing for stress testing of the algorithm under different conditions and data volumes, while saving time and resources, allowing testers to focus on analyzing results and improving the algorithm.
    - In simple terms, using randomly generated data for testing helps us make sure things work well in different situations, saves time and effort, and lets us focus on making things even better.
<br>
- Randomized Data for Testing: When we test something, we want to make sure it works correctly in all kinds of situations. Imagine you're trying to check if a car can handle different road conditions like smooth roads, bumpy roads, or even icy roads. If we only test the car on one type of road, we might miss out on important problems it could have on other types of roads.
- Covering Different Scenarios: By using randomly generated data, we can test the car on all kinds of roads, just like testing a computer program with different types of information. This helps us find problems we might not have thought about before, like if the car has trouble turning left on a bumpy road. In the same way, randomized data can help us find issues in a computer program that we wouldn't have found if we only tested it with specific, planned-out data.
- Easier Testing with Large Datasets: Imagine if we had to manually create every single test scenario for the car, like driving it on every road in the world. That would take forever! Instead, by using random data, we can create lots of different test situations quickly and easily. This lets us see how the car performs under lots of different conditions without wasting time or resources.
- Saving Time and Resources: Because we can generate lots of different test scenarios automatically, testers can spend more time analyzing the results of the tests and figuring out how to make the car or the computer program even better. This helps us improve the car's performance or fix any problems in the program more efficiently.
- In simple terms, using randomly generated data for testing helps us make sure things work well in different situations, saves time and effort, and lets us focus on making things even better.

## Test Criteria

- Correctness: The output array must be in non-decreasing order.
- Data Integrity: The sorted array must contain the same number of each item as the original array.

## Avoiding the self-test trap

- The self-test trap refers to a situation in software testing where a test essentially checks itself, resulting in a meaningless or ineffective test. This can occur when the test's verification process is based on the same logic or assumptions used in the code being tested.
- To use a sorting algorithm while testing a sorting algorithm would be to fall into the self-test trap! If code is tested by the same code, the test is meaningless. It's like asserting that a + b == a + b.
- The self-test trap does not apply if testing using known correct results. But it can apply when doing comprehensive tests with randomized data, and these are the most valuable in automated testing.
- Therefore, we must test for the data integrity of the sorting algorithm in a different way.

## What is Helper Method?

A helper method is a small, specialized function or subroutine that is designed to assist or support the main functionality of a program or a larger function. Here's a simple explanation:

- Imagine you're building a big LEGO castle. Each brick in the castle represents a line of code or a specific task that needs to be done. Now, sometimes you need a special brick that doesn't really fit into the main castle structure, but it helps you build it better. That special brick is like a helper method in programming.
- Helper methods are like mini-tools that programmers create to make their code cleaner, easier to read, and more organized. They perform specific tasks that are needed in multiple places throughout the program. Instead of writing the same code over and over again in different parts of the program, you can create a helper method to do that task once and then call it whenever you need it.
- For example, let's say you're building a program that calculates the area of different shapes. You might have a helper method called "calculateRectangleArea" that takes the length and width of a rectangle as inputs and returns the area. Instead of writing the formula for calculating the area of a rectangle every time you need it, you can just call this helper method.
- In short, a helper method is a small, specialized function that helps with specific tasks in a program, making the code more efficient and easier to manage.

## Automated Testing
- Using programs to test other programs
- Usually performed by calling functions or components of the program under test, and then verifying properties of their results
- Can significantly speed up testing, and can enable it to be done invisibly during the development process
- Especially valuable for regression testing (testing that a change has not broken other parts of the program that were previously working) because:
    - Tests can be automatically rerun whenever a change is made
    - All parts of the software can be tested without the developer needing to think about them

## Automated Unit Testing

- Single tests focused on small components of the program – not the whole system at once
- Unit testing does not attempt to imitate the user typing or clicking on the interface – what is tested are the inputs and outputs of functions and methods
- Must be aware of potential bugs in the testing code
- Automated tests may not be able to calculate the correct answer and then compare it to the returned value, because calculating the correct answer would use the same code as the code under test! More often, tests are based on checking implicit properties of the results or checking against specific results

## Why Automated Testing is important

- Automated testing can improve development and debugging ease of any program
- It is critical to write automated tests as you go – writing a large batch all at once for a large project is not viable
- Most professional programming projects, and many open source ones, require you to submit unit tests together with any new code you contribute
- Some coding portfolio, job matching, or "code challenge" sites also require unit tests to be submitted together with the answer to the challenge

## Testing Systems

- There are several different frameworks for writing unit tests in Java.
- The one best supported by both NetBeans and IntelliJ is called JUnit.

## When self-test is unavoidable

- The unavoidable self-test issue can often come up when writing tests for methods that solve complex problems.
- Optimization methods (ie, methods to calculate "the best" solution to a problem) often have this problem.
- A test can easily check that the solution is workable, but it is very hard to check there is no better solution.
    - (If you had a way of checking if there was a better solution, you would probably be using that in the solving method.)
- We can fall back to comparing against specific known correct results when self-test is unavoidable.
<br>
So, when you're stuck in this situation where you can't really test for the best solution, you can fall back on comparing your solution to specific examples where you know what the best solution should be. This way, even though you can't always be sure you've found the absolute best solution, you can at least check if your method is giving you the right answers for known cases.
## Q & A

**What is automated testing?**
Automated testing is the use of software tools and scripts to execute pre-scripted tests on a software application, comparing actual outcomes to predicted outcomes.

**Why is automated testing important?**
Automated testing helps improve software quality, reduce time to market, increase test coverage, and identify bugs earlier in the development process.

**What framework do we use to test Java code?**
In Java, popular testing frameworks include JUnit and TestNG for unit testing, and frameworks like Selenium for automated functional testing.

**What are the steps involved in creating automated tests for a Java class?**
The steps typically involve setting up the test environment, writing test cases, executing tests, analyzing results, and iterating as needed.

**Where do we put the testing code?**
Testing code is usually placed in separate files or directories from the main application code, often in a directory named "test" or "tests."

**What special methods do we have for automated testing?**
Automated testing often involves special methods called assertions, which are used to verify that certain conditions hold true during testing.

**What's different between testing a static method and testing a dynamic method?**
Testing a static method involves calling the method directly, while testing a dynamic method usually involves creating an instance of the class containing the method and then calling it.

**Is it better to write tests in batch, or incrementally?**
Incremental testing, where tests are written as code is developed, is generally considered better as it helps catch issues early and integrates testing into the development process.

**What is a self-test trap? How do we avoid it?**
The self-test trap occurs when a test essentially checks itself, which is meaningless. To avoid it, tests should compare results against known expected outcomes rather than testing against themselves.

**Can we write an automated test for a private method?**
While it's technically possible to test private methods using reflection or other techniques, it's generally recommended to focus on testing the public interface of a class, as private methods are implementation details that may change frequently.

**What could be the cause of a test failing?**
Tests can fail due to changes in the code being tested, environmental factors, timing issues, data dependencies, or errors in the test code itself.

## Unpredictable results
Sometimes the output of a method is unpredictable.

This can occur because:
- There is a random factor in the method.
- The method reads some external data that is beyond your control, like network traffic, or a temperature, etc.

In this case, it is again necessary to think about the specified properties of the classes and method and test these.

## Simplifying testing methods

There are several methods that **Junit** provides to simplify code in testing methods. 

If a method is marked with the decoration @Before, it runs before every test (once per test). Likewise, @After.  

This can set up data for testing. For example, if every test of our IntTombola required an IntTombola with random ints loaded, we could place the code to set this up in the @Before method.  

If you initialize variables in the setup method that you want to be visible in test methods, you must make them instance variables of the test class (since local variables of the setup method would be out of scope)  

## Testing input and output

Automated testing is not as valuable for methods that provide user input and output, but it can be done. However it does require some Java techniques you have not learned yet.  

You can create input and output streams that read from a string instead of from the keyboard. You can then use System.setOut() and System.setIn() to make your print statements and scanners read from these streams instead.  

However, a test method cannot enter an ongoing dialog with a tested method because it can only run when the tested method is not running.  

For example, if the tested input method loops until a valid value is entered, the test method does not get to resume until that loop is completely over. So it cannot read the error messages and then respond to them.  

You can potentially buffer up a queue of invalid inputs to check that the appropriate number of error messages is produced. But if the error messages are unpredictable and require different responses, this will not work.  

To test this you require a testing thread which is much more complicated.

## Writing automated tests

- Start by testing simple properties
- Identify more complex properties
- Identify how they can be tested without self-testing
- Identify if any of these tests can or must be combined
- Write testing methods based on the appropriate tests and combinations
- Remember, automated testing does not have to be perfect – it is relatively easy for it to be better than manual testing
