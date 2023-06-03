import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class AutomationExercises07 extends TestBase {
    /**
     * 1. Launch browser
     * 2. Navigate to url 'http://automationexercise.com'
     * 3. Verify that home page is visible successfully
     * 4. Click on 'Test Cases' button
     * 5. Verify user is navigated to test cases page successfully
     */

    @Test
    public void name() {

        // Navigate to url 'http://automationexercise.com'
        driver.get("https://www.automationexercise.com");

        // Verify that home page is visible successfully
        String expectedUrl = "https://www.automationexercise.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);

        // Click on 'Test Cases' button
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")).click();

        // Verify user is navigated to test cases page successfully
        WebElement testCasePage=driver.findElement(By.xpath("//*[@id=\"form\"]/div/div[1]/div/h2/b"));
        Assert.assertTrue(testCasePage.isDisplayed());

    }
}
