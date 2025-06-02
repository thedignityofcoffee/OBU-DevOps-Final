import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class StudentDBTest {
    StudentDB database;
    Random random = new Random();

    @BeforeEach
    public void setUp() {
        database = new StudentDB(5);
    }

    @Test
    void addStudents() {

    }

    @Test
    void getStudent() {
        String[] students = {"Ariel", "Bill", "Charles"};
        for (String student : students) {
            database.addStudent(student);
        }
        assertArrayEquals(database.getStudents(), students, "Should return the students in the database!");
    }

    @Test
    void removeStudent() {
        // test that student count goes down
        // test that student is removed from the database
        // test that students stay in alphatical order after a student is removed
        // test that error is thrown when attempting to remove a student not in the database
        String[] students = {"Ariel", "Bill", "Charles"};
        for (String student : students) {
            database.addStudent(student);
        }
        assertEquals(database.getStudentCount(), 3);
        database.removeStudent("Bill");
        assertEquals(database.getStudentCount(), 2, "Student count should decrement when a student is removed");
        String[] currentStudents = {"Ariel", "Charles"};
        assertArrayEquals(database.getStudents(), currentStudents, "Student shouldn't be in the database after removal");

        Exception e = assertThrows(StudentDB.StudentNotFoundException.class, () -> {
            database.removeStudent("Jacquie");
        }, "should raise exception when attempting to remove a student that is not in the database");
        String expectedMessage = "Cannot find student Jacquie in the database!";
        String actualMessage = e.getMessage();
        assertTrue(actualMessage.contains(expectedMessage),
                "The erorr message is incorrect");
    }
}