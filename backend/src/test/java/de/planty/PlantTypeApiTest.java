package de.planty;

import de.planty.hibernate.entity.EntityPlantType;
import io.quarkus.logging.Log;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.callback.QuarkusTestBeforeClassCallback;


import io.quarkus.test.junit.callback.QuarkusTestBeforeEachCallback;
import io.quarkus.test.junit.callback.QuarkusTestBeforeTestExecutionCallback;
import io.quarkus.test.junit.callback.QuarkusTestMethodContext;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.logging.Logger;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ZPlantTypeApiTest {

    @BeforeAll
    public static void setup() {
        Logger.getLogger("PlantTypeApiTest").info("Preparing test data");

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
    }

    @Test
    @Order(1)
    public void testPlantTypeGetAll() {
        given()
                .when().get("/plantType")
                .then()
                .statusCode(200)
                .body("$.size()", is(2));
    }

    @Test
    @Order(2)
    public void testPlantTypeGetPlantType1() {
        given()
                .when().get("/planType/5")
                .then()
                .statusCode(200)
                .body("name", is("Herb"));
    }

    @Test
    @Order(3)
    public void testPlantTypeDeletePlantType2() {
        given()
                .when().delete("/plantType/6")
                .then()
                .statusCode(200);
    }

    @AfterAll
    public static void cleanup() {
        Logger.getLogger("PlantTypeApiTest").info("Cleaning up test data");

        given()
                .when().delete("/plantType/5")
                .then()
                .statusCode(200);
    }
}