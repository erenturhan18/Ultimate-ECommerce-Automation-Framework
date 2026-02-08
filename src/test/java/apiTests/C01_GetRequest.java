package apiTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class C01_GetRequest {

    @Test
    public void test01() {
        String url = "https://jsonplaceholder.typicode.com/posts/2";
        given()
                .baseUri(url)
                .header("Content-Type","applicatio/json")
                .when()
                    .get()
                .then()
                    .assertThat()
                    .statusCode(200)
                    .contentType("application/json")
                    .body("title",equalTo("qui est esse"))
                    .body("userId",equalTo(1))
                    .log().all();
        System.out.println("Profesyonel BDD doğrulamaları başarıyla tamamlandı!");




    }


}
