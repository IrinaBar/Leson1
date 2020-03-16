import java.util.Random;

/**
 * Diese Klasse repräsentiert eine Lott-Urne, also die Lostrommeln,
 * aus denen Lottokugeln gezogen werden.
 * @author axel
 *
 */
public class LottoUrn {
    
    private final String name;
    private LottoItem[] lottoItems = new LottoItem[0];
    private final Random random = new Random();

    /**
     * Konstruktor, mit dem der Name der Lotterie gesetzt wird.
     * @param name Name der Verlosung.
     */
    public LottoUrn(String name) {
        this.name = name;
    }

    /**
     * Einfügen von Lotto-Kugeln
     * @param lottoItems Lottokugeln, die in die Losurne zu werfen sind.
     */
    public void enterLottoItems(LottoItem... lottoItems) {
        LottoItem[] items = this.lottoItems;
        this.lottoItems = new LottoItem[this.lottoItems.length + lottoItems.length];
        System.arraycopy(items, 0, this.lottoItems, 0, items.length);
        System.arraycopy(lottoItems, 0, this.lottoItems, items.length, lottoItems.length);
    }

    /**
     * Zufälliges Ziehen einer Lottokugel.
     * @return Lottogkugel.
     */
    public LottoItem drawLottoItem() {
        if (lottoItems.length == 0) {
            return null;
        }
        int randomIndex = random.nextInt(lottoItems.length);
        LottoItem ticket = lottoItems[randomIndex];
        LottoItem[] tickets = lottoItems;
        lottoItems = new LottoItem[lottoItems.length - 1];
        if (randomIndex > 0) {
            System.arraycopy(tickets, 0, lottoItems, 0, randomIndex);
        }
        System.arraycopy(tickets, randomIndex + 1, lottoItems, randomIndex, tickets.length - 1 - randomIndex);
        return ticket;
    }

    /**
     * Anzahl der (noch) in der Lostrommel befindlichen Kugeln.
     * @return Anzahl Kugeln in Lostrommel.
     */
    public int getNumberOfLottoItems() {
        return this.lottoItems.length;
    }
    
    public String getName() {
        return name;
    }
    
}
