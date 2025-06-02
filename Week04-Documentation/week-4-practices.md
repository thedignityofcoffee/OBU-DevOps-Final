# CHC4010 DevOps Week 4 Practical: Documentation  

## Part I. Commenting Code  

1. In the `exercise1` folder, find the file `Sort.java` and copy the file into the `src` folder of your project. Read through the implementation of insertion sort. Try to understand what each line of code does and how together they complete the task of sorting an array of integers.  
2. Open `comments.txt` to find 11 pre-written comments. Based on your understanding of the code in `Sort.java`, put each comment into an appropriate place among the 11 empty lines of comments marked (1) to (11).  

## Part II. Documenting Code with JavaDoc  

1. Open the `exercise2` folder and copy three files inside `src` into the src` `folder of your project. Copy `movies.csv` into the **root folder** of your project (that is, the **parent folder** of `src`).  
2. Run `DBInterface.java` and experiment with different user input. Understand what the program does. Look at `movies.csv` and check if there are any changes.  
3. There are some methods, parameters, attributes, and local variables in `Movie` class that have weird names. Based on your understanding of the program behavior and the roles they play in realizing this behaviour, rename these methods, parameters, attributes, and local variables so that their names have meaning and make the code more readable.  
4. Add appropriate JavaDoc comments to all **public** methods of `Movie` class and `MovieDB` class. Check that your JavaDoc comments are detected by the IDE. Then compile all the JavaDoc comments in your project into a reference guide in HTML format and view them in a web browser.  
5. In `MovieDB` class, `java.util.ArrayList` is used for storing a collection of movies. Replace this datatype with `java.util.HashMap`, a datatype similar to dictionaries in Python, with the help of [JavaDoc](https://docs.oracle.com/en/java/javase/20/docs/api/java.base/java/util/HashMap.html), and make necessary changes to the code so that the program will still work.  

After this change, do we need to update the JavaDoc comments for any of the public methods? Why or why not?  
