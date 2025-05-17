import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;


public class ApiTest {

    @Test
    void getPostById_ShouldReturnCorrectTitle() {

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        given().when().get("/posts/1").then().statusCode(200).body("userId", equalTo(1));




    }

    @Test
    void getUserById_ShouldReturnCorrectName() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        given().when().get("/users/1").then().body("name", equalTo("Leanne Graham"));
    }

    @Test
    void testPostRequest() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        given().header("Content-type", "application/json").
                body("{\"title\": \"foo\", \"body\": \"bar\", \"userId\": 1}").
                when().post("/posts").then().statusCode(201);
    }

    @Test
    void test1() {

        Response response = given().
                when().get("https://jsonplaceholder.typicode.com/posts/2").
                then().statusCode(200).extract().response();

        int userId = response.path("userId");
        String title = response.path("title");

        System.out.println("userId: " + userId);
        System.out.println("title: " + title);

        assertEquals(1, userId);
        assertNotNull(title);
    }

    @Test
    void test2() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        given().when().get("/posts").then().statusCode(200).body("size()", greaterThan(0)).
                body("[0].userId", equalTo(1)).body("title", hasItem("qui est esse"));



    }


}
