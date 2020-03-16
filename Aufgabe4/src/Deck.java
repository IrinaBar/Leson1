public abstract class Deck {
  int rows;
  int seatsPerRow;

    public Deck(int rows, int seatsPerRow) {
        this.rows = rows;
        this.seatsPerRow = seatsPerRow;
    }
    abstract boolean isAisleSeat(Seat seat){
        if(seat= leftgang || seat= rightGang){
            return true;
        }
        return false;

    }

    public int getSeatsPerRow() {
        return seatsPerRow;
    }

    Seat[] availableSeats(){

    }
}
