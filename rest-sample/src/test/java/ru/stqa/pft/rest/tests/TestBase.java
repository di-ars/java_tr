package ru.stqa.pft.rest.tests;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.jayway.restassured.RestAssured;
import org.testng.SkipException;
import ru.stqa.pft.rest.model.Issue;

import java.util.Set;

public class TestBase {

    private boolean isIssueOpen(int issueId) {
        String json = RestAssured.get(String.format("http://demo.bugify.com/api/issues/%s.json", issueId)).asString();
        JsonElement parsed = new JsonParser().parse(json);
        /*String issueStatus = parsed.getAsJsonObject().get("issues")
                .getAsJsonObject().get("state_name").getAsString();*/

        Set<Issue> issues = new Gson().fromJson(parsed.getAsJsonObject().get("issues"), new TypeToken<Set<Issue>>() {
        }.getType());
        Issue issue = issues.iterator().next();
        //return issueStatus.equals("resolved");
        return ! issue.getStatus().equals("Resolved");
    }

    public void skipIfNotFixed(int issueId) {
        if (isIssueOpen(issueId)) {
            throw new SkipException("Ignored because of issue " + issueId);
        }
    }
}

