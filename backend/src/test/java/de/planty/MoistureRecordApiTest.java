package de.planty;

import de.planty.hibernate.entity.EntitySensor;
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
public class MoistureRecordApiTest {

    @BeforeAll
    public static void setup() {
        Logger.getLogger("MoistureRecordApiTest").info("Preparing test data");

        given()
            .contentType("application/json")
            .body(MockData.PLANTTYPE_HERB)
            .when().post("/plantType")
            .then()
            .statusCode(201); // id 5

        given()
            .contentType("application/json")
            .body(MockData.SENSOR_1)
            .when().post("/sensor")
            .then()
            .statusCode(201); // id 6

        given()
            .contentType("application/json")
            .body(MockData.ROOM_LIVINGROOM)
            .when().post("/room")
            .then()
            .statusCode(201); // id 7

        given()
            .contentType("application/json")
            .body(MockData.PLANT_BASIL)
            .when().post("/plant")
            .then()
            .statusCode(201); // id 8

        given()
            .contentType("application/json")
            .body(MockData.MOISTURE_RECORD1)
            .when().post("/moistureRecord")
            .then()
            .statusCode(201); // id 9

        given()
            .contentType("application/json")
            .body(MockData.MOISTURE_RECORD2)
            .when().post("/moistureRecord")
            .then()
            .statusCode(201); // id 10
    }

    @Test
    @Order(1)
    public void testMoistureRecordGetAll() {
        given()
            .when().get("/moistureRecord")
            .then()
            .statusCode(200)
            .body("$.size()", is(2));
    }

    @Test
    @Order(2)
    public void testMoistureRecordGetMoistureRecord9() {
        given()
            .when().get("/moistureRecord/9")
            .then()
            .statusCode(200)
            .body("humidity_level", is("12"));
    }

    @Test 
    @Order(3)
    public void testMoistureRecordGetMoistureRecord10() {
        given()
            .when().get("/moistureRecord/10")
            .then()
            .statusCode(200)
            .body("humidity_level", is("15"));
    }
    
    @Test 
    @Order(4)
    public void testMoistureRecordGetByPlantId() {
        given()
            .when().get("/moistureRecord/byPlant/8")
            .then()
            .statusCode(200)
            .body("$.size()", is(2));
    }

    @Test
    @Order(5)
    public void testMoistureRecordDeleteMoistureRecord9() {
        given()
            .when().delete("/moistureRecord/9")
            .then()
            .statusCode(200);

        given()
            .when().get("/moistureRecord")
            .then()
            .statusCode(200)
            .body("$.size()", is(1));
    }

    @AfterAll
    public static void cleanup() {
        Logger.getLogger("moistureRecord").info("Cleaning up test data");

        given()
            .when().delete("/moistureRecord/10")
            .then()
            .statusCode(200);
    }
}