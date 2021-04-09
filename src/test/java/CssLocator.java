import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

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

    @Test
    public void testRowsTable(){
        //how many rows in table
        List<WebElement> rows = wd.findElements(By.cssSelector("#country-table tr"));
        System.out.println("Rows in table: "+rows.size());

        WebElement firstLine = wd.findElement(By.cssSelector("tr:first-child"));
        System.out.println("First line in table: "+firstLine.getText());

        WebElement lastLine = wd.findElement(By.cssSelector("tr:last-child"));
        System.out.println("Last line in table: "+lastLine.getText());

        WebElement secondLine = wd.findElement(By.cssSelector("tr:nth-child(2)"));
        System.out.println("Second line in table: "+secondLine.getText());

        WebElement table =wd.findElement(By.cssSelector("#country-table"));
        table.findElement(By.cssSelector("tr"));
    }

    @Test
    public void testColumnsTable(){
        List<WebElement> columns = wd.findElements(By.cssSelector("tr:first-child td"));
        List<WebElement> columns1 = wd.findElements(By.cssSelector("table#country-table tr:first-child td"));
        System.out.println("All columns in table: "+ columns.size());

        List<WebElement> firstColumn = wd.findElements(By.cssSelector("td:first-child"));
        for (WebElement el:firstColumn) {
            System.out.println("First column in table: "+ el.getText());
        }

        List<WebElement>lastColumn = wd.findElements(By.cssSelector("td:last-child"));

        List<WebElement>secondColumn = wd.findElements(By.cssSelector("td:nth-child(2)"));
        for (int i=0; i<secondColumn.size(); i++){
            System.out.println("Second column in table: "+ (i+1)+" "+secondColumn.get(i).getText());

        }


    }
    @Test
    public void testCellsTable(){
        WebElement mexico = wd.findElement(By.cssSelector("tr:last-child td:last-child"));
        System.out.println("Mexico-->"+mexico.getText());

        WebElement canada = wd.findElement(By.cssSelector("tr:nth-child(3) td:last-child"));
        System.out.println("Canada-->"+canada.getText());
    }

    @AfterMethod
    public void tearDown(){
        wd.quit();
    }
}
