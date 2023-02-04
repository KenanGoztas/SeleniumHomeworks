import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AmazonSearch {
    WebDriver driver = new ChromeDriver();

    @Before
    public void setup() throws InterruptedException {
        driver.get("http://www.amazon.com");
        driver.manage().window().maximize();
        //Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @After
    public void tearDown() {
        //driver.close();
    }

    @Test
    public void search() {
        WebElement searchElement =driver.findElement(By.xpath("//input[@type='text']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        searchElement.sendKeys("nutella");
        searchElement.submit();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));


        WebElement text1= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(text1.getText());



    }
}
