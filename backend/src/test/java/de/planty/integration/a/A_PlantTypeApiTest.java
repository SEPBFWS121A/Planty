package de.planty.integration.a;

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
import de.planty.QuarkusUtils;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class A_PlantTypeApiTest {

    @BeforeAll
    public static void setup() {
        Logger.getLogger("A_PlantTypeApiTest").info("Preparing test data");

        QuarkusUtils.fixRestAssuredPort();

        given().contentType("application/json").body(MockData.PLANTTYPE_HERB).when().post("/plantType").then()
                .statusCode(201);

        given().contentType("application/json").body(MockData.PLANTTYPE_CACTUS).when().post("/plantType").then()
                .statusCode(201);

        Logger.getLogger("A_PlantTypeApiTest").info("2 plantTypes posted to backend");
    }

    @Test
    @Order(1)
    public void testPlantTypeGetAll() {
        given().when().get("/plantType").then().statusCode(200).body("$.size()", is(2));
    }

    @Test
    @Order(2)
    public void testPlantTypeGetHerb() {
        given().when().get("/plantType/1").then().statusCode(200).body("name", is("Herb"));
    }

    @Test
    @Order(3)
    public void testPlantTypeGetCactus() {
        given().when().get("/plantType/2").then().statusCode(200).body("name", is("Cactus"));
    }

    @Test
    @Order(4)
    public void testPlantTypeDeleteHerb() {
        given().when().delete("/plantType/1").then().statusCode(200);

        given().when().get("/plantType/1").then().statusCode(404);

        given().when().get("/plantType").then().statusCode(200).body("$.size()", is(1));
    }

    @Test
    @Order(5)
    public void testPlantTypeDeleteCactus() {
        given().when().delete("/plantType/2").then().statusCode(200);

        given().when().get("/plantType/2").then().statusCode(404);

        given().when().get("/plantType").then().statusCode(200).body("$.size()", is(0));
    }
}
