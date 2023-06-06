import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class AutomationExercises10 extends TestBase {
    /**
     * 1. Launch browser
     * 2. Navigate to url 'http://automationexercise.com'
     * 3. Verify that home page is visible successfully
     * 4. Scroll down to footer
     * 5. Verify text 'SUBSCRIPTION'
     * 6. Enter email address in input and click arrow button
     * 7. Verify success message 'You have been successfully subscribed!' is visible
     */

    @Test
    public void test01() {
        // Navigate to url 'http://automationexercise.com'
        driver.get("https://www.automationexercise.com");

        // Verify that home page is visible successfully
        String expectedUrl = "https://www.automationexercise.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);

        // Scroll down to footer
        //Verify text 'SUBSCRIPTION'
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement subText = driver.findElement(By.xpath("//*[@id=\"footer\"]/div[2]/div/div/div[2]/div/h2"));
        jse.executeScript("arguments[0].scrollIntoView(true);", subText);
        Assert.assertTrue(subText.isDisplayed());

        // Enter email address in input and click arrow button
        Faker faker=new Faker();
        Actions actions=new Actions(driver);
        String email = faker.internet().emailAddress();
        driver.findElement(By.xpath("//*[@id=\"susbscribe_email\"]")).sendKeys(email);
        actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"subscribe\"]/i"))).click().perform();

        // Verify success message 'You have been successfully subscribed!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"success-subscribe\"]/div")).isDisplayed());


    }
}
