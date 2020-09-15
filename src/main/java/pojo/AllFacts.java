package pojo;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AllFacts {
    @JsonProperty("all")
    private List<Fact> all;

    public List<Fact> getFacts() {
        return all;
    }

    public void setFacts(List<Fact> all) {
        this.all = all;
    }
}
