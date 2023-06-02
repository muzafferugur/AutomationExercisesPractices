import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class AutomationExercises06 extends TestBase {
    /**
     * 1. Launch browser
     * 2. Navigate to url 'http://automationexercise.com'
     * 3. Verify that home page is visible successfully
     * 4. Click on 'Contact Us' button
     * 5. Verify 'GET IN TOUCH' is visible
     * 6. Enter name, email, subject and message
     * 7. Upload file
     * 8. Click 'Submit' button
     * 9. Click OK button
     * 10. Verify success message 'Success! Your details have been submitted successfully.' is visible
     * 11. Click 'Home' button and verify that landed to home page successfully
     */

    @Test
    public void test01() {
        // Navigate to url 'http://automationexercise.com'
        driver.get("https://www.automationexercise.com");

        // Verify that home page is visible successfully
        String expectedUrl = "https://www.automationexercise.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);

        // Click on 'Contact Us' button
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a")).click();

        // Verify 'GET IN TOUCH' is visible
        WebElement actualGetInTouch = driver.findElement(By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/h2"));
        Assert.assertTrue(actualGetInTouch.isDisplayed());

        // Enter name, email, subject and message
        Actions actions = new Actions(driver);
        Faker faker = new Faker();

        String name = faker.name().fullName();
        String email = faker.internet().emailAddress();
        String subject = faker.lorem().sentence();
        String message = faker.lorem().paragraph();

        WebElement nameElement = driver.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[1]/input"));
        actions.click(nameElement).sendKeys(name)
                .sendKeys(Keys.TAB).sendKeys(email)
                .sendKeys(Keys.TAB).sendKeys(subject)
                .sendKeys(Keys.TAB).sendKeys(message)
                .sendKeys(Keys.ENTER).perform();

    }
}
