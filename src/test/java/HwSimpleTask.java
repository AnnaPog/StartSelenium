import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.xml.bind.Element;
import java.util.List;
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
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('footer').style.display='none';");

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


        WebElement getName = wd.findElement(By.id("name"));
        SelectElementTest(fullName, getName);

        WebElement getEmail = wd.findElement(By.id("email"));
        SelectElementTest(email, getEmail);

        WebElement getCurrentAddress = wd.findElement(By.id("currentAddress"));
        SelectElementTest(currentAddress, getCurrentAddress);

        WebElement getPermanentAddress = wd.findElement(By.id("permanentAddress"));
        SelectElementTest(permanentAddress, getPermanentAddress);


        SelectElementFromList(fullName, email, currentAddress, permanentAddress);
    }

    @Test

    public void SelectElementTest(WebElement el1, WebElement el2){
        String text = el2.getText();
        System.out.println(text);

        Assert.assertTrue(text.contains(el1.getText()));
    }

    public void SelectElementFromList(WebElement e, WebElement e1, WebElement e2, WebElement e3){
        List <WebElement> elements = wd.findElements(By.tagName("p"));
        System.out.println(elements.size()+" elements");

        WebElement el = elements.get(0);
        String elText = el.getText();
        System.out.println(elText);

        WebElement el1 = elements.get(1);
        String el1Text = el1.getText();
        System.out.println(el1Text);

        WebElement el2 = elements.get(2);
        String el2Text = el2.getText();
        System.out.println(el2Text);

        WebElement el3 = elements.get(3);
        String el3Text = el3.getText();
        System.out.println(el3Text);

        Assert.assertTrue(elText.contains(e.getText()));
        Assert.assertTrue(el1Text.contains(e1.getText()));
        Assert.assertTrue(el2Text.contains(e2.getText()));
        Assert.assertTrue(el3Text.contains(e3.getText()));

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
