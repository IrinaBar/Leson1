public class NMNDeck extends Deck {
    int numMidSeats;

    public NMNDeck(int rows, int seatsPerRow, int numMidSeats) {
        super(rows, seatsPerRow);
        this.numMidSeats=numMidSeats;
    }
}
