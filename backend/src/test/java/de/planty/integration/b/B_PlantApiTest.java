package de.planty.integration.b;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

import de.planty.MockData;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class B_PlantApiTest {

        @BeforeAll
        public static void setup() {
                Logger.getLogger("B_PlantApiTest").info("Preparing test data");

                given()
                                .contentType("application/json")
                                .body(MockData.PLANTTYPE_HERB)
                                .when().post("/plantType")
                                .then()
                                .statusCode(201);

                given()
                                .contentType("application/json")
                                .body(MockData.PLANTTYPE_CACTUS)
                                .when().post("/plantType")
                                .then()
                                .statusCode(201);

                Logger.getLogger("B_PlantApiTest").info("2 plantTypes posted to backend");

                given()
                                .contentType("application/json")
                                .body(MockData.ROOM_LIVINGROOM)
                                .when().post("/room")
                                .then()
                                .statusCode(201);

                given()
                                .contentType("application/json")
                                .body(MockData.ROOM_BEDROOM)
                                .when().post("/room")
                                .then()
                                .statusCode(201);

                Logger.getLogger("B_PlantApiTest").info("2 rooms posted to backend");

                given()
                                .contentType("application/json")
                                .body(MockData.SENSOR_1)
                                .when().post("/sensor")
                                .then()
                                .statusCode(201);

                given()
                                .contentType("application/json")
                                .body(MockData.SENSOR_2)
                                .when().post("/sensor")
                                .then()
                                .statusCode(201);

                Logger.getLogger("B_PlantApiTest").info("2 sensors posted to backend");

                given()
                                .contentType("application/json")
                                .body(MockData.PLANT_BASIL)
                                .when().post("/plant")
                                .then()
                                .statusCode(201);

                given()
                                .contentType("application/json")
                                .body(MockData.PLANT_MINT)
                                .when().post("/plant")
                                .then()
                                .statusCode(201);

                Logger.getLogger("B_PlantApiTest").info("2 plants posted to backend");
        }

        @Test
        @Order(1)
        public void testPlantGetAll() {
                given()
                                .when().get("/plant")
                                .then()
                                .statusCode(200)
                                .body("$.size()", is(2));
        }

        @Test
        @Order(2)
        public void testPlantGetBasil() {
                given()
                                .when().get("/plant/13")
                                .then()
                                .statusCode(200)
                                .body("name", is("Basil"));
        }

        @Test
        @Order(3)
        public void testPlantGetMint() {
                given()
                                .when().get("/plant/14")
                                .then()
                                .statusCode(200)
                                .body("name", is("Mint"));
        }

        @Test
        @Order(4)
        public void testPlantDeleteBasil() {
                given()
                                .when().delete("/plant/13")
                                .then()
                                .statusCode(200);

                given()
                                .when().get("/plant/13")
                                .then()
                                .statusCode(404);

                given()
                                .when().get("/plant")
                                .then()
                                .statusCode(200)
                                .body("$.size()", is(1));
        }

        @Test
        @Order(5)
        public void testPlantDeleteMint() {
                given()
                                .when().delete("/plant/14")
                                .then()
                                .statusCode(200);

                given()
                                .when().get("/plant/14")
                                .then()
                                .statusCode(404);

                given()
                                .when().get("/plant")
                                .then()
                                .statusCode(200)
                                .body("$.size()", is(0));
        }

}
