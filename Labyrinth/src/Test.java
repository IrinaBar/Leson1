

import org.testng.internal.collections.Pair;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        int[] nums = {6, 7, 3, 7, 678, 2, 3, 4, 7, 9, 22};

        Pair<Boolean, List<Integer>> res = tripleUp(nums);
        if (res.first() ) {
            System.out.println("Наша последовательность: " + res.second() );
        } else {
            System.out.println("Ничего не найдено");
        }

    }

    public static Pair<Boolean, List<Integer>> tripleUp(int[] nums) {
        List<Integer> sequence = new ArrayList<>();
        boolean prevUp = false;
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i+1] - nums[i] == 1) { // Если Следующее больше предыдущего
                if(prevUp==true) { // и prevUp == true (т.е. такая ситуация уже была в предыдущем цикле)
                    sequence.add(nums[i+1]);
                    return new Pair<>(true, sequence); // вернем true т.к. мы уже два цикла подряд находим последовательность
                } else { // и prevUp == false значит мы нашли первую последовательность
                    sequence.add(nums[i]);
                    sequence.add(nums[i+1]);
                    prevUp = true; // Устанавливаем флаг в true чтобы знать о том что мы нашли последовательность
                }
            } else { // Если последовательность прервалась сбрасываем флаг обратно в false
                sequence = new ArrayList<>();
                prevUp = false;
            }
        }
        // Ну тут и так все понятно))
        return new Pair<>(false, sequence);
    }

    public static boolean tripleUp2(int [] nums) {
        boolean triple = false;

        for (int y = 0; y < nums.length -2; y++){
            if (nums[y] == nums[y + 1] - 1 && nums[y] == nums[y + 2] - 2){
                triple = true;
                break;
            }
        }

        return triple;
    }

}
