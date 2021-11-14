package TestNGDemoTests;

import lesson17TestNG.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

public class CalculatorTest extends BaseTest {

    Calculator calculator;

    @BeforeClass
    public void initCalculator() {
        System.out.println("I run before CLASS");
        calculator = new Calculator();
    }

    /*@DataProvider(name = "sumTestDataProvider")
    public Object[][] sumTests() {
        return new Object[][]{
                {3, 5, 8},
                {0, 5, 5},
                {-1, 5, 4}
        };
    }
    @Test(dataProvider = "sumTestDataProvider")
    public void testSumWithDataProvider(int firstNum, int secondNum, int expectedResult) {
        System.out.println("All sum test cases");
        int actualResult = calculator.sum(firstNum, secondNum);
        Assert.assertEquals(actualResult, expectedResult, "Actual result didn't match expected");
    }*/

    @Test
    public void testSum() {
        System.out.println("First sum test case");
        int expectedResult = 8;
        int actualResult = calculator.sum(3,5);

        Assert.assertEquals(actualResult, expectedResult, "Actual result didn't match expected");
    }

    @Test
    public void testSum1() {
        System.out.println("Second sum test case");
        int expectedResult = 5;
        int actualResult = calculator.sum(0,5);

        Assert.assertEquals(actualResult, expectedResult, "Actual result didn't match expected");
    }

    @Test
    public void testSum2() {
        System.out.println("Third sum test case");
        int expectedResult = 4;
        int actualResult = calculator.sum(-1,5);

        Assert.assertEquals(actualResult, expectedResult, "Actual result didn't match expected");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("I run after CLASS");
    }
}
