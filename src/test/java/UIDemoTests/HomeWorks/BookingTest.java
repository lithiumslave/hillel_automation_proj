package UIDemoTests.HomeWorks;

import UIDemoTests.UIBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class BookingTest extends UIBaseTest {
    private final String searchCity = "Paris";
    private final String startMonth = "November";
    private final String startYear = "2021";
    private final String startDay = "25";
    private final String endMonth = "December";
    private final String endYear = "2021";
    private final String endDay = "5";

    private final String languageIcon = "//button[@data-modal-id='language-selection']";
    private final String englishLanguageButton = "//a[@data-lang='en-gb']";
    private final String searchField = "//input[@id='ss']";
    private final String checkInOutField = "//div[@class='xp__dates xp__group']";
    private final String nextDatepickerButton = "//div[@data-bui-ref='calendar-next']";
    private final String searchButton = ".xp__button";
    private final String monthSection = ".bui-calendar__wrapper";
    private final String cityInSearchField = "ss";
    private final String startDayInSearchField = "//div[@data-placeholder='Check-in date']";
    private final String endDayInSearchField = "//div[@data-placeholder='Check-out date']";
    private final String superbReviewScore = "//*[@data-filters-group='review_score']//div[@data-filters-item='review_score:review_score=90']";
    private final String scoresOnThePage = "div[aria-label^='Scored']";

    @Test
    public void testMainFeatures() throws InterruptedException {
        driver.get("https://www.booking.com");
        clickOnElementByXpath(languageIcon);
        clickOnElementByXpath(englishLanguageButton);
        sendKeysToObjectByXpath(searchCity, searchField);
        clickOnElementByXpath(checkInOutField);
        //-------------VALIDATION-------------
        //clickOnElementByXpath(nextDatepickerButton);
        //------------------------------------
        clickOnSelectedDayInDatepicker(startMonth, startYear, startDay);
        clickOnSelectedDayInDatepicker(endMonth, endYear, endDay);
        clickOnElementByCssSelector(searchButton);

        Assert.assertTrue(driver.findElement(By.id(cityInSearchField)).getAttribute("placeholder").equals(searchCity));
        Assert.assertTrue(driver.findElement(By.xpath(startDayInSearchField)).getText().contains(startDay + " " + startMonth + " " + startYear));
        Assert.assertTrue(driver.findElement(By.xpath(endDayInSearchField)).getText().contains(endDay + " " + endMonth + " " + endYear));

        clickOnElementByXpath(superbReviewScore);
        Thread.sleep(3000);
        //wait.until(ExpectedConditions.elementToBeClickable(superbReviewScore));
        checkIfScoresOnPageAreMoreThanNine();
    }

    private void clickOnSelectedDayInDatepicker(String month, String year, String day) {
        List<WebElement> months = driver.findElements(By.cssSelector(monthSection));

        for (WebElement startMonthActual : months) {
            if (startMonthActual.findElement(By.cssSelector(".bui-calendar__month")).getText().equals(month + " " + year)) {
                List<WebElement> days = startMonthActual.findElements(By.cssSelector(".bui-calendar__date"));
                for (WebElement startDayActual : days) {
                    if (startDayActual.getText().equals(day)) {
                        startDayActual.click();
                        break;
                    }
                }
            }
        }
    }

    private void checkIfScoresOnPageAreMoreThanNine() {
        List<WebElement> scores = driver.findElements(By.cssSelector(scoresOnThePage));
        double minimalScoreExpected = 9.0;

        for (WebElement score : scores) {
            Assert.assertTrue(Double.parseDouble(score.getText()) >= minimalScoreExpected);
        }
    }

    private void clickOnElementByCssSelector(String cssSelector) {
        WebElement object = driver.findElement(By.cssSelector(cssSelector));
        object.click();
    }

    private void clickOnElementByXpath(String xpath) {
        WebElement object = driver.findElement(By.xpath(xpath));
        object.click();
    }

    private void sendKeysToObjectByXpath(String key, String objXpath) {
        WebElement object = driver.findElement(By.xpath(objXpath));
        object.sendKeys(key);
    }

    /*protected void clickNextCalendarUntilExpectedDateExist(WebElement nextDatepickerButton, String month, String year) {
        List<WebElement> actualMonth = driver.findElements(By.cssSelector(".bui-calendar__wrapper"));
       *//* do {

        } while ()*//*
        for (WebElement startMonthActual : actualMonth) {
            WebElement actualCurrentMonth = startMonthActual.findElement(By.cssSelector(".bui-calendar__month"));

            if (actualCurrentMonth.getText().equals(month + " " + year)) {
                break;
            } else {
                System.out.println("YES, CLICK, BLIATSKAYA MASHINA");
            }
        }
    }*/
}
