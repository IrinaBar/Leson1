public class Seat {
    int row;
    char seat;
    Passenger passenger;

    public Seat(int row, char seat) {
        this.row = row;
        this.seat = seat;
    }

    boolean isFree() {
        if(this.seat=this.passenger){
            return false;
        }
        return true;
    }

    Passenger getPassenger() {
        return passenger;
    }

    void setPassenger(Passenger passenger) {
        this.passenger= passenger;
    }

    public int getRow() {
        return row;
    }

    public char getSeat() {
        return seat;
    }

}