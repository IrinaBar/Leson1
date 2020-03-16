public class Vegetable implements Food {

    public String name = "";
    public int how_many = 0;
    public int calories;

    public Vegetable(String name, int how_many, int calories) {
        this.name = name;
        this.how_many = how_many;
        this.calories = calories;
    }

    @Override
    public int calories() {
        return (how_many * calories);
    }

    @Override
    public boolean isPoisonous() {
        return (name.length() == 0) || (name.length() > 10);
    }
}
