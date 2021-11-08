package am.gitc.poker.reader;

import am.gitc.poker.domain.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CombinationReader {


    public static List<Game> read(String filepath) {
        List<String> content = readContext(filepath);
        List<Game> games = new ArrayList<>(content.size());

        for (String strGame : content) {
            games.add(toGame(strGame));
        }
        return games;
    }

    private static Game toGame(String strGame) {
        if (strGame == null || strGame.isBlank()) {
            throw new IllegalArgumentException("Game must not be null or empty");
        }
        String[] arr = strGame.split(" == ");
        Game game = new Game();
        game.setFirstPlayer(toHand(arr[0]));
        game.setSecondPlayer(toHand(arr[1]));

        return game;
    }

    private static Hand toHand(String strHand) {
        if (strHand == null || strHand.isBlank()) {
            throw new IllegalArgumentException("Hand must not be null or empty");
        }
        String[] arr = strHand.strip().split(" ");
        List<Card> cards = new ArrayList<>(arr.length);
        Hand hand = new Hand();
        hand.setCards(cards);

        for (String strCard : arr) {
            cards.add(toCard(strCard));
        }
        return hand;
    }

    private static Card toCard(String strCard) {
        if (strCard == null || strCard.isBlank()) {
            throw new IllegalArgumentException("Hand must not be null or empty");
        }
        Card card = new Card();
        card.setSuit(CardSuit.valueOfByValue(strCard.substring(0, 1)));
        card.setValue(CardValue.valueOfByValue(strCard.substring(1)));
        return card;
    }

    private static List<String> readContext(String filepath) {
        List<String> content = new ArrayList<>();
        try (FileReader fileReader = new FileReader(filepath);
             BufferedReader reader = new BufferedReader(fileReader)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isBlank()) {
                    content.add(line.strip());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return content;
    }
}
