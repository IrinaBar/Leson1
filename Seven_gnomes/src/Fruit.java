public class Fruit implements Food {

    private int how_many = 0;

    public Fruit(int how_many) {
        this.how_many = how_many;
    }

    @Override
    public boolean isPoisonous() {
        return false;
    }

    @Override
    public int calories() {
        return how_many;
    }

}
