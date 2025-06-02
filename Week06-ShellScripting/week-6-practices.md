# CHC4010 DevOps Week 6 Practical: Shell Scripting  

## Part I. Display content list  

1. Choose a directory on your computer that contains a lot of files and child directory. Get the absolute path of this directory. In your shell, display the content list of this directory using its absolute path.  

Note: if you computer is running MacOS or Linux, you need to use the command ls -l to get the detailed information of each item in the directory.  

2. Create a shell script and put the command you just used into this script. Run the script and see that it generates the same output. Note: refer to page 10 of the lecture slide for how to execute shell scripts in Unix shell and in Windows Powershell.  

3. Instead of directly writing the path of the target directory in the script, make the script accept a parameter for the path of the directory whose content list will be displayed.  

## Part II. Filter files by size  

1. Look at the content list output from our script. How are files and subfolders listed differently?  

2. Create a Java class `FileFilter.java` and save it in the same location as your shell script. In the main method of this class, receive the content list of a directory as standard input (System.in) and print out only the files (not the folders). Modify your shell script and use piping to make the output of `ls` become the input of `java FileFilter.java`.  

Example target directory:  

<html><body><table><tr><td>Name</td><td>Date Modified</td><td>Size</td><td>Kind</td></tr><tr><td>pycache_</td><td>2023/9/15</td><td></td><td>Folder</td></tr><tr><td>blackbox</td><td>2023/9/15</td><td></td><td>Folder</td></tr><tr><td>coffee_can.pdf</td><td>2023/9/15</td><td>223 KB</td><td>PDF Document</td></tr><tr><td>dice_game</td><td>12:35</td><td></td><td>Folder</td></tr><tr><td>errors</td><td>2024/3/4</td><td></td><td>Folder</td></tr><tr><td> mark.py</td><td>2023/9/15</td><td>518...ytes</td><td>Python Scripte</td></tr><tr><td> mountain_array.py.</td><td>12:35</td><td>442...ytes</td><td>Python Script</td></tr><tr><td>notes.md</td><td>2023/9/15</td><td>3 KB</td><td>Document</td></tr><tr><td>Print.java</td><td>2023/9/15</td><td>119...ytes</td><td>Java so...e code</td></tr><tr><td>solution</td><td>2024/3/8</td><td></td><td>Folder</td></tr><tr><td>test.py</td><td>2024/3/4</td><td>622...ytes</td><td>Python Script</td></tr><tr><td>valid_mountain_array.py</td><td>2024/3/8</td><td>2 KB</td><td>Python Script</td></tr></table></body></html>  

### Example output:  

```sh
-rw-r--r--  1 a13350632007  staff 119 Sep 15 2023 Print.java 
-rw-r--r--  1 a13350632007  staff 223266 Sep 15 2023 coffee_can.pdf 
-rw-r--r--  1 a13350632007  staff 518 Sep 15 2023 mark.py 
-rw-r--r--  1 a13350632007  staff 442 Mar 31 12:35 mountain_array.py 
-rw-r--r--  1 a13350632007  staff 3417 Sep 15 2023 notes.md 
-rw-r--r--  1 a13350632007  staff 622 Mar 4 15:44 test.py 
-rw-r--r--  1 a13350632007  staff 1933 Mar 8 11:51 valid_mountain_array.py
```

3. Modify `FileFilter.java` so that it prints out only the files whose size is bigger than 1000 bytes (or choose an appropriate number).  

4. Instead of hardcoding the maximum size 1000 in the java code, pass it as a second parameter into the shell script, which in turn should use it as an argument when running the Java file. We know that the main method of a Java class is defined like this: <br>`public static void main(String[] args)` <br>If you run the java file with arguments: <br>`java <file_path> a b c` then inside the main method, the parameter args with be an array of Strings containing 3 elements: <br>$\{ ^ { \prime \prime } \mathsf { a } ^ { \prime \prime } , ^ { \prime \prime } \mathsf { b } ^ { \prime \prime } , ^ { \prime \prime } \mathsf { c } ^ { \prime \prime } \}$ <br>Run the shell script with different values for the second parameter and observe the different output.  

5. Modify the `FileFilter.java` to output only the name of files and modify the shell script to redirect the output into a file `big_files.txt`.  

## Part III. Back up big files  

1. Create a new folder called “big_files_backup”, and set the environment variable `big_files_back_up_path` to the absolute path of this folder. Read the environment variable from your shell to check that it’s actually saved.  

2. In your shell script, read from `big_files.txt` and copy each file listed here into the folder we just created, using the environment variable. Note: `big_files.txt` contains only the file name, so you need the path of the containing directory in order to locate these files.  

> [!TIP]
> 🔗 [Solution codes](week-6-practices-solution)

