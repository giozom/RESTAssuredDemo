
import io.restassured.http.ContentType;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * Created by garsenius on 15/06/2016.
 * Using fake online API http://jsonplaceholder.typicode.com
 */

public class APITest {

    String baseURL = "http://jsonplaceholder.typicode.com";
    String path = "/posts";

    @Test
    public void testStatus(){

        String url = baseURL + path;

        int statuscode = given()
                .headers("Cache-Control", "no-cache", "Connection", "keep-alive")
                .contentType(ContentType.JSON)
                .get(url).getStatusCode();
        System.out.println(url);

       assertTrue(statuscode == 200);

    }

    @Test
    public void testResponseType(){

        String url = baseURL + path;

        given()
                .get(url)
                .then()
                .assertThat()
                .header("Content-Type", "application/json; charset=utf-8");

    }








}
