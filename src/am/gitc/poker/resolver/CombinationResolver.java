package am.gitc.poker.resolver;

import am.gitc.poker.domain.*;

import java.util.Collections;
import java.util.List;

public class CombinationResolver {

    public static Combination resolve(Hand hand) {
        List<Card> cards = hand.getCards();
        Collections.sort(cards);

        Combination combination = isRoyalFlush(cards);
        if (combination != null) {
            return combination;
        }

        combination = isStraightFlush(cards);
        if (combination != null) {
            return combination;
        }

        combination = isFourOfKind(cards);
        if (combination != null) {
            return combination;
        }

        combination = isFullHouse(cards);
        if (combination != null) {
            return combination;
        }

        combination = isFlush(cards);
        if (combination != null) {
            return combination;
        }

        combination = isStraight(cards);
        if (combination != null) {
            return combination;
        }

        combination = isThreeOfKind(cards);
        if (combination != null) {
            return combination;
        }

        combination = isTwoPair(cards);
        if (combination != null) {
            return combination;
        }

        combination = isPair(cards);
        if (combination != null) {
            return combination;
        }

        return new Combination(Rank.HIGH_CARD, cards.get(0).getValue());
    }

    private static Combination isRoyalFlush(List<Card> cards) {
        if (cards.get(0).getValue() != CardValue.ACE) {
            return null;
        }
        return isStraightFlush(cards) != null ? new Combination(Rank.ROYAL_FLUSH, CardValue.ACE) : null;
    }

    private static Combination isStraightFlush(List<Card> cards) {
        for (int i = 0; i < cards.size() - 1; i++) {
            if (cards.get(i).getSuit() != cards.get(i + 1).getSuit()
                    || cards.get(i).getValue().ordinal() - cards.get(i + 1).getValue().ordinal() != 1) {
                return null;
            }
        }
        return new Combination(Rank.STRAIGHT_FLUSH, cards.get(0).getValue());
    }

    private static Combination isFourOfKind(List<Card> cards) {
        if (cards.get(0).getValue() == cards.get(3).getValue()
                || cards.get(1).getValue() == cards.get(4).getValue()) {
            return new Combination(Rank.FOUR_OF_KIND, cards.get(2).getValue());
        }
        return null;
    }

    private static Combination isFullHouse(List<Card> cards) {
        if ((cards.get(0).getValue() == cards.get(2).getValue()
                && cards.get(3).getValue() == cards.get(4).getValue())
                || (cards.get(0).getValue() == cards.get(1).getValue()
                && cards.get(2).getValue() == cards.get(4).getValue())) {
            return new Combination(Rank.FULL_HOUSE, cards.get(2).getValue());
        }
        return null;
    }

    private static Combination isFlush(List<Card> cards) {
        for (int i = 0; i < cards.size() - 1; i++) {
            if (cards.get(i).getSuit() != cards.get(i + 1).getSuit()) {
                return null;
            }
        }
        return new Combination(Rank.FLUSH, cards.get(0).getValue());
    }

    private static Combination isStraight(List<Card> cards) {
        for (int i = 0; i < cards.size() - 1; i++) {
            if (cards.get(i).getValue().ordinal() - cards.get(i + 1).getValue().ordinal() != 1) {
                return null;
            }
        }
        return new Combination(Rank.STRAIGHT, cards.get(0).getValue());
    }

    private static Combination isThreeOfKind(List<Card> cards) {
        if (cards.get(0).getValue() == cards.get(2).getValue()
                || cards.get(1).getValue() == cards.get(3).getValue()
                || cards.get(2).getValue() == cards.get(4).getValue()) {
            return new Combination(Rank.THREE_OF_KIND, cards.get(2).getValue());
        }
        return null;
    }


    private static Combination isTwoPair(List<Card> cards) {
        int pairCount = 0;
        for (int i = 0; i < cards.size() - 1; i++) {
            if (cards.get(i).getValue() == cards.get(i + 1).getValue()) {
                pairCount++;
            }
        }
        return pairCount == 2 ? new Combination(Rank.TWO_PAIR, cards.get(1).getValue(), cards.get(3).getValue()) : null;
    }

    private static Combination isPair(List<Card> cards) {
        for (int i = 0; i < cards.size() - 1; i++) {
            if (cards.get(i).getValue() == cards.get(i + 1).getValue()) {
                return new Combination(Rank.PAIR, cards.get(i).getValue());
            }
        }
        return null;
    }
}

