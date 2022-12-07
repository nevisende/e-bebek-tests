import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class TestAutomation {
    private WebDriver driver;
    JavascriptExecutor js;
    String jsScript;

    @BeforeTest
    public void setupBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--disable-gpu",
                "--window-size=1920,1200",
                "--ignore-certificate-errors",
                "--disable-extensions",
                "--no-sandbox",
                "--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        driver.manage().window().fullscreen();

        js = (JavascriptExecutor) driver;
        jsScript = "arguments[0].click();";
    }

    @AfterTest
    public void quitBrowser(){
        driver.quit();
    }

    @Test
    public void addProduct(){
        // 1-Anasayfayı aç

        driver.get("https://www.e-bebek.com/");

        // 1.1 Popupı kapat

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        WebElement closeBtn = new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ins-close-button-c2703")));
        js.executeScript(jsScript, closeBtn);


        // 2-Arama çubuğuna "biberon" yaz

        WebElement searchBox =  new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id("txtSearchBox")));
        searchBox.sendKeys("biberon");


        // 3-Arama yap

        searchBox.sendKeys(Keys.ENTER);


        // 4-İlk ürüne tıkla

        String xPathOfFirsProductLink = "/html/body/app-root/cx-storefront/main/cx-page-layout/cx-page-slot[3]/eb-product-list/div/section/div/div/div/div[2]/eb-product-scroll/div/div/eb-product-list-item[1]/div/eb-generic-link/a";
        WebElement firstBiberon = new WebDriverWait(driver,Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPathOfFirsProductLink)));
        firstBiberon.click();


        // 5- "Sepete Ekle" butonuna tıkla

        WebElement addToCartButton = new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"addToCartBtn\"]")));
        js.executeScript(jsScript, addToCartButton);


        // 6- "Sepeti Gör" butonuna tıkla

        WebElement showCartBtn = new WebDriverWait(driver,Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"btnShowCart\"]")));
        js.executeScript(jsScript, showCartBtn);


        /* 7- Ürünün sepete eklendiği kontrol et
                (Test algoritması): Browserda ilk kez site ziyaret edildiğinden sepette bir ürün yoktur
                 ve eb-cart-item-list elementi de yok yani bu element varsa ürün eklenmiş demektir.
        */

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        boolean isThereAnyProduct = driver.findElement(By.cssSelector("eb-cart-item-list")).isEnabled();

        assert String.valueOf(isThereAnyProduct).equals("true");
        System.out.println("Ürün başarı ile sepete eklenmiştir");
    }
}
