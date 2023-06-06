import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class AutomationExercises09 extends TestBase {
    /**
     * 1. Launch browser
     * 2. Navigate to url 'http://automationexercise.com'
     * 3. Verify that home page is visible successfully
     * 4. Click on 'Products' button
     * 5. Verify user is navigated to ALL PRODUCTS page successfully
     * 6. Enter product name in search input and click search button
     * 7. Verify 'SEARCHED PRODUCTS' is visible
     * 8. Verify all the products related to search are visible
     */

    @Test
    public void test01() {
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

        // Enter product name in search input and click search button
        driver.findElement(By.xpath("//*[@id=\"search_product\"]")).sendKeys("men tshirt");
        driver.findElement(By.xpath("//*[@id=\"submit_search\"]")).click();

        // Verify 'SEARCHED PRODUCTS' is visible
        WebElement searchedProductsText= driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/h2"));
        Assert.assertTrue(searchedProductsText.isDisplayed());

        // Verify all the products related to search are visible


    }
}
