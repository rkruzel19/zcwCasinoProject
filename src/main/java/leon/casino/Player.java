package leon.casino;

/**
 * Created by leon on 5/11/17.
 */
public class Player {
    protected final Profile profile;
    protected final String profileName;

    public Player(Profile profile) {
        this.profile = profile;
        this.profileName = profile.getName();
    }

    public Profile getProfile() {
        return profile;
    }
}
