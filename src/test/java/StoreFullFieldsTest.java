import io.restassured.http.ContentType;
import org.junit.jupiter.api.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StoreFullFieldsTest {

    static long orderId = 863464120;

    @BeforeAll
    static void setup() {
        baseURI = "https://petstore.swagger.io/v2";
    }

    @Test
    @Order(1)
    @DisplayName("Создание заказа со всеми параметрами")
    void createOrderWithAllFields() {
        String orderJson = """
                {
                "id": 863464120,
                  "petId": 1,
                  "quantity": 3,
                  "shipDate": "2025-05-23T02:16:18.817Z",
                  "status": "placed",
                  "complete": true
                  }
                """;

        given()
                .contentType(ContentType.JSON)
                .body(orderJson)
                .when()
                .post("/store/order")
                .then()
                .statusCode(200)
                .body("id", equalTo((int) 863464120))
                .body("petId", equalTo(1))
                .body("quantity", equalTo(3))
                .body("shipDate", startsWith("2025-05-23T02:16:18.817"))
                .body("status", equalTo("placed"))
                .body("complete", equalTo(true));
    }


    @Test
    @Order(2)
    @DisplayName("Проверка всех полей ответа GET /store/order/{orderId}")
    void checkOrderFields() {
        given()
                .pathParams("orderId", orderId)
                .when()
                .get("/store/order/{orderId}")
                .then()
                .statusCode(200)
                .body("id", equalTo((int) 863464120))
                .body("petId", equalTo(1))
                .body("quantity", equalTo(3))
                .body("shipDate", startsWith("2025-05-23T02:16:18.817"))
                .body("status", equalTo("placed"))
                .body("complete", equalTo(true));
    }

    @Test
    @Order(3)
    @DisplayName("Удаление заказа после проверки")
    void deleteOrder(){
        given()
                .pathParams("orderId", orderId)
                .when()
                .delete("/store/order/{orderId}")
                .then()
                .statusCode(200)
                .body("message", equalTo(String.valueOf(orderId)));
    }


}
