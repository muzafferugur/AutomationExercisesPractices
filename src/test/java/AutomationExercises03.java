import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class AutomationExercises03 extends TestBase {

    /**
     * 1. Launch browser
     * 2. Navigate to url 'http://automationexercise.com'
     * 3. Verify that home page is visible successfully
     * 4. Click on 'Signup / Login' button
     * 5. Verify 'Login to your account' is visible
     * 6. Enter incorrect email address and password
     * 7. Click 'login' button
     * 8. Verify error 'Your email or password is incorrect!' is visible
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

        // Verify 'Login to your account' is visible
        String expectedText = "Login to your account";
        String actualText = driver.findElement(By.xpath("//h2[text()='Login to your account']")).getText();
        Assert.assertEquals(expectedText, actualText);

        // Enter correct email address and password
        String incorrectEmail = "muzafferugur1@example.com";
        String incorrectPassword = "123456789";
        driver.findElement(By.xpath("(//input[@placeholder='Email Address'])[1]")).sendKeys(incorrectEmail);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(incorrectPassword);

        // Click on 'login' button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Verify error 'Your email or password is incorrect!' is visible
        String expectedError = "Your email or password is incorrect!";
        String actualError = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p")).getText();
        Assert.assertEquals(expectedError, actualError);


    }
}
