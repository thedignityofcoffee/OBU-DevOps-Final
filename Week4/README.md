# Week 4 Documentation

- Documentation: any document or material that explains the use, functionality, creation, or architecture of a software or system.
- In the previous activity, we have seen two types of documentation:
    - Code comments
    - Javadoc

## Comments in Programs

- All programming languages support comments: text which is included in the program for humans to read, and ignored by the computer.
- Adding comments to your code can help other programmers read and understand it.
- They can also be valuable for you when you come back to code you have written in the past.

### Kind of comments

- End of line comments: a symbol marks the start of a comment, and it ends at the end of a line.
```java
x++; // This is an end of line comment in Java
// For several lines of comment, you have
// to repeat the symbol.
```

- Block comments: symbols mark the start and end of a comment. The comment may span multiple lines.
```java
/* This is a block comment in java.
The comment can span multiple lines as long as
They are enclosed in these symbols. */
```

### Commenting convention

When a comment is written on the same line as some code, it explains that line of code.
```java
game.changeTurn(); // change the turn
```
When a comment occupies a separate line by itself, it explains the next line or the next block of code.
```java
// remove that number from the pile
game.userPlay(userTake);
```

### Comments and Documentation

- For some programming languages, including Python and Java, tools are available which generate organized human readable documentation from comments in the source code.
- These tools focus on documentation that will be useful to other programmers using your code. They are not normally suitable for generating documentation on how your code works or how it was arrived at.
- By generating this documentation from comments, the documentation and code can be held in a single file, reducing the risk of them being changed independently and no longer matching each other.

## JavaDoc

- JavaDoc is a documentation generator for generating API documentation in HTML format from Java source code.
- While regular code comments explain the **internal workings** of the code or explain complex logic for anyone **reading the code directly**, JavaDoc comments describe **what the code does** from an API **user’s perspective**.
- That is to say, JavaDoc comments focus on the **interface and behaviour** of the code – the functionality that is exposed to the user or developer **who will be using the code**.

### Usually included in JavaDoc:

- **Purpose**: what action will it perform or what result will it produce.
- **Usage**: what parameters it expects, what values these parameters should take, and in what order.
- **Behavior**: the expected behavior of a method, including side effects or changes in the state of the system or object.
- **Output**: what values or objects are returned by a method and what they represent.
- **Exceptions**: the exceptions that might be thrown during the execution and explain what conditions would cause these exceptions.
- **Constraints and Preconditions**: any preconditions or constraints on how the method should be called, such as required state of the system or specific conditions that must be true before the method is called.

### How to create Javadocs 

To create a Javadoc, immediately before a class, method, or property, enter a comment describing the item in the following format:
```java
/**
 * Here is the description.
 */
```
If you type /** immediately before the target and hit Enter, IntelliJ will lay out the template for you.

### JavaDoc formatting rules

- The first sentence of your JavaDoc comment should be a summary.
- Later sentences should give more detail.
- After the main textual part, you can attach tags giving more information about details of the function or method.

```java
/**
 * Looks up a student in the provided list.
 * @param students The list of students.
 * @param name     A name
 * @return The corresponding student number.
 */
public int findStudent(List<Student> students, String name)
{ … }
```

Standard tags:
- `@param` gives the name and description of a parameter taken by a method. These should always be provided.
- `@return` gives a description of what a method returns. These should always be provided unless a method returns void, or is a constructor.
- `@throws` gives an exception the method can throw and a description of when and/or why it would do so.

Optional tags:
- `@author` gives the name of the author of the code.
- `@see` adds a reference to another part of the documentation, given as package.class#label.
- `@since` is used when writing version updates to include the version number when a method or class was added.
- `@deprecated` is used when writing version updates to indicate that a given method or class should not be used in the current version, where it was in older versions.


### JavaDoc content rules

- First sentence should be **a summary** of everything in the later block.
- Avoid describing **how the code works** in the documentation unless a caller/user needs to know it. (If you find a better way of doing the same thing, you shouldn’t need to change the documentation, just the code.)
- If referring to a method with no parameters, write () after the name. If referring to an overloaded method with several parameter sets, just write the name.
- Write in **third person declarative** (“gets the student number”), not imperative (“get the student number”) or future (“will get the student number”)
- If the thing being documented is the subject of a sentence you can probably leave it out (“gets the student number”, not “this method gets the student number”)
- If the object represents a thing on which methods are called, call it “this” (eg, `Student.getName` “gets the name of this student”, not “gets the name of the student”)

## Documentation

Documentation is critically important throughout programming and software development:
- For understanding code written by others
- For enabling others to understand code written by you
- To enable end users to use the software you produce
- To understand what a customer or manager is asking you to do
- To give instructions to other members of a programming or testing team

Documentation is used by:

- End users of software
    - User guides, manuals, FAQs…
- Developers who use existing software to build new software
    - API references, integration guides, development manuals…
- Developers who maintain and update existing software
    - Code comments, system architecture documents, internal API docs…

Also:

- **Project managers**
    - Project managers use technical documentation to understand project scope, deliverables, timelines, and technical constraints. This enables them to plan, execute, and monitor project progress effectively.
- **Product owners**
    - Product owners refer to documentation to ensure that the software meets the requirements and to understand technical details that impact product decisions and priorities.
- **Investors**
    - Investors review high-level technical documentation that outlines the capabilities, advantages, and uniqueness of the technology for due diligence purposes.
- **Customer support**
    - Customer support teams use technical documentation to help troubleshoot customer issues, guide users through complex processes, or clarify functionalities.
- **Sales and marketing**
- **Compliance and security auditors**
- **And more…**

### Tools for documentation

- Regular word processors such as Microsoft Word, Apple Pages, OpenOffice, etc are perfectly adequate for documenting software
- Some software makes use of standard diagrams for which specific software exists such as Microsoft Visio, SmartDraw or StarUML
- Some programmers prefer to use alternative formats for technical documentation:
    - **HTML**: can display in any web browser, but can be more awkward to write and maintain
    - **Markdown**: a plain-text base format with symbolic conventions for layout, turned into PDF or HTML by a free markdown processor
    - **LaTeX**: a free document processor with its own text format and an inbuilt programming language for extensibility; hard to learn but has strong support for maths, diagrams, and complex layouts. Usually used together with a LaTeX specific editor such as TeXworks
