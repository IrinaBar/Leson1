public class Basket {

    private final int maxFood;
    private final Food[] foods;

    public Basket(int size) {
     this.maxFood = size;
        foods=new Food[maxFood];
    }

    public boolean addFood(Food food) {
        boolean result = false;
        for (int i = 0; i < foods.length; i++) {
            if (foods[i] == null && !food.isPoisonous()) {
                foods[i] = food;
               result = true;
                break;
            }
        }
        return result;
    }

    public int calculateCalories() {
        int result = 0;
        for (int i = 0; i < foods.length; i++) {
            if (foods[i] == null)
                break;
            result += foods[i].calories();
        }
        return result;
    }

    public boolean isFull() {
        boolean result = true;
        for (int i = 0; i < foods.length; i++) {
            if (foods[i] == null)
                result = false;
        }
        return result;
    }
}
