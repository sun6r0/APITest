package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Fact {
    private String _id;
    private String text;
    private String type;
    @JsonProperty("userUpvoted")
    private String upvoted;
    private int upvotes;
    @JsonProperty("user")
    private User user;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUpvoted() {
        return upvoted;
    }

    public void setUpvoted(String upvoted) {
        this.upvoted = upvoted;
    }

    public int getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(int upvotes) {
        this.upvotes = upvotes;
    }

    public User getUser() {
            return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public String toString() {
        return "My fact is a " + this._id + " " + this.text ;
    }
}
