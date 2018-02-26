package leon.casino.games.cardgames;

/**
 * Created by leon on 5/11/17.
 */

import leon.casino.profile.Profile;
import leon.casino.games.cardgames.cardutilities.Deck;
import leon.tools.RandomUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by leon.hunter on 2/1/2017.
 */
public class TestCardDealer {
    private Deck testDeck;
    private Profile testProfile;
    private CardPlayer testCardPlayer;
    private CardDealer testCardDealer;

    @Before
    public void setup() {
        this.testDeck = new Deck();
        this.testProfile = new Profile(null, null, null);
        this.testCardPlayer = new CardPlayer(testProfile);
        this.testCardDealer = new CardDealer(testDeck);
    }


    @Test
    public final void testDeal() {
        // : Given
        int startSize = testDeck.size();
        int randomNumber = RandomUtils.createInteger(1, 26);

        // : When
        testCardDealer.deal(testCardPlayer, randomNumber);
        int endSize = testDeck.size();

        // : Then
        Assert.assertEquals(endSize, startSize - randomNumber);
    }
}