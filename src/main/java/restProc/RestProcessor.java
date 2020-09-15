package restProc;

import pojo.AllFacts;
import pojo.Fact;
import pojo.Name;
import pojo.User;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.*;

public class RestProcessor {

    public void checkStatusCode() {
        given().when().get("https://cat-fact.herokuapp.com/facts").then().statusCode(200);
    }

    public AllFacts getAllFacts(){
        return get("https://cat-fact.herokuapp.com/facts").as(AllFacts.class);
    }

    /**
     * @param allFacts - list of all Fact-objects received by get request
     * @param id - id of user
     * @return name of user with maximum facts
     */
    public String getUserNameWithMaxFacts (AllFacts allFacts, String id) {
        User user;
        Name myName;
        String resName = "";
        for (Fact fact : allFacts.getFacts()) {
            user = fact.getUser();
            if (user != null) {
                myName = user.getNameById(id);
                if (myName != null) {
                    resName = user.getName().getFirst() + " " +user.getName().getLast();
                }
            }
        }
        return resName;
    }

    /**
     * @param allFacts - list of all Fact-objects received by get request
     * @return id of user with maximum facts
     */
    public String getUserIdWithMaxFacts(AllFacts allFacts) {
        String result;
        result = allFacts.getFacts().stream()
                .map(Fact::getUser)
                .filter(Objects::nonNull)
                .map(User::get_id)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .get();
        return result;
    }



}
