# CHC4010 DevOps Week 4 – Practical: Debugging
## Exercise 1: A Hello World Program in Java
Create a new project in IntelliJ. Write a simple program that prints “Hello world” and run it. This exercise is just to get you used to starting up and using IntelliJ.
## Exercise 2: Fix an implementation of validMountainArray algorithm
Last week, we have tested this implementation of `validMountainArray` in Python. Here is the same implementation in Java:
```java
static boolean isValidMountainArray(int[] arr) {
    int i = 1;
    boolean ascending = true;
    while (ascending && i < arr.length) {
        ascending = arr[i] > arr[i - 1];
        i++;
    }
    if (i == arr.length) return false;
    boolean descending = true;
    while (descending && i < arr.length) {
        descending = arr[i] < arr[i - 1];
        i++;
    }
    return i == arr.length;
}
```
  
Unzip `starting_files.zip` and move the file `ValidMountainArray.java` into the `src` folder of your IntelliJ project. Extra points if you could do it with CLI!  
  
Enable assertions and run the file. Based on the assertion failures and the test results from last week’s practice, fix the bugs using IntelliJ debugging tools so that all the assertions pass.  
## Exercise 3: Fix an implementation of insertion sort
In the following code segment, the insertion sort ![](https://tutorialsbookmarks.com/wp-content/uploads/2019/08/Insertion-sort-example.gif)  algorithm is implemented with 3 methods: `insertionSort()` iterates through an array of integers and calls `insert()` on each one of them; `insert()` focuses on a certain integer in the array, looks at the pre-sorted subarray preceding it, and inserts it into the right spot; `move()` takes a subarray delimited by the pointers `begin` and `end` and moves it rightward by one place, to make room for the insertion. Move the file `Sort.java` in `starting_files` into the `src` folder of your IntelliJ project. Test and debug the sorting program using IntelliJ debugging tools.  
  
```java
static void insertionSort(int[] nums) {
    for (int i = 1; i < nums.length; i++) {
        insert(nums, i);
    }
}
static void insert(int[] nums, int i) {
    for (int j = 0; j < i; j++) {
        if (nums[j] > nums[i]) {
            int n = nums[i];
            move(nums, j, i);
            nums[j] = n;
        }
    }
}
static void move(int[] nums, int begin, int end) {
    for (int i = begin; i < end; i++) {
        nums[i + 1] = nums[i];
    }
}
```

> [!TIP]
> 🔗 [Solution Code](week3-pratical-solution)

