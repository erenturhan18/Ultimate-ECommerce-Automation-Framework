package apiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C01_GetRequest {

    @Test
    public void test01(){
        String url = "https://jsonplaceholder.typicode.com/posts/2";
        Response response = RestAssured.get(url);

        System.out.println("Status code: " + response.getStatusCode());
        System.out.println("Content Type: " + response.getContentType());

        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200, "Status code 200 olmalıydı");

        Assert.assertEquals(response.path("title"), "qui est esse");
        Assert.assertEquals(response.path("userId").toString(), "1");
        System.out.println("Doğrulamalar başarıyla tamamlandı!");



    }


}
