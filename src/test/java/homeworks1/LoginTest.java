package homeworks1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

import java.security.Key;
import java.time.Duration;

public class LoginTest {

    WebDriver driver = new ChromeDriver();
    Actions action = new Actions(driver);

    @Before
    public void setup() throws InterruptedException {
//   Aşağıdaki manuel testcase’in steplerini otomate ediniz.
//     TESTCASE STEPLERİ:
//  1. Kullanıcı http://gcreddy.com/project/admin/login.php sayfasına gider.
        driver.get("http://www.gcreddy.com/project/admin/login.php");
        driver.manage().window().maximize();
        //Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void linkTest() throws InterruptedException {

//            2. Username textbox kutusuna kullanıcı adını girer.
        WebElement username = driver.findElement(By.name("username"));  // By.name
        username.sendKeys("gcreddy");
        Thread.sleep(3000);

//            3. Password textbox kutusuna kullanıcı şifresini girer.
        WebElement password = driver.findElement(By.cssSelector("input[type='password']")); // CSS yöntemi ile locate
        password.sendKeys("Temp@2020");
        Thread.sleep(3000);

//            4. Login butonuna tıklar.
        WebElement login = driver.findElement(By.cssSelector("button#tdb1")); // CSS yöntemi ile locate
        login.click();
        Thread.sleep(1000);
        // login.sendKeys(Keys.ENTER);
        // login.clear();

        WebElement loggedUsername = driver.findElement(By.xpath("//*[contains(text(),'gcreddy')]")); // XPATH yöntemi ile locate
        String name = loggedUsername.getText();
        System.out.println("loggedUsername = " + name);
        Thread.sleep(1000);
        Assert.assertTrue(name.contains("gcreddy"));

//            5. Sol menü bar üzerniden Customers sekmesine tıklar.
        WebElement costumers = driver.findElement(By.xpath("//h3[@id='ui-accordion-adminAppMenu-header-2']"));
        costumers.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//       ??????????? burasını çalıştıramadım.
//            6. Açılan alt menüden Customers linkine tıklar.
        WebElement costumer = driver.findElement(By.xpath("//a[@href='http://gcreddy.com/project/admin/customers.php']"));
        costumer.click();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //kısayol yaptım..
        // driver.get("http://gcreddy.com/project/admin/customers.php");

//            7. Sag menü kutusnudaki Edit butonuna tıklar.
        driver.findElement(By.xpath("//a[@id='tdb1']")).click();

//            8. Personal bilgileri içindeki Firstname textbox kutsuna ismini girer.
        driver.findElement(By.xpath("//input[@value='m']")).click();
        WebElement name1 = driver.findElement(By.xpath("//input[@name='customers_firstname']"));
        name1.clear();
        name1.sendKeys("kenan");

//            9. Personal bilgileri içindeki Lastname textbox kutsuna soyismini girer.
        WebElement lastName = driver.findElement(By.xpath("//input[@name='customers_lastname']"));
        lastName.clear();
        lastName.sendKeys("gggg");

//            10.Personal bilgileri içindeki Date of Birth textbox kutsuna doğum tarihini
//            girer.
        WebElement dateOfBirth = driver.findElement(By.name("customers_dob"));
        dateOfBirth.clear();
        dateOfBirth.sendKeys("01/01/2000");
        dateOfBirth.click();
//            11.Personal bilgileri içindeki E-Mail Address textbox kutsuna e-mail adresini
//            girer.
        WebElement emailAddress = driver.findElement(By.name("customers_email_address"));
        emailAddress.clear();
        emailAddress.sendKeys("name123g@gmail.com");
//            12.Company bilgileri içindeki Company name textbox kutusuna şirket ismini
//            girer.
        WebElement companyName = driver.findElement(By.name("entry_company"));
        companyName.clear();
        companyName.sendKeys("sirket");
//            13.Adres bilgileri içindeki Street textbox kutsuna sokak ismini girer.
        WebElement street = driver.findElement(By.name("entry_street_address"));
        street.clear();
        street.sendKeys("cumhuriyet");
//            14.Adres bilgileri içindeki Suburb textbox kutsuna belediye ismini girer.
        WebElement suburb = driver.findElement(By.name("entry_suburb"));
        suburb.clear();
        suburb.sendKeys("hürriyet");
//            15.Adres bilgileri içindeki Post Code textbox kutsuna posta kutusu numarasını
//            girer.
        WebElement postCode = driver.findElement(By.name("entry_postcode"));
        postCode.clear();
        postCode.sendKeys("010101");

//            16.Adres bilgileri içindeki City textbox kutsuna Şehir ismini girer.
        WebElement city = driver.findElement(By.name("entry_city"));
        city.clear();
        city.sendKeys("Stutgart");
//            17.Adres bilgileri içindeki State textbox kutsuna posta kutusu Eyalet ismini
//            girer.
        WebElement state = driver.findElement(By.name("entry_state"));
        state.clear();
        state.sendKeys("Baden-württemberg");
//            18.Adres bilgileri içindeki Country dropdown menüsünden ülkesini seçer.
        WebElement country = driver.findElement(By.name("entry_country_id"));
        //country.clear();
        country.sendKeys("Germany");
        country.click();

//            19.Contact bilgileri içindeki Telephone Number textbox kutsuna telefon
//            numarasını girer.
        WebElement telephone = driver.findElement(By.name("customers_telephone"));
        telephone.clear();
        telephone.sendKeys("12345678900");
//            20.Contact bilgileri içindeki Fax Number textbox kutsuna fax numarasını girer.
        WebElement fax = driver.findElement(By.name("customers_fax"));
        fax.clear();
        fax.sendKeys("987654321");
//            21.Options bilgileri içindeki Newsletter dropdown menüsünden abonelik
//            durumunu seçer.
        WebElement newsletter = driver.findElement(By.name("customers_newsletter"));
        newsletter.click();
//            22.Save butonuna tıklar.
        WebElement save = driver.findElement(By.xpath("(//span[@class='ui-button-text'])[1]"));
        save.click();
//            23.Sağ üst köşedeki SEARCH kutusuna kullanıcı ismini girer ve ENTER’a
//            basar.
        WebElement search = driver.findElement(By.xpath("//input[@name='search']"));
        search.sendKeys("kenan");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        search.sendKeys(Keys.ENTER);
        //action.sendKeys(Keys.ENTER); //neden çalışmıyor anlamadım


//            24.Tablodan çıkan kullanıcı ismi ve soy isminin doğruluğu teyit edilir.
        Assert.assertEquals(driver.findElement(By.xpath("(//td[@class='dataTableContent'])[2]")).getText(), "kenan");
        Assert.assertEquals(driver.findElement(By.xpath("(//td[@class='dataTableContent'])[1]")).getText(), "gggg");


        //silmek gerek, her kayıtta aynı email sorunu yaşıyorum
        WebElement delete1=driver.findElement(By.xpath("//span[text()='Delete']"));
        delete1.click();
        WebElement delete2=driver.findElement(By.xpath("//span[text()='Delete']"));
        delete2.click();

        WebElement controll= driver.findElement(By.xpath("//td[text()='Displaying ']"));
        Assert.assertTrue(controll.getText().contains("0"));

//            25.Sağ üst köşedeki Logoff tuşuna basılarak sayfadan çıkılır.
        WebElement logoff = driver.findElement(By.xpath("(//a[@class='headerLink'])[3]")); // XPATH yöntemi ile locate
        logoff.click();


    }
}





