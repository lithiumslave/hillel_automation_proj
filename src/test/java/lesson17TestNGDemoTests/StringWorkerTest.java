package lesson17TestNGDemoTests;

import lesson17TestNG.StringWorker;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StringWorkerTest extends BaseTest {

    StringWorker worker;

    @BeforeClass
    public void initObject() {
        System.out.println("I run before CLASS");
        worker = new StringWorker();
    }

    @Test
    public void positiveTestStringConcatenation() {
        System.out.println("Concat positive test");
        String expected = "Hello world";
        Assert.assertEquals(worker.concat("Hello ", "world"), expected, "The strings are not equal!");
    }

    @Test
    public void negativeTestStringConcatenation() {
        System.out.println("Concat negative test");
        String expected = "Hello world";
        Assert.assertNotEquals(worker.concat("Hello ", "world!"), expected, "The strings are not equal!");
    }
}