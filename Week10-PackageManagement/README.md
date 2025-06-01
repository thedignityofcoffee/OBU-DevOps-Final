# Week 10 Package Management

> Goal:
> - Understand Software Dependency
> - Using Packages: A Demo
> - Issues with Package Management

## Dependencies

- A dependency refers to any external code, library, or system that a software application or software component requires (relies/depends on) to function properly. 
- Dependencies are almost inevitable in modern software development because:
  - Different tasks within software development require specialized knowledge that might be beyond the expertise of a single development team. 
  - Building every component from scratch is time-consuming and expensive.
  - The DRY(“Don’t Repeat Yourself”) principle encourages developers to use existing code for functionality that has been previously implemented and tested, rather than rewriting it.
- Related terms: package, library, framework, plugin

## Libraries

- Libraries are blocks of code which can be re-used in multiple programs. Libraries are used to simplify programming and to avoid the programmer needing to rewrite the same program over and over again. You can, and should, create your own libraries.
- Libraries can be provided as source code, which works as an additional source code file to go with your main program source code.
- For some languages libraries can be provided as object code which is pre-compiled machine code. This is often because the library author does not want to give you their source code, but can also speed up compilation since the work of turning the library into machine code is already complete.

## Package Management

- Because of the large range of libraries available for some programming languages, custom package management tools have evolved for dealing with them.
- A package manager will deal with downloading and installing libraries from the internet for you. If those libraries themselves require libraries, they will be downloaded too.
- If you choose to release your source code, providing a package manager configuration file (commonly called a manifest/definition file) will enable other programmers to download your source code and then quickly obtain the necessary libraries to compile it. In languages without package management, this could quickly become a nightmare!

## Package Managers

| Language    | Package Manager |
|-------------|-----------------|
| Python      | pip             |
| Java        | Maven, Gradle   |
| C#          | NuGet           |
| JavaScript  | npm             |
| Ruby        | Bundler         |
| Common LISP | ASDF            |

### Maven

Maven is a popular package manager specifically designed for Java projects. It handles project dependencies, builds, and provides a standardized structure for Java projects. Maven facilitates the effective management of libraries and plugins required for Java development.

## Manifests

| Language    | Package Manager | Manifest          |
|-------------|-----------------|-------------------|
| Python      | PIP             | requirements.txt  |
| Java        | Maven           | pom.xml           |
| C#          | NuGet           | .nuspec           |
| JavaScript  | Npm             | package.json      |
| Ruby        | Bundler         | Gemfile           |
| Common LISP | ASDF            | .tool-versions    |

## Package Documentation

- Documentation is a critical component of any software package, as it helps users understand and effectively use the product. The package we used in the previous example, turtle-logo, has its documentation [here](https://gann-cdf.github.io/turtle-logo/).
- Package documentation typically covers topics such as:
  - Overview: a brief description of what the software does and its key features
  - Getting Started Guide: the minimum necessary steps to get the software up and running, such as installation instructions, initial configuration, and a simple example to demonstrate a basic use case
  - Usage Examples: practical examples showing how to use the software in various scenarios. This can also include code snippets, command-line examples, and screenshots
  - Troubleshooting: Information on how to diagnose and resolve common problems that users might encounter
  - And more…

## External Libraries

> Where is the source code for turtle-logo?

- Maven downloads the specified packages to a location called the local Maven repository. The default location is `~/.m2/repository/` but it can be customized.
- Some other package managers will place the package source code within the project directory. For example, npm downloads the packages and their dependencies into a folder named `node_modules` within your project directory by default.

## Package Use and Version Control

- The source code of any packages you make use of should **not** be included in your Git repository. If placed inside your **working directory** (usually the project root folder), they should be ignored by Git.
- Instead, Git should track the manifest, which specifies exact versions of all the packages included in the project. 
- When the Git repository is cloned to a different computer, the developer could easily replicate all the dependencies on that computer by having the package manager download the dependencies according to the manifest.

## Issues with Package Management

### Dependency Conflict: What is it?

When different parts of a software project require different versions of the same dependency, the problem of dependency conflict occurs.
![conflict](/Week10-PackageManagement/images/clash.png)

### Dependency Conflict: Why does it happen?

- **Version Specification**: If dependencies are not correctly specified (e.g., too strict or too broad version constraints), it might pull in incompatible versions.
- **Legacy Code**: Older projects might use outdated libraries that require versions of dependencies no longer compatible with newer ones used in other parts of a project.
- **Transitive Dependencies**: These are dependencies of dependencies. You might directly control your project's immediate dependencies, but these dependencies might have their own set of dependencies, leading to conflicts.

### Dependency Conflict: How to deal with it?

- **Identify the Conflicting Dependencies**: Tools like pipdeptree in Python, mvn dependency:tree in Maven, or npm ls in npm can help visualize dependency trees to identify where conflicts are occurring.
- **Adjust Version Constraints**: Modify the version constraints in your dependency files to create a compatible set of dependencies. This might involve upgrading or downgrading certain dependencies.
- **Remove Unnecessary Dependencies**: Sometimes, conflicts arise from dependencies that aren't actually used. Removing these can reduce complexity and eliminate conflicts.
- **Regularly Update Dependencies**: Keeping dependencies up-to-date helps avoid conflicts as libraries evolve to be more compatible with each other.

![dependencies](/Week10-PackageManagement/images/dependencies.png)

![book-dependenciesbook-dependencies](/Week10-PackageManagement/images/book-dependencies.png)

### Deprecation: What is it?

- **Deprecation** refers to the practice of marking a software feature, functionality, or even the entire software as obsolete or discouraged for use, but still technically available. Deprecation is a warning to users that specific aspects of software are outdated and may be removed or changed significantly in future releases.
- **End of Life(EOL)** is a related turn, which means a product, version, or feature will no longer be supported or maintained by the manufacturer or maintainer after a specified date. This means no more updates, bug fixes, security patches, or technical support.

### Deprecation: What does it mean for us?
- When a library is deprecated, it may no longer be receiving updates for security vulnerabilities. Continuing to use deprecated libraries could expose the software to unpatched security risks.
- Deprecated functionalities might still work, but they may no longer be compatible with newer versions of other dependencies or the core programming environment. 
- Post-EOL, any unresolved bugs or compatibility issues in the dependency will remain unaddressed, potentially leading to poor performance and frequent crashes.

### Deprecation: What should we do?

- Deprecated features are documented in API docs, changelogs, or release notes. Package managers may also issue warnings during build or runtime when deprecated features are used.
- Keeping up with deprecation notices allows developers to proactively update their software with newer, more efficient, and more powerful technologies. To do this, developers can:
  - keep an eye on the release notes and documentation of key dependencies for any announcements related to deprecation or EOL
  - use tools integrated with or provided by package managers to regularly check the health and status of dependencies
  - begin planning the migration to alternative solutions or newer versions when deprecation notices are issued, avoiding last-minute scrambles
  - configure package managers to automatically update to newer, compatible versions of libraries, where appropriate (debatable)

## Package Management and Security

Open library usage can be a threat to security:
- Hackers may deliberately write libraries containing hidden malicious code
- A library may accidentally contain a security breach which is then included in all programs that use it
  - Example: Heartbleed in OpenSSL, 2012

However, it is also argued that it can improve security:
- Any malicious code can be seen in the source code and removed
- Having a large number of users and programmers able to look at the source code maximizes the chance of errors being spotted and fixed
  - Example: how Heartbleed was discovered
- Using standard, established implementations ensures that common security mistakes are not repeated
  - Rule of thumb: "never write your own encryption"

### Other Issues

- Package managers depend on libraries being made freely available, since they usually cannot deal with paid licenses or digital rights management. The GPL (Gnu Public License) and CC-SA (Creative Commons Share Alike) licenses state that if a library is placed under one of these licenses, the program it is used in must be too (and thus given away free). Relatively few free libraries actually use these licenses (preferring LGPL or BSD) but if you are writing software for an employer it is often necessary to check.
- Packages can be withdrawn from package managers, potentially breaking programs that need them; and overuse of package management can result in trivial code ending up depending on packages. An infamous example occurred in 2016 when a library called left-pad was removed from npm. It contained only a single trivial function but its removal broke a number of larger programs.

## Open Packages and Plagiarism

In general when writing software for your course at Brookes, using libraries or available source is OK, provided that:

- You clearly announce that you are doing so
- You understand that you will get no marks for implementing the functions the library provides
- Using a library or other source without crediting it is plagiarism and can result in disciplinary proceedings
  - Attempting to hide that you have done so may be taken as evidence of deliberate intent to cheat and will result in more severe consequences
- You may at times at Brookes be asked to complete a programming exercise for which an answer is available online
  - This is a learning exercise and using the online material will result in a mark of zero

## Dealing with the Clean Room Program

- Use the internet only to find out specifics of programming languages – eg, names of keywords, syntaxes, functions, etc.
- For questions involving how to solve a problem or produce an algorithm that is part of the marked coursework, go to your lecturer or textbook first, not the internet
- Avoid asking questions on sites like Stack Overflow – the response may be a complete answer (which you then cannot use!)
- Equally, avoid posting your work freely or on similar sites, since other students may find it

## Organising a Large Program

- For **small programs in interpreted languages**, it is OK to write the program as just a single source file stored in a directory with other things.
- For **larger interpreted programs**, it is normal to split the program into several source files and create a folder in which the source files for the program are kept together.
- For **larger programs in compiled languages**, a project work directory is usually maintained with a number of sub-directories containing parts of the project or files produced in the process. The names of these subdirectories can be chosen freely but a number of standards have emerged which are used by most programmers and supported by most software.

- **`src/`** - directory containing your source code. This can be divided into files or further folders based on the size and organization of the code.
- **`lib/`** - directory containing libraries, as source code or machine code. These are often divided further into subdirectories based on type.
- **`build/`** - directory in which files produced by the compiler, including machine code and the executable, are stored. Usually you should not place anything in this folder yourself. 
- **`res/`** - directory holding resources and other data files that are needed when the program runs.
- **`dist/`** - directory holding the program as it will be supplied to end users.

