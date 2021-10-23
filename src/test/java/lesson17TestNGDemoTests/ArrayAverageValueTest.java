package lesson17TestNGDemoTests;

import lesson17TestNG.ArrayAverageValue;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ArrayAverageValueTest {
    ArrayAverageValue arr;

    // hola estamiloka
    @BeforeTest
    public void initNumberPowered() {
        arr = new ArrayAverageValue();
        System.out.println("Test starts");
    }

    @Test
    public void testAverageArray1() {
        System.out.println("First test case for average of array values");
        double expected = 7.444444444444445;

        int array[] = {1, 2, 3, 5, 6, 7, 11, 13, 19};
        double actual = arr.arrayAverageSumValue(array);

        Assert.assertEquals(expected, actual, "False! Actual result is not match expected");
    }

    @Test
    public void testAverageArray2() {
        System.out.println("Second test case for average of array values");
        double expected = 12.121212;

        int array[] = {1, 2, 3, 5, 6, 7, 11, 13, 19};
        double actual = arr.arrayAverageSumValue(array);

        Assert.assertNotEquals(expected, actual, "False! Actual result is not match expected");
    }

    @Test
    public void testAverageArray3() {
        System.out.println("Second test case for average of array values");
        double expected = 0;

        int array[] = {0, 0};
        double actual = arr.arrayAverageSumValue(array);

        Assert.assertEquals(expected, actual, "False! Actual result is not match expected");
    }

    @AfterTest
    public void endTest() {
        System.out.println("Test finished");
    }
}
