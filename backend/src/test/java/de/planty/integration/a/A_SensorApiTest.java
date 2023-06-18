package de.planty.integration.a;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import java.util.logging.Logger;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

import de.planty.MockData;
import de.planty.QuarkusUtils;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class A_SensorApiTest {

        @BeforeAll
        public static void setup() {
                Logger.getLogger("A_SensorApiTest").info("Preparing test data");

                QuarkusUtils.fixRestAssuredPort();

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

                Logger.getLogger("A_SensorApiTest").info("2 sensors posted to backend");
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
                                .when().get("/sensor/5")
                                .then()
                                .statusCode(200)
                                .body("name", is("Humidity"));
        }

        @Test
        @Order(3)
        public void testSensorGetSensor2() {
                given()
                                .when().get("/sensor/6")
                                .then()
                                .statusCode(200)
                                .body("name", is("Temperature"));
        }

        @Test
        @Order(4)
        public void testSensorPutSensor1() {
                given()
                                .contentType("application/json")
                                .body(MockData.SENSOR_1_UPDATE)
                                .when().put("/sensor/5")
                                .then()
                                .statusCode(200);

                given()
                                .when().get("/sensor/5")
                                .then()
                                .statusCode(200)
                                .body("name", is("Humidity"))
                                .body("humidityScalingFrom", is(10))
                                .body("humidityScalingTo", is(95))
                                .body("sleepTimeout", is(2000));
        }

        @Test
        @Order(5)
        public void testSensorPutSensor2() {
                given()
                                .contentType("application/json")
                                .body(MockData.SENSOR_2_UPDATE)
                                .when().put("/sensor/6")
                                .then()
                                .statusCode(200);

                given()
                                .when().get("/sensor/6")
                                .then()
                                .statusCode(200)
                                .body("name", is("Temperature"))
                                .body("humidityScalingFrom", is(0))
                                .body("humidityScalingTo", is(90))
                                .body("sleepTimeout", is(1000));
        }

        @Test
        @Order(6)
        public void testSensorDeleteSensor1() {
                given()
                                .when().delete("/sensor/5")
                                .then()
                                .statusCode(200);

                given()
                                .when().get("/sensor/5")
                                .then()
                                .statusCode(404);

                given()
                                .when().get("/sensor")
                                .then()
                                .statusCode(200)
                                .body("$.size()", is(1));
        }

        @Test
        @Order(7)
        public void testSensorDeleteSensor2() {
                given()
                                .when().delete("/sensor/6")
                                .then()
                                .statusCode(200);

                given()
                                .when().get("/sensor/6")
                                .then()
                                .statusCode(404);

                given()
                                .when().get("/sensor")
                                .then()
                                .statusCode(200)
                                .body("$.size()", is(0));
        }

        @AfterAll
        public static void cleanup() {
                // Logger.getLogger("SensorApiTest").info("Cleaning up test data");

                // given()
                // .when().delete("/sensor/4")
                // .then()
                // .statusCode(200);
        }
}