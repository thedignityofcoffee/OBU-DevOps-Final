# Week 12 Metaprogramming

## Some basic Java built-in templates

| Template | Result                                                 |
|----------|--------------------------------------------------------|
| sout     | `System.out.println("")`                               |
| prsf     | `private static final`                                 |
| St       | `String`                                               |
| psvm     | `private static void main (String[] args) {}`          |
| main     | `private static void main (String[] args) {}`          |

## Some standard Java smart templates

| Template | Result                                                 |
|----------|--------------------------------------------------------|
| fori     | Int arithmetic for loop (int 0–x)                      |
| itar     | Int for loop through array indexes (int 0–x.length)    |
| iter     | Enhanced for loop through members of a list            |
| lazy     | If x = null, initialize x                              |

### Creating templates

omitted

## When to use templates

- Templates should never be used as a substitute for functions or methods.
- You should almost never put complete, fixed, statements with functionality into templates.
- You should only use templates when the text:
  - Is so standard within the programming language that it can’t be turned into a function/method (eg, an if statement)
  - Has structural requirements in the language (eg, getters/setters)

## Limitations of templates

- As mentioned previously, smart templates have the issue that they are temporary.
- Once the code is created, the code remains, but the fact it was a template is lost.
- This means that:
    - Any changes to the templated code have to be made manually, without the help of the template.
    - If a bug is found in the template or an improved version is written, there is no way to update all uses of the template in the program.

## Metaprogramming

- Templates are one form of the wider field of metaprogramming: using programs to write programs.
- Metaprogramming can be extremely powerful and is quite easy to do: if you can write a program that outputs a text file, then you can write a program that writes a program!
- As with templates, metaprogramming should usually be a last resort for dealing with structural parts of a programming language. Never use metaprogramming where you could use a function / method / class

```java
String[] properties = {"age", "year", "id"};
String className = "Student";
PrintWriter fpw = new PrintWriter(className + ".java");
fpw.println("public class " + className + " { ");

for (String prop : properties) {
    fpw.println("int " + prop + " ;");
    fpw.println("public int get"+prop+"() { return "+prop+ "; }");
    fpw.println("public void set"+prop+"(int new"+prop+") { "+prop+" = new"+prop+"; }");
}

fpw.print("public " + className + "(");
for (int x=0; x<properties.length-1; x++) {
    fpw.print("int _" + properties[x] + ", ");
}

fpw.println("int _" + properties[properties.length-1] + ") {");
for (String prop : properties) {
    fpw.println(prop + " = _" + prop + ";");
}

fpw.println("}");
fpw.println("}");
fpw.close();
```

- This sample Java program produces another Java program<br>
- As written it generates a fixed class, which is of limited use. But it could be extended in many ways:
    - read className and properties from another file
    - read several classNames and sets of properties and generate several class files from one
    - include specifications of the types of the properties to generate
    - generate other standard methods such as observer interfaces

## Advantages of metaprogramming

- Since you write the entire code generator yourself, you can **customize the input and output** however you like
- You have the full sophistication of Java to use for writing the generator, so you can create extremely sophisticated code transformations
- If you change or improve the generator, you can rerun it to recreate the generated code with the added improvements

## Disadvantages of metaprogramming
- Code generators can be **confusing to read**, as the generated code gets mixed up with the generator code
- **Twice as many potential bugs**: bugs in the generator and bugs in the generated code
- **Bugs in the generated code are hard to fix**: must work out how to change the generator input or program to correctly generate non-buggy code
- Few standards for generator input and therefore usually **no help from IDEs or support tools**
- When we run the generator, it will **overwrite the generated file**, so any manual changes we have made to the java file it generated would be lost

## Avoiding code loss
- **Run the generator only once, then do later changes manually.**
    - If we change the properties in the class later on, or improve the generator, it can no longer help.
    - Have to make really sure we don't run the generator by mistake!
- **Never make any manual changes to the generated class.**
    - Any manually written functions will need to be written in other classes.
    - We can write other classes that work with the generated class, or inherit it and add new methods or override the generated ones.
- **Allow our generator input file to include arbitrary Java code.**
    - We never need to make manual changes since any code we would want to add can be in the generator's input file.
    - Easy for the generator to handle; it can just copy the text into the output file.
    - But if our development environment doesn't understand the generator file, may make the Java code hard to debug as the IDE will not be able to help us do so.

### Built-in metaprogramming

Some languages have metaprogramming built-in to their standard compilers.

- This is usually done via a preprocessor which runs before the compiler
- The preprocessor inputs the source file as text
- It follows metaprogramming instructions in the file
- Then passes the processed code on to the compiler
- C and C++ for example use a preprocessor which can:
    - Create short form instructions
    - Manage library integration
    - Handle compatibility between compilers

Some languages go even further and integrate metaprogramming into the core language rather than a pre-processor. There are two technologies used to do this: reflection and optionally homoiconicity.

## Reflection metaprogramming

- In **Reflection** metaprogramming, the language provides functions that perform language level tasks such as defining functions and classes.
- This differs from the standard syntactic commands used to do these in languages like Java, because they are full functions/methods and can, for example, be placed in loops and take variable inputs.
- In **Ruby**, for example, you can fetch a data structure from a website and then call a series of methods to define a new class with properties based on that data structure and fill them in.
<br>
- Reflection metaprogramming languages are often either:
    - Interpreted: new classes or new code generated by the program can run in the form of source code
    - Just In Time Compiled: new classes or code generated by the program can be compiled when they are generated
- Generating data structures alone without generating code is of limited use (what code will read them?)
- JIT compiled languages are usually compiled to bytecode as generating machine code and then integrating it can be a complex process, requires a lot of extra data, and is also often considered a security issue

## Reflection Metaprogramming and Snapshooting

- An alternative approach to integrated metaprogramming is to run part of the program, or run the program for a certain amount of time, then disable generation of new code<br>
- This allows metaprogramming techniques to be used for convenience and adapting code in the development environment without needing it to be able to recode itself when deployed

## Uses of Metaprogramming

- **Syntax enhancement** of this type – where we deal with a syntax that is awkward in the target language – is a simple use of metaprogramming
- **Interfacing** is another, where a class such as the previous one is generated based on an external entity (such as a database or a website), with code to get and update data on that database or site
- The most sophisticated form is the creation of a DSL (*Domain Specific Language*): a sub-language specific to solving a particular problem, which is used to generate code in Java or another general purpose language

## Metaprogramming in the toolchain

- Code generators can be used once only, or manually when their input is changed, or they can be included in the toolchain
- This is potentially complex if the code generator is in a compiled language, like Java
- The code generator must be compiled, then used to generate code, then the generated code must be compiled
- If cross compilation is being used (the program is being compiled to run on a different kind of computer) then the generated code must be cross compiled but the generator must be native compiled. This may require two different compilers

## Fitting metaprogramming into the toolchain

- It is quite possible to set up Java build sequences to run Java programs during the compilation programs
- If you are using a standard code generator like [ANTLR](https://en.wikipedia.org/wiki/ANTLR), this is much easier; since you are probably not changing the code of ANTLR it does not need to be recompiled
- You could also write the code generator in another language (this can also make it easier to understand): Python is a perfectly good language for generating Java for example
- There are also some standard languages specifically for writing code generators although they may be less powerful than complete programming languages; [FreeMarker](https://en.wikipedia.org/wiki/FreeMarker) is an example of this

- Generated code files usually need to be carefully marked to warn developers that they may need to be regenerated
- In Java the usual practice is to placed generated code files into a separate package, and have nongenerated code import it
- If you are using Version Control, you may not want to place generated source code into version control although it may be useful if it takes a long time to generate
- The input file to the generator should be included in version control

## Summary
- Metaprogramming refers to writing programs that write programs
- This can be an extremely beneficial way to avoid tedious components of programming while generating better code results
- However, it should usually be a last resort to be used only when methods or other techniques within a language could not be used or would have a substantial cost
- You can generate code for any language if you can write a program that produces a text file
- Some languages include enhanced support for metaprogramming
