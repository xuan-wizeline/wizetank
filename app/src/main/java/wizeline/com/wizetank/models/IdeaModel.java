package wizeline.com.wizetank.models;

/**
 * Created by xuannguyen on 1/20/18.
 */

public class IdeaModel {

    public String creators;
    public String title;
    public String description;
    public float rating;
    public int followingNumbers;

    public String getAllInformation() {
        return creators + " " + title + " " + description;
    }
}
