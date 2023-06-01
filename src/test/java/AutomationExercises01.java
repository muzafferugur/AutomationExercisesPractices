import utilities.TestBase;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Date;
import java.util.Random;

public class AutomationExercises01 extends TestBase {

     /**
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and email address
7. Click 'Signup' button
8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
9. Fill details: Title, Name, Email, Password, Date of birth
10. Select checkbox 'Sign up for our newsletter!'
11. Select checkbox 'Receive special offers from our partners!'
12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
13. Click 'Create Account button'
14. Verify that 'ACCOUNT CREATED!' is visible
15. Click 'Continue' button
16. Verify that 'Logged in as username' is visible
17. Click 'Delete Account' button
18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
     */

    @Test
    public void test01() throws InterruptedException {

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


        // Fill details: Title, Name, Email, Password, Date of birth
        Actions actions = new Actions(driver);
        Faker faker = new Faker();
        String fakeMail = faker.internet().emailAddress();
        String fakeName = faker.name().firstName();

        WebElement userName = driver.findElement(By.xpath(" //input[@name='name']"));
        actions.click(userName).sendKeys(fakeName).sendKeys(Keys.TAB).sendKeys(fakeMail).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        // Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccountInfo = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(enterAccountInfo.isDisplayed());

        WebElement mrTitleButton = driver.findElement(By.xpath("//input[@value='Mr']"));

        if (!mrTitleButton.isSelected()) {
            mrTitleButton.click();
        }


        Thread.sleep(2000);
        String fakePassword = faker.internet().password();
        actions.sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(fakePassword)
                .sendKeys(Keys.TAB)
                .sendKeys("9")
                .sendKeys(Keys.TAB)
                .sendKeys("October"+Keys.ENTER)
                .sendKeys(Keys.TAB)
                .sendKeys("1995"+Keys.ENTER)
                .build().perform();

        Thread.sleep(2000);
        // Select checkbox 'Sign up for our newsletter!'
        // Select checkbox 'Receive special offers from our partners!'
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement checkBox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        jse.executeScript("arguments[0].scrollIntoView(true);", checkBox1);

        JavascriptExecutor jse0 = (JavascriptExecutor) driver;
        WebElement checkBox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        jse.executeScript("arguments[0].scrollIntoView(true);", checkBox2);
        Thread.sleep(3000);

        if (!checkBox1.isSelected()) {
            checkBox1.click();
        }

        Thread.sleep(3000);
        if (!checkBox2.isSelected()) {
            checkBox2.click();
        }
        Thread.sleep(1500);
        // Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        // Click 'Create Account button'
        JavascriptExecutor jse1 = (JavascriptExecutor) driver;
        WebElement name = driver.findElement(By.xpath("//input[@id='first_name']"));
        jse.executeScript("arguments[0].scrollIntoView(true);", name);
        actions.click(name).sendKeys(fakeName)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.company().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB)
                .sendKeys("Canada" + Keys.TAB)
                .sendKeys("Turkey" + Keys.TAB)
                .sendKeys("MyCity" + Keys.TAB)
                .sendKeys("12456" + Keys.TAB)
                .sendKeys(faker.phoneNumber().phoneNumber())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        // Verify that 'ACCOUNT CREATED!' is visible
        WebElement accountCreatedYazisi = driver.findElement(By.xpath("//b[text()='Account Created!']"));
        Assert.assertTrue(accountCreatedYazisi.isDisplayed());

        // Click 'Continue' button
        WebElement continueButton = driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
        actions.click(continueButton).build().perform();

        // Çıkan reklamı kapat
/*
        WebElement iframeElementi = driver.findElement(By.xpath("//iframe[@id='ad_iframe']"));
        driver.switchTo().frame(iframeElementi);

        Thread.sleep(2000);
        WebElement closeTusu = driver.findElement(By.xpath("//span[@class='ns-710zx-e-16']"));
        actions.click(closeTusu).build().perform();
        driver.switchTo().defaultContent();

 */

        // Verify that 'Logged in as username' is visible
        WebElement loggedInAsUsername = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
        Assert.assertTrue(loggedInAsUsername.isDisplayed());

        // Click 'Delete Account' button
        WebElement deleteAccountButton = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a"));
        actions.click(deleteAccountButton).build().perform();

        // Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement accountDeletedYazisi = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"));
        Assert.assertTrue(accountDeletedYazisi.isDisplayed());
    }
}
