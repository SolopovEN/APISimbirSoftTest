import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import models.Fact;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class APITest {

    @Test
    public static void testCatFactsMoreOftenDownCase() throws JsonProcessingException {
        String response = RestAssured
                .when().get("https://cat-fact.herokuapp.com/facts")
                .then()
                .statusCode(200)
                .log().all()
                .extract().body().asString();

        ObjectMapper mapper = new ObjectMapper();
        List<Fact> factList = mapper.readValue(response, new TypeReference<List<Fact>>() {
        });

        long countCatDownCase = factList.stream().filter(s -> s.getType().equals("cat")).count();
        long countCatUpperCase = factList.stream().filter(s -> s.getType().equals("Cat")).count();
        Assert.assertTrue(countCatDownCase > countCatUpperCase, "Cat встречается чаще, чем cat!");
    }
}
