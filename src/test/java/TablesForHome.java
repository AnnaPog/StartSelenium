import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TablesForHome {
    WebDriver wd;

    @BeforeMethod
    public void precondition(){
        wd = new ChromeDriver();
        wd.navigate().to("https://www.w3schools.com/css/css_table.asp");
        wd.manage().window().maximize();
    }

    @Test
    public void testForTableRows(){
        List<WebElement> rows = wd.findElements(By.cssSelector("#customers tr"));
        System.out.println("How many rows in the table? "+rows.size()+" rows");

        WebElement secondLine = wd.findElement(By.cssSelector("#customers tr:nth-child(2)"));
        System.out.println("Row 2 in the table : "+ secondLine.getText());

        WebElement seventhLine = wd.findElement(By.cssSelector("#customers tr:nth-child(7)"));
        System.out.println("Row 7 in the table : "+ seventhLine.getText());

    }

    @Test
    public void testForTableColumns(){
        List<WebElement> columns = wd.findElements(By.cssSelector("#customers tr:first-child th"));
        System.out.println("How many columns in table with data? "+columns.size());

        List<WebElement> countryColumn = wd.findElements(By.cssSelector("#customers td:last-child"));
        System.out.println("Country column in table : ");
        for (WebElement el:countryColumn){
            System.out.println(el.getText());
        }
    }

    @Test
    public void testForTableCells(){
        WebElement HelenBennett = wd.findElement(By.cssSelector("#customers tr:nth-child(6) td:nth-child(2)"));
        System.out.println(HelenBennett.getText());

        WebElement italia = wd.findElement(By.cssSelector("#customers tr:last-child td:last-child"));
        System.out.println(italia.getText());
    }

    @AfterMethod
    public void tearDown(){
        wd.quit();
    }
}
