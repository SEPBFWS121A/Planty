package de.planty;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.eclipse.microprofile.config.ConfigProvider;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.logging.Logger;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RoomApiTest {

    @BeforeAll
    public static void setup() {
        Logger.getLogger("RoomApiTest").info("Preparing test data");

        int testBackendPort = ConfigProvider.getConfig().getValue("quarkus.http.test-port", Integer.class);
        Logger.getLogger("RoomApiTest").info("Setting Rest-Assured port to: " + testBackendPort);
        RestAssured.port = testBackendPort;

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
