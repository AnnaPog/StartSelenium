import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HwSimpleTask {
    WebDriver wd;

    @BeforeMethod
    public void precondition(){
        wd = new ChromeDriver();
        wd.navigate().to("https://demoqa.com/text-box");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void fillForm(){
        WebElement fullName = wd.findElement(By.id("userName"));
        WebElement email = wd.findElement(By.id("userEmail"));
        WebElement currentAddress = wd.findElement(By.id("currentAddress"));
        WebElement permanentAddress = wd.findElement(By.id("permanentAddress"));
        WebElement button = wd.findElement(By.id("submit"));

        String text = "Vasia Pupkin";
        fillField(fullName, text);

        text = "vasiapup@gmail.com";
        fillField(email, text);

        text = "Tel Aviv";
        fillField(currentAddress, text);

        text = "Beer Sheva";
        fillField(permanentAddress, text);

        button.click();
    }

    public void fillField(WebElement el, String text){
        el.click();
        el.clear();
        el.sendKeys(text);
    }

    @AfterMethod
    public void tearDown(){
      //  wd.quit();
    }
}
