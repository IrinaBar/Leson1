
import org.junit.Assert;
import org.junit.Test;


public class FlatTest {
    @Test
    public void calculateRentalPrice(){
        Flat flat1 = new Flat(10,50);
        Flat flat2 = new Flat(12,60);
        Assert.assertEquals(500, flat1.calculateRentalPrice());
        Assert.assertEquals(720, flat2.calculateRentalPrice());
    }



}
