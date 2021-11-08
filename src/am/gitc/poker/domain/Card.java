package am.gitc.poker.domain;

import java.util.Comparator;

public class Card implements Comparable<Card> {
    private CardSuit suit;
    private CardValue value;

    public CardSuit getSuit() {
        return suit;
    }

    public void setSuit(CardSuit suit) {
        this.suit = suit;
    }

    public CardValue getValue() {
        return value;
    }

    public void setValue(CardValue value) {
        this.value = value;
    }

    @Override
    public int compareTo(Card other) {
        return Integer.compare(other.value.ordinal(), this.value.ordinal());
    }

    @Override
    public String toString() {
        return suit.getValue() + value.getValue();
    }
}
