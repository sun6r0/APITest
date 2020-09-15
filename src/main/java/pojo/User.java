package pojo;

public class User {
    private String _id;
    Name name;

    public String get_id() {
            return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Name getNameById(String _id) {
        if (this._id.equals(_id)) {
            return name;
        }
        else return null;
    }
}
