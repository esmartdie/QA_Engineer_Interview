package googleSearch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import utility.BrowserCaptureImage;
import utility.Highlighter;

import java.io.IOException;
import java.time.Duration;

public class automationgoogleSearch {
    private WebDriver driver;
    private WebDriverWait wait;
    private String yearCheck;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void googleConnect() {
        driver.get("https://www.google.com/");
        wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
        WebElement acceptAll = driver.findElement(By.id("L2AGLb"));
        Highlighter.highlightElement(driver, acceptAll);
        acceptAll.click();
        System.out.println("Conexion exitosa a la web de Google");

    }

    @Test
    public void googleSearch(){
        WebElement searchBox = driver.findElement(By.id("APjFqb"));
        searchBox.sendKeys("automatización");
        Highlighter.highlightElement(driver, searchBox);
        driver.findElement(By.name("btnK")).submit();
        System.out.println("Busqueda exitosa en Google");

    }
    @Test
    public void wikipediaCheck () throws IOException {

        /*--------Encontrar en los resultados la busqueda que contenga wikipedia-------*/
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href*='wikipedia']")));
        driver.findElement(By.cssSelector("a[href*='wikipedia']")).click();
        /*--------Eliminar del parrafo 8 todos los caracteres que no sean numeros-------*/
        yearCheck = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/p[8]"))
                .getText().replaceAll("[^\\d]", "");
        /*--------comprobación del web scraping------*/
        String yearExpected="1801";
        Assert.assertEquals(yearCheck,yearExpected);
        BrowserCaptureImage.captureImage(driver);
        System.out.println("Comprobación realizada satifactoriamente");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
