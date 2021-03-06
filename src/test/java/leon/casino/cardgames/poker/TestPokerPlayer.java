package leon.casino.cardgames.poker;

import leon.casino.Profile;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestPokerPlayer {
    private PokerPlayer pokerPlayer;
    private Profile testProfile;


    @Before
    public void setup() {
        this.testProfile = new Profile("TestProfile", 99999999);
        this.pokerPlayer = new PokerPlayer(testProfile);
    }

    @Test
    public void testGetBetAmount() {
        // : Given
        double expected = 10;
        pokerPlayer.setBetAmount(expected);

        // : When
        double actual = pokerPlayer.getBetAmount();

        // : Then
        Assert.assertEquals(expected, actual,0);
    }

    @Test
    public void testCollectEarnings() {
        // : Given
        double startingBalance = testProfile.getBalance();
        double earnings = 100;
        double expected = startingBalance + earnings;
        pokerPlayer.collectEarnings(earnings);

        // : When
        double actual = testProfile.getBalance();

        // : Then
        Assert.assertEquals(expected, actual, 0);
    }
}
