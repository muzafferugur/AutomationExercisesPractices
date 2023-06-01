import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class AutomationExercises02 extends TestBase {
    /**
     * 1. Launch browser
     * 2. Navigate to url 'http://automationexercise.com'
     * 3. Verify that home page is visible successfully
     * 4. Click on 'Signup / Login' button
     * 5. Verify 'Login to your account' is visible
     * 6. Enter correct email address and password
     * 7. Click 'login' button
     * 8. Verify that 'Logged in as username' is visible
     * 9. Click 'Delete Account' button
     * 10. Verify that 'ACCOUNT DELETED!' is visible
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
        String correctEmail = "muzafferugur@example.com";
        String correctPassword = "123456*";
        driver.findElement(By.xpath("(//input[@placeholder='Email Address'])[1]")).sendKeys(correctEmail);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(correctPassword);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Verify that 'Logged in as username' is visible
        WebElement loggedInAsUsername = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
        Assert.assertTrue(loggedInAsUsername.isDisplayed());

        // Click 'Delete Account' button
        Actions actions = new Actions(driver);
        WebElement deleteAccountButton = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a"));
        actions.click(deleteAccountButton).build().perform();

        // Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement accountDeletedYazisi = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"));
        Assert.assertTrue(accountDeletedYazisi.isDisplayed());
    }

}
