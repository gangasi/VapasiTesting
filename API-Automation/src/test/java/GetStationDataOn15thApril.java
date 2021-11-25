import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class GetStationDataOn15thApril {

    @Test
    public void testGetStationDataOn15thAprilAndValidateForStatusCode(){
               given().
                when().
                get("https://api.bart.gov/api/route.aspx?cmd=routes&key=MW9S-E7SL-26DU-VV8V&date=04/15/2021&json=y").
                then().
                assertThat().
                body("root.routes.route[1].color", equalTo("BEIGE")).
                body("root.routes.route.routeID", hasItem("ROUTE 20")).
                body("root.routes.route.routeID", not(hasItem("ROUTE 0"))).
                body("root.routes.route.number", hasSize(12));
    }
}
