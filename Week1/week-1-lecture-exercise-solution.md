# CHC4010 DevOps Week 1 – Lecture Exercises Using the Command Line  

# Task 2: Navigate the file system  

1. Find out the current directory and open it in finder/file explorer.  
	For Linux terminal, use the command `pwd` to find out the location of the current directory. For Windows Powershell, the location of the current directory will be shown before the prompt.   
	To open the current directory in finder/file explorer: 
	Linux: `open .`   
	Windows: `start .`   
2. Find out all the files and child directories (subfolders) in the current directory (including the hidden ones) and the time when they are last modified. 
	Linux: `ls -a` 
	Windows: `ls -Hidden`   
3. Go into the child directory Documents. 
	`cd Documents`   
4. Go into the parent directory of your home directory. 
	`cd ~/..`   
5. Go to the root directory. 
	Linux: `cd /` 
	Windows: `cd C:\`  

# Task 3: Navigate the file system  

6. In your home directory, create a new folder called `dops`. 
	`cd ~` 
	`mkdir dops`  
7. In the `dops` folder, create a new file `test.txt`. 
	`cd dops` 
	Linux: `touch test.txt` 
	Windows: `ni test.txt`  
8. Write the content list of your home directory into `test.txt`, followed by the sentence “This is my home directory”. 
	`ls .. > test.txt` 
	`echo “This is my home directory” >> test.txt`   
9. Open `test.txt` to check it has the correct content. 
	Linux: `open test.txt` 
	Windows: `start test.txt`  
10. In `dops` folder, make a new folder `week1`. 
	`mkdir week1`  
11. Copy `test.txt` into `week1` folder and rename it to `home_dir`. 
	`cp test.txt week1` 
	`mv week1/test.txt week1/home_dir.txt`  
12. Delete the test.txt file that’s directly under dops folder. 
	`rm test.txt`  
13. In `dops` folder, create 4 python files with whatever names you like. 
	`ni hello.py` 
	`ni hello1.py` 
	`ni hello2.py` 
	`ni hello3.py` 
	Use `touch` instead of `ni` for Linux.  
14. Move these python files into `week1` folder. 
	`mv *.py week1`  
15. Delete all python files in week1 folder but leave `home_dir.txt` intact, with only one line of command. 
	`rm week1/*.py`  
