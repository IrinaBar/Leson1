import java.util.Random;

/**
 * Diese Klasse repräsentiert Losurnen für Tombolas.
 *
 */
public class RaffleTicketUrn {
    
    private final String name;
    private RaffleTicket[] raffleTickets = new RaffleTicket[0];
    private final Random random = new Random();

    /**
     * Konstruktor, mit dem der Name der Verlosung gesetzt wird.
     * @param name Name der Tombola.
     */
    public RaffleTicketUrn(String name) {
        this.name = name;
    }

    /**
     * Einfügen von Losen in die Urne.
     * @param raffleTickets Lose, die einzufügen sind.
     */
    public void enterRaffleTickets(RaffleTicket... raffleTickets) {
        RaffleTicket[] tickets = this.raffleTickets;
        this.raffleTickets = new RaffleTicket[this.raffleTickets.length + raffleTickets.length];
        System.arraycopy(tickets, 0, this.raffleTickets, 0, tickets.length);
        System.arraycopy(raffleTickets, 0, this.raffleTickets, tickets.length, raffleTickets.length);
    }

    /**
     * Zieht zufällig ein Loas aus der Urne.
     * @return Das gezogene Los.Gibt null zurück, wenn kein Los mehr vorhanden ist.
     */
    public RaffleTicket drawRaffleTicket() {
        if (raffleTickets.length == 0) {
            return null;
        }
        int randomIndex = random.nextInt(raffleTickets.length);
        RaffleTicket ticket = raffleTickets[randomIndex];
        RaffleTicket[] tickets = raffleTickets;
        raffleTickets = new RaffleTicket[raffleTickets.length - 1];
        if (randomIndex > 0) {
            System.arraycopy(tickets, 0, raffleTickets, 0, randomIndex);
        }
        System.arraycopy(tickets, randomIndex + 1, raffleTickets, randomIndex, tickets.length - 1 - randomIndex);
        return ticket;
    }
    
    /**
     * Anzahl der Lose in der Urne.
     * @return Anzahl der Lose in der Urne.
     */
    public int getNumberOfRaffleTickets() {
        return this.raffleTickets.length;
    }
    
}
