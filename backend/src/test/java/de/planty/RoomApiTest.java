package de.planty;

import de.planty.hibernate.entity.EntityRoom;
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
public class RoomApiTest {

    @BeforeAll
    public static void setup() {
        Logger.getLogger("RoomApiTest").info("Preparing test data");


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
    }

    @Test
    public void testRoomGetAll() {
        given()
                .when().get("/room")
                .then()
                .statusCode(200)
                .body("$.size()", is(2));
    }

    @Test
    public void testRoomGetLivingRoom() {
        given()
                .when().get("/room/1")
                .then()
                .statusCode(200)
                .body("name", is("Living Room"));

    }

    @Test
    public void testRoomGetBedroom() {
        given()
                .when().get("/room/2")
                .then()
                .statusCode(200)
                .body("name", is("Bedroom"));
    }
}
