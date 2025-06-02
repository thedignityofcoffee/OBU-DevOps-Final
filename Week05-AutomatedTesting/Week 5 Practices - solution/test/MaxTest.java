import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MaxTest {
    Random random = new Random();

    @Test
    void max() {
        for (int i = 0; i < 1000; i++) {
            int length = random.nextInt(2, 1000);
            int[] arr = new int[length];
            for (int j = 0; j < length; j++) {
                arr[j] = random.nextInt(-1000, 1000);
            }
            int max = Max.max(arr);
            for (int j = 0; j < length; j++) {
                assertTrue(max >= arr[j],
                        "The biggest number should be bigger than or equal to the " + j + "th number in the arrray!");
            }
        }
    }

    @Test
    void maxForEmptyArray() {
        int[] emptyArray = new int[0];
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            Max.max(emptyArray);
        }, "doesn't raise illegal argument exception when an empty array is given");
        String expectedMessage = "Cannot find max for an empty array!";
        String actualMessage = e.getMessage();
        assertTrue(actualMessage.contains(expectedMessage),
                "The erorr message is incorrect");
    }

    @Test
    void maxForArrayOfOne() {
        int[] arrayOfOne = new int[1];
        arrayOfOne[0] = random.nextInt(-1000, 1000);
        assertEquals(Max.max(arrayOfOne), arrayOfOne[0],
                "Should return the first number if the array has only one element");
    }
}