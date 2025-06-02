/**
 * A simple database for managing student records.
 * This class provides functionality to add, remove, and retrieve student information.
 * It operates on a fixed-capacity array-based storage mechanism.
 */
public class StudentDB {
    /**
     * Exception thrown when attempting to add a student to a full database.
     */
    static class DatabaseCapacityFullException extends RuntimeException {
        public DatabaseCapacityFullException() {
            super("Student database has reach maximum capacity!");
        }
    }

    /**
     * Exception thrown when a specified student cannot be found in the database.
     */
    static class StudentNotFoundException extends RuntimeException {
        public StudentNotFoundException(String studentName) {
            super("Cannot find student " + studentName + " in the database!");
        }
    }

    private String[] students;
    private int capacity;
    private int studentCount;

    /**
     * Constructs a new StudentDB with the specified capacity.
     * @param capacity The maximum number of students the database can hold.
     */
    public StudentDB(int capacity) {
        this.capacity = capacity;
        students = new String[capacity];
    }

    /**
     * Returns the current number of students in the database.
     * @return The number of students.
     */
    public int getStudentCount() {
        return studentCount;
    }

    /**
     * Returns the capacity of the database.
     * @return The maximum number of students the database can hold.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Retrieves all student names in the database.
     * @return An array of student names.
     */
    public String[] getStudents() {
        return students; // TODO
    }

    /**
     * Adds a new student to the database.
     * Students are maintained in case-insensitive alphabetical order.
     * @param newStudent The name of the student to add.
     * @throws DatabaseCapacityFullException if the database is full.
     */
    public void addStudent(String newStudent) throws DatabaseCapacityFullException {
        if (studentCount == capacity) {
            throw new DatabaseCapacityFullException();
        }

        int i = 0;
        while (i < studentCount && students[i].compareToIgnoreCase(newStudent) < 0) {
            i++;
        }
        for (int j = studentCount; j > i; j--) {
            students[j] = students[j - 1];
        }
        students[i] = newStudent;
        studentCount++;
    }

    static int binarySearch(int[] nums, int n, int i, int j) {
        if (i > j) return -1;
        int mid = i + (j - i) / 2;
        if (nums[mid] == n) return mid;
        else if (nums[mid] < n) return binarySearch(nums, n, mid + 1, j);
        else return binarySearch(nums, n, i, mid - 1);
    }

    /**
     * Searches for a student by name.
     * @param student The name of the student to find.
     * @return The index of the student in the array, or -1 if not found.
     */
    private int findStudent(String student) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].equalsIgnoreCase(student)) return i;
        }
        return -1;
    }

    /**
     * Removes a student from the database by name.
     * @param student The name of the student to remove.
     * @return The name of the removed student.
     * @throws StudentNotFoundException if the student cannot be found in the database.
     */
    public String removeStudent(String student) {
        return student; // TODO
    }

    public String toString() {
        StringBuilder studentsString = new StringBuilder("Students in the database:\n");
        for (int i = 0; i < studentCount; i++) studentsString.append(students[i]).append("\n");
        return studentsString.toString();
    }
}
