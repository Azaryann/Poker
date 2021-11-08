package am.gitc.poker.domain;

public class Game {

    private Hand firstPlayer;
    private Hand secondPlayer;

    public Hand getFirstPlayer() {
        return firstPlayer;
    }

    public void setFirstPlayer(Hand firstPlayer) {
        this.firstPlayer = firstPlayer;
    }

    public Hand getSecondPlayer() {
        return secondPlayer;
    }

    public void setSecondPlayer(Hand secondPlayer) {
        this.secondPlayer = secondPlayer;
    }

    @Override
    public String toString() {
        return firstPlayer + " " + secondPlayer;
    }
}
