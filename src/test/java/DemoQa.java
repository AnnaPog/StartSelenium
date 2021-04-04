import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class DemoQa {
        WebDriver wd;

        @BeforeMethod
        public void precondition(){
            wd = new ChromeDriver();
            wd.navigate().to("https://demoqa.com/text-box");
            wd.manage().window().maximize();
            wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            JavascriptExecutor js = (JavascriptExecutor) wd;
            js.executeScript("document.querySelector('footer').style.display='none';");
        }


        //@Test(enabled = false)
        @Test
        public void fillForm() {
            String name = "Vasia Pupkin";
            String email = "vasiapup@gmail.com";
            String currentAddress = "Tel Aviv";
            String permanentAddress = "Beer Sheva";

            fillFieldByLocator(By.id("userName"), name);
            fillFieldByLocator(By.id("userEmail"), email);
            fillFieldByLocator(By.id("currentAddress"), currentAddress);
            fillFieldByLocator(By.id("permanentAddress"), permanentAddress);
            wd.findElement(By.id("submit")).click();

            Assert.assertTrue(takeText(By.id("name")).contains(name));
            Assert.assertTrue(takeText(By.id("email")).contains(email));
            //Assert.assertTrue(takeText(By.xpath("//p[@id = 'currentAddress']")).contains(currentAddress));
            List<WebElement> items = wd.findElements(By.className("mb-1"));
            Assert.assertTrue(items.get(2).getText().contains(currentAddress));
            Assert.assertTrue(items.get(3).getText().contains(permanentAddress));
        }

        public String takeText(By locator){
            return wd.findElement(locator).getText();
        }

        public void fillFieldByLocator(By locator, String text){
            WebElement el = wd.findElement(locator);
            el.click();
            el.clear();
            el.sendKeys(text);
        }

        @AfterMethod
    public void tearDown(){
            wd.quit();
        }
}
