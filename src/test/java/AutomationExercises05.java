import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class AutomationExercises05 extends TestBase {
    /**
     * 1. Launch browser
     * 2. Navigate to url 'http://automationexercise.com'
     * 3. Verify that home page is visible successfully
     * 4. Click on 'Signup / Login' button
     * 5. Verify 'New User Signup!' is visible
     * 6. Enter name and already registered email address
     * 7. Click 'Signup' button
     * 8. Verify error 'Email Address already exist!' is visible
     */

    @Test
    public void test01() {
        // Navigate to url 'http://automationexercise.com'
        driver.get("https://www.automationexercise.com");

        // Verify that home page is visible successfully
        String expectedUrl = "https://www.automationexercise.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);

        // Click on 'Signup / Login' button
        WebElement signInLogInButton = driver.findElement(By.xpath(" //a[@href='/login']"));
        signInLogInButton.click();

        // Verify 'New User Signup!' is visible
        WebElement newUserSignup = driver.findElement(By.xpath(" //h2[text()='New User Signup!']"));
        Assert.assertTrue(newUserSignup.isDisplayed());

        // Enter name and already registered email address
        String registeredEmail = "muzafferugur2@example.com";
        String userName = "muzaffer";
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]")).sendKeys(userName);
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")).sendKeys(registeredEmail);

        // Click 'Signup' button
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button")).click();

        // Verify error 'Email Address already exist!' is visible
        WebElement errorMessage= driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/p"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }
}
