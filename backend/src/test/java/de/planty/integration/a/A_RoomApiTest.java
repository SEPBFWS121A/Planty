package de.planty.integration.a;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

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
public class A_RoomApiTest {

        @BeforeAll
        public static void setup() {
                Logger.getLogger("A_RoomApiTest").info("Preparing test data");

                QuarkusUtils.fixRestAssuredPort();

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

                Logger.getLogger("A_RoomApiTest").info("2 rooms posted to backend");

        }

        @Test
        @Order(1)
        public void testRoomGetAll() {
                given()
                                .when().get("/room")
                                .then()
                                .statusCode(200)
                                .body("$.size()", is(2));
        }

        @Test
        @Order(2)
        public void testRoomGetLivingRoom() {
                given()
                                .when().get("/room/3")
                                .then()
                                .statusCode(200)
                                .body("name", is("Living Room"));
        }

        @Test
        @Order(3)
        public void testRoomGetBedroom() {
                given()
                                .when().get("/room/4")
                                .then()
                                .statusCode(200)
                                .body("name", is("Bedroom"));
        }

        @Test
        @Order(4)
        public void testRoomDeleteLivingRoom() {
                given()
                                .when().delete("/room/3")
                                .then()
                                .statusCode(200);

                given()
                                .when().get("/room/3")
                                .then()
                                .statusCode(404);

                given()
                                .when().get("/room")
                                .then()
                                .statusCode(200)
                                .body("$.size()", is(1));
        }

        @Test
        @Order(5)
        public void testRoomDeleteBedroom() {
                given()
                                .when().delete("/room/4")
                                .then()
                                .statusCode(200);

                given()
                                .when().get("/room/4")
                                .then()
                                .statusCode(404);

                given()
                                .when().get("/room")
                                .then()
                                .statusCode(200)
                                .body("$.size()", is(0));
        }

        @AfterAll
        public static void cleanup() {
                // Logger.getLogger("RoomApiTest").info("Cleaning up test data");

                // given()
                // .when().delete("/room/1")
                // .then()
                // .statusCode(200);

                // given()
                // .when().delete("/room/2")
                // .then()
                // .statusCode(200);
        }
}
