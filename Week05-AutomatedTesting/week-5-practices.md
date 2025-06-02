# CHC4010 DevOps Week 5 Practical: Automated Testing
## Part I. Find the biggest number in the array
1. In the `exercise1` folder, find the file `Max.java` and copy the file into the `src` folder of your project. Read, execute, and understand the code.
2. Follow the steps demonstrated in the lecture and create an automated test for the `max()` method using the testing library `JUnit5`. You should **NOT** use the same logic in the test as the tested method itself. Don’t fall into the self-test trap!
## Part II. A student database implemented with array
1. Open the `exercise2` folder and copy the file inside `src` into the `src` folder of your project. Copy the file inside `test` into the test folder of your project (you should have already created a test folder for the previous exercise!).
2. Run `StudentDBTest.java` and you will see that some tests are failing. This is due to a bug in `getStudents()` method. Fix `getStudents()` method in `StudentDB.java` so that the test for `getStudents()` passed. (It’s okay that other tests might still be failing at this point.)
3. Read the documentation of `addStudent()` and create an automated test for this method. Before writing the test code, make list of the functional properties we should test for.
4. Implement `removeStudent()` in a way that would pass the `removeStudent()` test.
5. In its initial state, `findStudent()` uses linear search to find a certain student in the database. Since `students` are kept sorted in alphabetical order, we can use binary search to improve efficiency. Adapt the `binarySearch()` method given in `StudentDB.java` and use it to find a student in the database.
  
After this change, run the all the tests again. Did your change break any existing feature? Do we need to update the tests for any of the public methods? Why or why not?

> [!TIP]
> 🔗 [Practice codes](Week%205%20Practices)  
> 🔗 [Solution codes](Week%205%20Practices%20-%20solution)

