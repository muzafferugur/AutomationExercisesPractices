import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class AutomationExercises11 extends TestBase {
    /**
     * 1. Launch browser
     * 2. Navigate to url 'http://automationexercise.com'
     * 3. Verify that home page is visible successfully
     * 4. Click 'Cart' button
     * 5. Scroll down to footer
     * 6. Verify text 'SUBSCRIPTION'
     * 7. Enter email address in input and click arrow button
     * 8. Verify success message 'You have been successfully subscribed!' is visible
     */

    @Test
    public void test01() {
        // Navigate to url 'http://automationexercise.com'
        driver.get("https://www.automationexercise.com");

        // Verify that home page is visible successfully
        String expectedUrl = "https://www.automationexercise.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
        // Click 'Cart' button
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a")).click();
        // Scroll down to footer
        Actions actions=new Actions(driver);
        WebElement footerSD = driver.findElement(By.xpath("//div[@class='footer-widget']"));
        actions.moveToElement(footerSD).perform();
        // Verify text 'SUBSCRIPTION'
        WebElement subText = driver.findElement(By.xpath("/html/body/footer/div[1]/div/div/div[2]/div/h2"));
        Assert.assertTrue(subText.isDisplayed());
        // Enter email address in input and click arrow button
        Faker faker =new Faker();
        String email = faker.internet().emailAddress();
        driver.findElement(By.xpath("//*[@id=\"susbscribe_email\"]")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id=\"subscribe\"]/i")).click();
        // Verify success message 'You have been successfully subscribed!' is visible
        WebElement successMsg = driver.findElement(By.xpath("//*[@id=\"success-subscribe\"]"));
        Assert.assertTrue(successMsg.isDisplayed());
    }
}
