package TestNGDemoTests;

import lesson17TestNG.NumberToPowerOfAnother;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NumberToPowerOfAnotherTest {
    NumberToPowerOfAnother num;

    @BeforeTest
    public void initNumberPowered() {
        num = new NumberToPowerOfAnother();
        System.out.println("Test starts");
    }

    @Test
    public void testPow1() {
        System.out.println("First x powered to number y test case");
        int expected = 4;
        int actual = num.aPowerToB(2, 2);

        Assert.assertEquals(actual, expected, "False! Actual result is not match expected");
    }

    @Test
    public void testPow2() {
        System.out.println("Second x powered to number y test case");
        int expected = 9;
        int actual = num.aPowerToB(3, -3);

        Assert.assertNotEquals(actual, expected, "False! Results are the same");
    }

    @Test
    public void testPow3() {
        System.out.println("Third x powered to number y test case");
        double expected = 723019.6133913604;
        double actual = num.aPowerToB(5.4, 8.3);

        Assert.assertEquals(actual, expected, "False! Actual result is not match expected");
    }

    @Test
    public void testPow4() {
        System.out.println("Fourth x powered to number y test case");
        int power = num.aPowerToB(3, 5);
        Assert.assertTrue(power == 243, "False! Result is false");
    }

    @AfterTest
    public void endTest() {
        System.out.println("Test finished");
    }
}
