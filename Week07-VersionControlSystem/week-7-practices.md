# CHC4010 DevOps Week 7 Practical: Version Control  

## Part I. Simple Java Project  

1. Create a new project `Power` in IntelliJ and create a new git repository in the project root folder.  
2. Complete a Java program in 4 steps:  
	1. Add new file Power.java to src folder   
	2. Add static method `power(x, y)` that computes x to the power of y   
	3. Add `javadoc` for `power()` method   
	4. Test `power()` in main method  
	
	Make a commit for each step.   

> [!IMPORTANT]
> write meaningful commit messages.   
> exclude unnecessary files and folders with .gitigore.  

3. View your branch history with `git log` and `git gui` $- >$ Visualize All Branch History.  

## Part II. Remote Repository  

1. Create a new repository on Gitee and connect it to your local repository in project Power.  
2. Push your local `master` branch to the remote repository.  
3. Refresh the page on Gitee and view the code in your remote repository.  

## Part III. Branching  

1. Pull the latest version of `master` branch from the remote repository to the local repository.  
2. Create a new branch called `test` and switch to this branch.  
3. Write automated test for `power()` method (refer to week 5 content) and commit it on `test` branch.  
4. View your branch history with `git log` and `git gui` $- >$ Visualize All Branch History.  

## Part III. Merging  

1. Push `test` branch from the local repository to the remote repository.   
2. On Gitee, make a pull request for `test` branch and merge it to master. Resolve the conflicts in the Web UI if there are any.   
3. In your local repository, switch to `master` branch and pull the latest version of `master` branch from the remote repository to the local repository.   
4. View your branch history with `git log` and `git gui` $- >$ Visualize All Branch History. How many commits are there on the master branch now?  
