package am.gitc.poker;

import am.gitc.poker.domain.Combination;
import am.gitc.poker.domain.Game;
import am.gitc.poker.domain.Hand;
import am.gitc.poker.reader.CombinationReader;
import am.gitc.poker.resolver.CombinationResolver;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Game> games = CombinationReader.read("combinations.txt");
        int firstCount = 0;
        int drawCount = 0;
        for (Game game : games) {
            Hand firstPlayer = game.getFirstPlayer();
            Hand secondPlayer = game.getSecondPlayer();
            Combination firstPlayerCombination = CombinationResolver.resolve(firstPlayer);
            Combination secondPlayerCombination = CombinationResolver.resolve(secondPlayer);
            if (firstPlayerCombination.getRank().ordinal() > secondPlayerCombination.getRank().ordinal()) {
                firstCount++;
                System.out.println(firstPlayer + " " + firstPlayerCombination.getRank() + " === 1 Player Win === " + secondPlayerCombination.getRank() + " " + secondPlayer);
            } else if (firstPlayerCombination.getRank().ordinal() < secondPlayerCombination.getRank().ordinal()) {
                System.out.println(firstPlayer + " " + firstPlayerCombination.getRank() + " === 2 Player Win === " + secondPlayerCombination.getRank() + " " + secondPlayer);
            } else {
                if (firstPlayerCombination.getHighCard().ordinal() > secondPlayerCombination.getHighCard().ordinal()) {
                    firstCount++;
                    System.out.println(firstPlayer + " " + firstPlayerCombination.getRank() + " === 1 Player Win === " + secondPlayerCombination.getRank() + " " + secondPlayer);
                } else if (firstPlayerCombination.getHighCard().ordinal() < secondPlayerCombination.getHighCard().ordinal()) {
                    System.out.println(firstPlayer + " " + firstPlayerCombination.getRank() + " === 2 Player Win === " + secondPlayerCombination.getRank() + " " + secondPlayer);
                } else {
                    if (firstPlayerCombination.getSecondHighCard() != null) {
                        if (firstPlayerCombination.getSecondHighCard().ordinal() > secondPlayerCombination.getSecondHighCard().ordinal()) {
                            firstCount++;
                            System.out.println(firstPlayer + " " + firstPlayerCombination.getRank() + " === 1 Player Win === " + secondPlayerCombination.getRank() + " " + secondPlayer);
                        } else if (firstPlayerCombination.getSecondHighCard().ordinal() < secondPlayerCombination.getSecondHighCard().ordinal()) {
                            System.out.println(firstPlayer + " " + firstPlayerCombination.getRank() + " === 2 Player Win === " + secondPlayerCombination.getRank() + " " + secondPlayer);
                        } else {
                            drawCount++;
                            System.out.println(firstPlayer + " " + firstPlayerCombination.getRank() + " === Draw === " + secondPlayerCombination.getRank() + " " + secondPlayer);
                        }
                    } else {
                        drawCount++;
                        System.out.println(firstPlayer + " " + firstPlayerCombination.getRank() + " === Draw === " + secondPlayerCombination.getRank() + " " + secondPlayer);
                    }
                }
            }
        }
        System.out.println("Win " + firstCount);
        System.out.println("Lose " + (1000 - firstCount - drawCount));
        System.out.println("Draw " + drawCount);
    }
}

