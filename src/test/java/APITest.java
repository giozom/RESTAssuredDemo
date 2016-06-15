
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
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
    String path = "/posts/1";

    @Test
    public void verifyStatus(){

        String url = baseURL + path;

        int statuscode = given()
                .headers("Cache-Control", "no-cache", "Connection", "keep-alive")
                .contentType(ContentType.JSON)
                .get(url).getStatusCode();
        System.out.println("testStatus url: " + url);

       assertTrue(statuscode == 200);

    }

    @Test
    public void verifyResponseType(){

        String url = baseURL + path;

        given()
                .get(url)
                .then()
                .assertThat()
                .header("Content-Type", "application/json; charset=utf-8");
        System.out.println("testResponseType url: " + url);

    }

    @Test
    public void verifyTitleInResponseBody(){

        String url = baseURL + path;

        Response response = given()
                .get(url)
                .then()
                .extract()
                .response();
        System.out.println("testBody url: " + url + ' ' + response);

        /* Get Response Body
        ResponseBody body = response.getBody();
        System.out.println(body);
        */

        String bodyTitle = response.path("title");
        assertTrue(bodyTitle.equals("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));
        System.out.println("title in body is: " +bodyTitle);


    }









}
