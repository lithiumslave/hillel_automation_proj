package lesson17TestNGDemoTests;

import lesson17TestNG.ReverseInteger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReverseIntegerTest {
    ReverseInteger reverseNum;

    @BeforeTest
    public void initReverseInt() {
        reverseNum = new ReverseInteger();
        System.out.println("Test starts");
    }

    @DataProvider(name = "reverseIntTestDataProvider")
    public Object[][] reverseIntTests() {
        return new Object[][] {
                {12345, 54321},
                {-123, -321},
                {0, 0},
        };
    }

    @Test(dataProvider = "reverseIntTestDataProvider")
    public void testReverseIntWithDataProvider(int firstNum, int expectedResult) {
        System.out.println("Reverse numbers - positive test case (data provider)");
            int actualResult = reverseNum.reverseInt(firstNum);

            Assert.assertEquals(actualResult, expectedResult, "False! Actual result didn't match expected");
    }

    @Test
    public void testReverseIntNegative() {
        System.out.println("Reverse number - negative test case");
        int actualResult = reverseNum.reverseInt(987);
        int expectedResult = 987;

        Assert.assertNotEquals(actualResult, expectedResult, "False! Actual result match expected");
    }

    @AfterTest
    public void endTest() {
        System.out.println("Test finished");
    }
}
