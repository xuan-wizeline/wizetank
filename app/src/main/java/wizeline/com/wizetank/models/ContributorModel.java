package wizeline.com.wizetank.models;

/**
 * Created by xuannguyen on 1/20/18.
 */

public class ContributorModel {

    public String name;
    public String profileUrl;
    public String description;
    public int ideaNumber;

    public String getAllInformation() {
        return name + " " + description;
    }
}
