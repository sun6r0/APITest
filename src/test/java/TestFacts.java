import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.AllFacts;

import restProc.RestProcessor;

public class TestFacts {

    /**
     * Get list of facts about animals and check if Alex Wohlbruck wrote maximum facts
     **/
    @Test
    public void testFacts() {
        RestProcessor rp = new RestProcessor();
        rp.checkStatusCode();
        AllFacts allFacts = rp.getAllFacts();
        String idMax = rp.getUserIdWithMaxFacts(allFacts);
        Assert.assertEquals(rp.getUserNameWithMaxFacts(allFacts,idMax), "Alex Wohlbruck");
    }

}

