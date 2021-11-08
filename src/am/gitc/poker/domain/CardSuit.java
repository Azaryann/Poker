package am.gitc.poker.domain;

public enum CardSuit {
    CLUBS("C"),
    DIAMONDS("D"),
    HEARTS("H"),
    SPADES("S");

    public static CardSuit valueOfByValue(String value) {
        for (CardSuit cardSuit : CardSuit.values()) {
            if (cardSuit.value.equals(value)) {
                return cardSuit;
            }
        }
        throw new IllegalArgumentException("No Card available by value = " + value);
    }

    private final String value;

    CardSuit(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
