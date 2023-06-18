package de.planty;

import org.eclipse.microprofile.config.ConfigProvider;

import io.restassured.RestAssured;

public class QuarkusUtils {

    public static Integer getTestPort() {
        return ConfigProvider.getConfig().getValue("quarkus.http.test-port", Integer.class);
    }

    public static void fixRestAssuredPort() {
        RestAssured.port = getTestPort();
    }
    
}
