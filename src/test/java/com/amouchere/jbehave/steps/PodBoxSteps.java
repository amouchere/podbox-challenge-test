package com.amouchere.jbehave.steps;

import com.jayway.restassured.path.json.JsonPath;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.testng.Assert;

import java.util.List;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.path.json.JsonPath.from;
import static org.testng.Assert.assertEquals;

/**
 * Created by LaBete on 22/10/2015.
 */
public class PodBoxSteps {

   private String response = null;

    @Given("my podbox challenge is launched")
    public void givenPodBoxIsLaunched() {
        Assert.assertTrue(true);
    }

    @When("I send a top10 request")
    public void whenISendTop10Request() {
        response = get("/charts").asString();
    }

    @Then("I receive $nbResults results")
    public void thenIReceiveTheRightNumberOfResults(@Named("nbResults") int nbResults) {
        final List<Integer> ranks = from(response).get("rank");
        Assert.assertTrue(ranks.size() == 10);
    }


    @Then("the title with $rank is $title")
    public void thenThetitleWithRankIs(@Named("rank") int rank, @Named("title") String title) {

        JsonPath jp = new JsonPath(response);
        assertEquals(jp.get("[0].title"), title);
    }

}
