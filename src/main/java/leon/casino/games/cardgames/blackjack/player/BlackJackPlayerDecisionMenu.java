package leon.casino.games.cardgames.blackjack.player;

import leon.casino.DecisionMenu;
import leon.casino.Profile;
import leon.casino.games.cardgames.blackjack.BlackJackGame;
import leon.tools.Console;
import leon.tools.StringAssembler;

import java.util.Arrays;

/**
 * Created by leon on 2/25/18.
 */
public class BlackJackPlayerDecisionMenu extends DecisionMenu {
    private final BlackJackPlayer player;
    private final BlackJackGame game;

    public BlackJackPlayerDecisionMenu(BlackJackGame game, BlackJackPlayer player) {
        super(BlackJackPlayerDecision.values());
        this.player = player;
        this.game = game;
    }


    public static void printValues() {
        Console.println("Displaying valid player decisions...");
        Console.println(Arrays.toString(BlackJackPlayerDecision.values()));
    }

    public void getDecision() {
        String moveDecision = Console.getStringInput(this.toString()).toUpperCase();
        try {
            BlackJackPlayerDecision.valueOf(moveDecision).perform(game, player);
        } catch (IllegalArgumentException iae) {
            Console.println("Invalid input! Try again!");
        }
    }

    @Override
    public String toString() {
        // profile
        Profile playerProfile = player.getProfile();
        String playerName = playerProfile.getName();

        // gambling
        double playerBalance = playerProfile.getBalance();
        int playerBet = player.getBetAmount().intValue();

        // card player
        int playerHandTotal = player.getHandTotal();
        int dealerHandTotal = game.getDealer().getHandTotal();

        // black jack card player
        BlackJackPlayerState playerState = BlackJackPlayerState.getState(player);

        return new StringAssembler("\n")
                .append("Welcome to the BlackJack Player-Decision DecisionMenu, [ %s ]!", playerName.toUpperCase())
                .append("Your current balance is [ %s ]", playerBalance)
                .append("Your current hand-total is [ %s ]", playerHandTotal)
                .append("You have currently bet an amount of [ %s ].", playerBet)
                .append("Your current play-state is [ %s ].", playerState.name())
                .append("What action would you like to take?")
                .toString();
    }

}