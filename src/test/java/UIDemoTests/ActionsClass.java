package UIDemoTests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ActionsClass extends UIBaseTest {

    @Test
    public void testTabs() {
        driver.get("https://business.twitter.com/start-advertising");

        String oldTab = driver.getWindowHandle();
        driver.findElement(By.linkText("Create an ad")).click();

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(1));

        Assert.assertEquals(driver.getTitle(), "Войти");

        driver.close();

        driver.switchTo().window(oldTab);
        Assert.assertEquals(driver.getTitle(), "Advertising");
    }

    @Test
    public void hoverTest() {
        driver.get("http://the-internet.herokuapp.com/hovers");
        WebElement firstElement = driver.findElement(By.cssSelector("div.figure:first-of-type"));
        actions.moveToElement(firstElement).perform();

        WebElement firstElementLink = firstElement.findElement(By.tagName("a"));
        firstElementLink.click();

        Assert.assertEquals(driver.getCurrentUrl(), "http://the-internet.herokuapp.com/users/1");
    }

    @Test
    public void dragAndDropTest() {
        driver.get("http://webdriveruniversity.com/Actions/index.html");
        WebElement from = driver.findElement(By.id("draggable"));
        WebElement to = driver.findElement(By.id("droppable"));

        actions.dragAndDrop(from, to).perform();

        Assert.assertEquals(to.getText(), "Dropped!");
    }

    @Test
    public void frameTest() {
        driver.get("http://the-internet.herokuapp.com/nested_frames");
        WebElement parentTopFrame = driver.findElement(By.name("frame-top"));
        driver.switchTo().frame(parentTopFrame);

        WebElement childTopLeftFrame = driver.findElement(By.name("frame-left"));
        driver.switchTo().frame(childTopLeftFrame);
        System.out.println(driver.findElement(By.tagName("body")).getText());
    }

    @Test
    public void iframeTest() {
        driver.get("http://demo.guru99.com/test/guru99home/");

        driver.switchTo().frame("a077aa5e");

        System.out.println("********We are switch to the iframe*******");
        driver.findElement(By.xpath("html/body/a/img")).click(); //Clicks the iframe

        System.out.println("*********We are done***************");

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.close();
        driver.switchTo().window(tabs.get(0));

        driver.switchTo().frame("a077aa5e");
        // driver.switchTo().defaultContent();
        WebElement javaCourseIcon = driver.findElement(By.xpath("//a[text()='JAVA']"));
        javaCourseIcon.click();
        Assert.assertEquals(driver.getTitle(), "Java Tutorial for Beginners: Learn Core Java Programming");
    }

    @Test
    public void jsExecutorTest2() {

        driver.get("http://demo.guru99.com/V4/");
        WebElement button = driver.findElement(By.name("btnLogin"));

        driver.findElement(By.name("uid")).sendKeys("mngr34926");
        driver.findElement(By.name("password")).sendKeys("amUpenu");
        //Perform Click on LOGIN button using JavascriptExecutor
        js.executeScript("arguments[0].click();", button);
    }

    @Test
    public void jsExecutorTest() {
        JavascriptExecutor js = (JavascriptExecutor)driver;

        driver.get("http://moneyboats.com/");

        js.executeScript("window.scrollBy(0,600)");
    }

    @Test
    public void jsExecutorTest3() {

        JavascriptExecutor js = (JavascriptExecutor)driver;
        driver.get("https://hard.rozetka.com.ua/monitors/c80089/");
        WebElement showMore = driver.findElement(By.cssSelector("span.show-more__text"));

        js.executeScript("arguments[0].scrollIntoView(true);", showMore);
        showMore.click();

    }

}
