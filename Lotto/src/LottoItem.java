/**
 * Diese Klasse repräsentiert Lotto-Kugeln.
 *
 */
public class LottoItem {
    
    @Override
	public String toString() {
		return "LottoItem [ticketInformation=" + ticketInformation + "]";
	}

	private final String ticketInformation;

    public LottoItem(String ticketInformation) {
        this.ticketInformation = ticketInformation;
    }

    public String getTicketInformation() {
        return "LottoItem: " + ticketInformation;
    }
    
}
