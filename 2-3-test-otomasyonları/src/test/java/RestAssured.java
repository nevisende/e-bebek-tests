import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestAssured {
    @Test
    public void homePageGetStatus(){
        int statusCode = given().
                get("https://www.e-bebek.com/").
                statusCode();

        Assert.assertEquals(statusCode , 200,
                "Başarısız");

        System.out.println("Başarılı: Home page'e get isteği");
    }

    @Test
    public void addingProductPostStatus(){
        int statusCode = given().
                post("https://api2.e-bebek.com/ebebekwebservices/v2/ebebek/users/anonymous/carts/d521ca16-31c0-411d-9a19-53f2f638f133/entries?lang=tr&curr=TRY").
                statusCode();

        Assert.assertEquals(statusCode , 200,
                "Başarısız");

        System.out.println("Başarılı: Bir ürünü sepete eklemedeki post isteği");
    }
}
