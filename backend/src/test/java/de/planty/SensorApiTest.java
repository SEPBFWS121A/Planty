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
public class SensorApiTest {

    @BeforeAll
    public static void setup() {
        Logger.getLogger("SensorApiTest").info("Preparing test data");

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
    }

    @Test
    @Order(1)
    public void testSensorGetAll() {
        given()
                .when().get("/sensor")
                .then()
                .statusCode(200)
                .body("$.size()", is(2));
    }

    @Test
    @Order(2)
    public void testSensorGetSensor1() {
        given()
                .when().get("/sensor/3")
                .then()
                .statusCode(200)
                .body("name", is("Humidity"));
    }

    @Test 
    @Order(3)
    public void testSensorGetSensor2() {
        given()
                .when().get("/sensor/4")
                .then()
                .statusCode(200)
                .body("name", is("Temperature"));
    }

    @Test
    @Order(4)
    public void testSensorDeleteSensor1() {
        given()
                .when().delete("/sensor/3")
                .then()
                .statusCode(200);

        given()
                .when().get("/sensor")
                .then()
                .statusCode(200)
                .body("$.size()", is(1));
    }

    @Test
    @Order(5)
    public void testSensorPutSensor2() {
        given()
                .contentType("application/json")
                .body(MockData.SENSOR_2_UPDATE)
                .when().put("/sensor/4")
                .then()
                .statusCode(200);

        given()
                .when().get("/sensor/4")
                .then()
                .statusCode(200)
                .body("name", is("Temperature"))
                .body("humidityScalingTo", is(90));
    }

    @AfterAll
    public static void cleanup() {
        Logger.getLogger("SensorApiTest").info("Cleaning up test data");

        given()
                .when().delete("/sensor/4")
                .then()
                .statusCode(200);
    }
}