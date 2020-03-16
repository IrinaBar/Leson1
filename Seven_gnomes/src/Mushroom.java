public class Mushroom implements Food {

    @Override
    public boolean isPoisonous() {
        return true;
    }

    @Override
    public int calories() {
        return 0;
    }
}
