import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CssLocator {
    WebDriver wd;

    @BeforeMethod
    public void precondition() {
        wd = new ChromeDriver();
        wd.navigate().to("file:///Users/annapogrebinskaya/Downloads/index.html");
        wd.manage().window().maximize();
    }

    @Test
    public void testItem(){
        wd.findElement(By.cssSelector("#nav ul li:first-child"));
        wd.findElement(By.cssSelector("#nav ul li:last-child"));
        wd.findElement(By.cssSelector("#nav ul li:nth-child(2n)"));
    }

    @AfterMethod
    public void tearDown(){
        wd.quit();
    }
}
