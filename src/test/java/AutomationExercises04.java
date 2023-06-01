import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class AutomationExercises04 extends TestBase {

    /**
     * 1. Launch browser
     * 2. Navigate to url 'http://automationexercise.com'
     * 3. Verify that home page is visible successfully
     * 4. Click on 'Signup / Login' button
     * 5. Verify 'Login to your account' is visible
     * 6. Enter correct email address and password
     * 7. Click 'login' button
     * 8. Verify that 'Logged in as username' is visible
     * 9. Click 'Logout' button
     * 10. Verify that user is navigated to login page
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
        String correctEmail = "muzafferugur2@example.com";
        String correctPassword = "123456*";
        driver.findElement(By.xpath("(//input[@placeholder='Email Address'])[1]")).sendKeys(correctEmail);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(correctPassword);

        // Click on 'login' button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Verify that 'Logged in as username' is visible
        WebElement loggedInAsUsername = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
        Assert.assertTrue(loggedInAsUsername.isDisplayed());

        // Click on 'Logout' button
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();

        // Verify that user is navigated to login page
        String currentURL = driver.getCurrentUrl();
        String loginPageURL = "http://automationexercise.com/login";

        if (currentURL.equals(loginPageURL)) {
            System.out.println("Kullanıcı giriş sayfasına yönlendirildi.");
        } else {
            System.out.println("Kullanıcı giriş sayfasına yönlendirilmedi.");
        }



    }
}
