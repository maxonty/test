import io.restassured.http.ContentType;
import org.junit.jupiter.api.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PetFullApiTest {

    static long petId = 795673692;

    @BeforeAll
    static void setup() {
        baseURI = "https://petstore.swagger.io/v2";
    }

    @Test
    @Order(1)
    @DisplayName("Создание питомца со всеми параметрами")
    void createPetWithAllFields() {
        String petJson = """
            {
              "id": 795673692,
              "category": {
                "id": 1,
                "name": "cats"
              },
              "name": "Tom",
              "photoUrls": ["https://catpics.com/tom.jpg"],
              "tags": [
                {
                  "id": 101,
                  "name": "cute"
                }
              ],
              "status": "available"
            }
            """;

        given()
                .contentType(ContentType.JSON)
                .body(petJson)
                .when()
                .post("/pet")
                .then()
                .statusCode(200)
                .body("id", equalTo((int) petId))
                .body("category.id", equalTo(1))
                .body("category.name", equalTo("cats"))
                .body("name", equalTo("Tom"))
                .body("photoUrls[0]", equalTo("https://catpics.com/tom.jpg"))
                .body("tags[0].id", equalTo(101))
                .body("tags[0].name", equalTo("cute"))
                .body("status", equalTo("available"));
    }

    @Test
    @Order(2)
    @DisplayName("Проверка всех полей ответа GET /pet/{petId}")
    void checkPetFields() {
        given()
                .pathParam("petId", petId)
                .when()
                .get("/pet/{petId}")
                .then()
                .statusCode(200)
                .body("id", equalTo((int) petId))
                .body("category.id", equalTo(1))
                .body("category.name", equalTo("cats"))
                .body("name", equalTo("Tom"))
                .body("photoUrls[0]", equalTo("https://catpics.com/tom.jpg"))
                .body("tags[0].id", equalTo(101))
                .body("tags[0].name", equalTo("cute"))
                .body("status", equalTo("available"));
    }

    @Test
    @Order(3)
    @DisplayName("Удаление питомца после проверки")
    void deletePet() {
        given()
                .pathParam("petId", petId)
                .when()
                .delete("/pet/{petId}")
                .then()
                .statusCode(200)
                .body("message", equalTo(String.valueOf(petId)));
    }
}

