# CHC4010 DevOps – Example Coursework Assignment  

2023-2024  

For this coursework you will be doing work debugging, understanding and improving a program that has been provided to you.  

You have been provided with the java source code that plays a game where the player chooses a number and the program guesses what that number is. (The game is described in more detail at the end of this document.) Unfortunately, a rather strange and oddly specific glitch has carried the names of all the variables and functions in the program away – literally.  

Use a Java IDE to analyse the program using the debugger and code analysis tools, and work out what each variable, parameter, and method does. You should also find and fix the bugs in the program.  

You must submit your work <strong>before <ins>23:59 on Friday of week 11</ins></strong>.  

Part of the coursework include a quiz related to the program, and will be taken in class on <ins>week 12</ins>. Note that you should complete tracing and learning about the program before submitting it at the end of <ins>week 11</ins>, and doing the quiz on <ins>week 12</ins>.  

Feedback will be provided online once the work has been completed. You may also ask for feedback from your class tutor in any module session, although tutors will not directly tell you the answers to questions.  

This is individual work and is subject to the University’s regulations on assessment. Students who plagiarize work from other students, the Internet, or any other source, will be subject to the Academic Conduct Process. Work submitted late without an appropriate Mitigating Circumstances claim or Equality Memo will not be marked. Posting parts of the source code, or of your answer, on the Internet (to solicit answers or for any other reason) is not permitted and will be treated as an attempt to cheat or facilitate others cheating.  

## Task  

- Change the name of the variables, parameters and methods to more meaningful names
- Add JavaDoc description to each method, describing the input, output of the functions and what they do
- Find and fix the bugs
- Write automated tests for methods `cakeWalk()` and `appleJack()` with the testing library `JUnit 5`.
- Use Git to track your progress and make different commits for the four tasks mentioned above with clear commit messages. Your local Git repository should be synced with a remote repository on gitee.com.  

Once you have finished refactoring the program, you must submit ONLY the source code file on the student website before the deadline.  

## Tips  

- You should use IntelliJ for this exercise.
- The file is provided as a bare Java source file. **You should create a *Project* in an IDE and then load the file into it.** Do not just open the file raw, as it will not be associated with a JDK and analysis tools will not be available.
- You should rename the variables in the source code first as it will make the work much easier. Start by identifying the obvious variables based on the user prompts and the string outputs, rename these, and then see how they are used elsewhere in the program. Do make notes of what you have renamed each variable as the quiz will ask you about this.
- The program may use some Java constructions you have not seen before. Tracing the code should help you learn what these do.

## Guess My Number  

This game is used in math classes as a pedagogical device. The student is asked to pick an integer between 1 and 64 inclusive, without telling the teacher what the number is. The teacher then goes on to display a list of integers (within the aforementioned range), and the student will indicate whether the number they have chosen is found in this list. This process is repeated 6 times. At the end of the game, based on the 6 answers given by the student, the teacher will be able to tell exactly which number they have picked. Can you figure out how this is accomplished?  

Our program allows the user to play the role of the student. After asking the user to pick a number in the range 1 to 64 inclusive, the program will print 6 lists of numbers (these lists are randomized and should be different each time the game is played), and each round the user will type “Y” if their number is in the list, and “N” if not. Then the program will print out the number that it decides is the one picked by the user. If the program runs without any bugs and the user gives a truthful answer each time, the guess should always be correct.  

An example is given on the next page.  

```sh
Please pick a number between 1 and 64 (inclusive)   
2; 4; 6; 11; 12; 15; 16; 17; 20; 22; 23; 24; 25; 27; 30; 31; 32; 33; 38; 39; 40; 41; 42; 43; 47; 52; 53; 55; 57; 59; 61; 64;   
Is your number in this list? (Y/N)   
Y   
2; 4; 5; 6; 7; 10; 11; 13; 14; 16; 17; 18; 20; 21; 24; 25; 26; 27; 29; 32; 33; 35; 36; 42; 44; 47; 49; 51; 54; 55; 58; 61;   
Is your number in this list? (Y/N)   
Y   
1; 2; 3; 4; 5; 6; 7; 9; 13; 15; 16; 17; 20; 22; 25; 26; 29; 30; 31; 34; 38; 43; 44; 46; 48; 49; 52; 58; 60; 61; 62; 64;   
Is your number in this list? (Y/N)   
N   
3; 4; 7; 8; 9; 11; 13; 14; 17; 18; 20; 22; 25; 26; 28; 30; 33; 35; 39; 41; 42; 43; 45; 47; 48; 49; 52; 53; 54; 56; 57; 62;   
Is your number in this list? (Y/N)   
Y   
1; 3; 8; 9; 11; 12; 13; 14; 16; 17; 21; 23; 25; 26; 27; 30; 34; 37; 38; 41; 42; 44; 51; 52; 53; 54; 55; 56; 58; 61; 63; 64;   
Is your number in this list? (Y/N)   
N   
3; 6; 10; 13; 14; 18; 20; 23; 24; 25; 27; 29; 30; 31; 34; 37; 38; 39; 42; 43; 44; 45; 47; 48; 49; 50; 51; 53; 56; 59; 60; 61;   
Is your number in this list? (Y/N)   
N   
Your number is 33  
```
