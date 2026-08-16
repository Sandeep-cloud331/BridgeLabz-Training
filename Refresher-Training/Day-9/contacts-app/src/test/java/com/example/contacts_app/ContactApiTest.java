package com.example.contacts_app;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class ContactApiTest {
//    @BeforeEach
//    void setup(){
//        RestAssured.baseURI = "http://localhost:8080";
//    }
    @LocalServerPort
    private int port;

    @BeforeEach
    void setup() {
        RestAssured.port = port;
    }

    @Test
    void getAllContacts_returnsOk() {
        given()
                .when()
                .get("/contacts")
                .then()
                .statusCode(200)
                .body("$", instanceOf(java.util.List.class));;

    }

    @Test
    void createContact_returnsCreated(){
        String email = "test" + System.currentTimeMillis() + "@gmail.com";
        String body = """
                {
                "name": "Ravi",
                "email": "%s",
                "phone": "1123456788"
                }
                """.formatted(email);
        given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/contacts")
                .then()
                .statusCode(201)
                .body("name", equalTo("Ravi"))
                .body("email", equalTo(email))
                .body("id", notNullValue())
                .extract().path("id");

    }

    @Test
    void getContactById_returnsContact(){
        String body = """
            {
                "name": "test name",
                "email": "testmail@email.com",
                "phone": "9111122223"
            }
            """;

        int createdId = given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/contacts")
                .then()
                .statusCode(201)
                .extract()
                .path("id");
        given()
                .when()
                .get("/contacts/" + createdId)
                .then()
                .statusCode(200);
    }

    @Test
    void getContactById_notFound_returns404(){
        given()
                .when()
                .get("contacts/9999")
                .then()
                .statusCode(404);
    }
    @Test
    void createContact_blankName_returns400(){
        String body = """
                {
                "name": "",
                "email": "blank@gmail.com",
                "phone": "1234567898"
                }
                """;
        given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/contacts")
                .then()
                .statusCode(400);
    }

    @Test
    void createContact_invalidPhone_returns400(){
        String body = """
                {
                "name": "Rav",
                "email": "invalid@gmail.com",
                "phone": "absbsb"
                }
                """;
        given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/contacts")
                .then()
                .statusCode(400);
    }

    @Test
    void updateExistingContact_return202(){
        String body= """
                {
                "name": "Ravi",
                "email":"test7@gmail.com",
                "phone": "1234567898"
                }
                """;
        int id =given()
                .body(body)
                .contentType(ContentType.JSON)
                .when()
                .post("/contacts")
                .then()
                .statusCode(201)
                .extract()
                .path("id");

        given()
                .body(body.replace("Ravi", "Ravi Updated"))
                .contentType(ContentType.JSON)
                .when()
                .put("/contacts/" + id)
                .then()
                .statusCode(200)
                .body("name", equalTo("Ravi Updated"));
    }
    @Test
    void deleteContact_returns204(){
        String email = "test" + System.currentTimeMillis() + "@gmail.com";
        String body = """
                {"name": "Ravi",
                "email":"%s",
                "phone": "1234567898"
                }
                """.formatted(email);
        int id = given()
                .body(body)
                .contentType(ContentType.JSON)
                .when()
                .post("/contacts")
                .then()
                .statusCode(201)
                .extract().path("id");

        given()
                .when()
                .delete("/contacts/" + id)
                .then()
                .statusCode(200);
    }
    @Test
    void duplicateEmail_return409(){
        String email = "test" + System.currentTimeMillis() + "@gmail.com";
        String body = """
                {
                    "name": "Ravi",
                    "email":"%s",
                    "phone": "1234567898"
                }
                """.formatted(email);
        given()
                .body(body)
                .contentType(ContentType.JSON)
                .when()
                .post("/contacts")
                .then()
                .statusCode(201);

        given()
                .body(body)
                .contentType(ContentType.JSON)
                .when()
                .post("/contacts")
                .then()
                .statusCode(409);


    }

}
