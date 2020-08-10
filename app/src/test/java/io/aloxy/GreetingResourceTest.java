package io.aloxy;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import javax.inject.Inject;

@QuarkusTest
public class GreetingResourceTest {

    @Inject Logger logger;

    @Test
    public void testHelloEndpoint() {
        logger.info("Hello to logger from test");

        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("hello"));
    }

}