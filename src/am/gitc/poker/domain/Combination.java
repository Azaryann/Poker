package am.gitc.poker.domain;

public class Combination {

    private Rank rank;
    private CardValue highCard;
    private CardValue secondHighCard;

    public Combination(Rank rank, CardValue highCard) {
        this.rank = rank;
        this.highCard = highCard;
    }

    public Combination(Rank rank, CardValue highCard, CardValue secondHighCard) {
        this.rank = rank;
        this.highCard = highCard;
        this.secondHighCard = secondHighCard;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public CardValue getHighCard() {
        return highCard;
    }

    public void setHighCard(CardValue highCard) {
        this.highCard = highCard;
    }

    public CardValue getSecondHighCard() {
        return secondHighCard;
    }
}

