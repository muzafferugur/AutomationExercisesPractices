import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class AutomationExercises08 extends TestBase {
    /**
     * 1. Launch browser
     * 2. Navigate to url 'http://automationexercise.com'
     * 3. Verify that home page is visible successfully
     * 4. Click on 'Products' button
     * 5. Verify user is navigated to ALL PRODUCTS page successfully
     * 6. The products list is visible
     * 7. Click on 'View Product' of first product
     * 8. User is landed to product detail page
     * 9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
     */

    @Test
    public void test01() throws InterruptedException {
        // Navigate to url 'http://automationexercise.com'
        driver.get("https://www.automationexercise.com");

        // Verify that home page is visible successfully
        String expectedUrl = "https://www.automationexercise.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);

        // Click on 'Products' button
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")).click();

        // Verify user is navigated to ALL PRODUCTS page successfully
        WebElement allProductText= driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/h2"));
        Assert.assertTrue(allProductText.isDisplayed());

        // The products list is visible


        //Click on 'View Product' of first product
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1500);
        driver.findElement(By.xpath("(//a[text()='View Product'])[1]")).click();

        //  8. User is landed to product detail page
        System.out.println("User is " + driver.getTitle());

        //  9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='product-information']")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("//div[@class='product-information']")).getText());




    }
}
