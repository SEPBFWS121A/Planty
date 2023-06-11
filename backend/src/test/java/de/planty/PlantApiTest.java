package de.planty;

import de.planty.hibernate.entity.EntityPlant;
import de.planty.hibernate.entity.EntityRoom;
import de.planty.hibernate.entity.EntityPlantType;
import de.planty.hibernate.entity.EntitySensor;
import io.quarkus.logging.Log;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.callback.QuarkusTestBeforeClassCallback;

import io.quarkus.test.junit.callback.QuarkusTestBeforeEachCallback;
import io.quarkus.test.junit.callback.QuarkusTestBeforeTestExecutionCallback;
import io.quarkus.test.junit.callback.QuarkusTestMethodContext;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.logging.Logger;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PlantApiTest {

    @BeforeAll
    public static void setup() {
        Logger.getLogger("PlantApiTest").info("Preparing test data");

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
                
        given()
                .contentType("application/json")
                .body(MockData.SENSOR_1)
                .when().post("/sensor")
                .then()
                .statusCode(201);

        given()
                .contentType("application/json")
                .body(MockData.PLANTTYPE_HERB)
                .when().post("/plantType")
                .then()
                .statusCode(201);

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
    }

    @Test
    public void testPlantGetAll() {
        given()
                .when().get("/plant")
                .then()
                .statusCode(200)
                .body("$.size()", is(2));
    }

    @Test
    public void testPlantGetBasil() {
        given()
                .when().get("/plant/1")
                .then()
                .statusCode(200)
                .body("name", is("Basil"));
    }

    @Test
    public void testPlantGetMint() {
        given()
                .when().get("/plant/2")
                .then()
                .statusCode(200)
                .body("name", is("Mint"));
    }
}
