import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Coin {

    public static Map<Integer, Integer> calculateMinCoinsForChange(
        Integer productCost,
        List<Integer> insertedCoins,
        Set<Integer> coinSystem ) {
            Map<Integer, Integer> changeToReturn = new HashMap<>();
            int insertedCoinsSum = insertedCoins.stream().mapToInt(Integer::intValue).sum(); // sum
            int totalChangeToBeReturned = insertedCoinsSum - productCost;
            if (totalChangeToBeReturned == 0) {
                System.out.print("Thank You.. Transaction Is Over. Visit Again.");
                return null;
            } else if (totalChangeToBeReturned < 0) {
                System.out.print("Please Insert More Coin !!");
                return null;
            }

            System.out.println(insertedCoinsSum);
            System.out.println(totalChangeToBeReturned);


            List<Integer> list = new ArrayList<>(coinSystem);
            Collections.sort(list);
            System.out.println(list);

            changeToReturn = breakIntoChnage(totalChangeToBeReturned, list, new HashMap<>());
            return changeToReturn;
    }


    private static Map<Integer, Integer> breakIntoChnage(
        Integer totalChangeToBeReturned,
        List<Integer> coinSystem,
        Map<Integer, Integer> breakedCurrency // map [100-2] [50 -1]
    ) {

        // int lastElement = stream().reduce((a,b)->b).get();  /** to get last iteam */
        int idx = coinSystem.size() - 1;
        while (idx >= 0) {
            int denomination = coinSystem.get(idx);
            System.out.println("denomination = " + denomination);

            if (totalChangeToBeReturned < denomination) {
                // do nothing wait for the next denomination
                idx --;
            } else if (totalChangeToBeReturned.intValue() == denomination) {
                int reminder = totalChangeToBeReturned % denomination;              // Is Zero Now
                int count = (totalChangeToBeReturned - reminder) / denomination;
                breakedCurrency.put(denomination, count);
                break;
            } else { // totalChangeToBeReturned > denomination
                int reminder = totalChangeToBeReturned % denomination;
                int count = (totalChangeToBeReturned - reminder) / denomination;
                breakedCurrency.put(denomination, count);
                breakIntoChnage(reminder, coinSystem, breakedCurrency);
                break;
            }
        }

        return breakedCurrency;
    }

    /**
     * productCost - 150
     * insertedCoins - 100, 100
     * coinSystem - [1, 2, 5, 10, 20, 50, 100, 200] - desired sorted
     */
    public static void main(String[] args) {
        Integer productCost = 150;
        List<Integer> insertedCoins = new ArrayList<>();
            insertedCoins.add(100);
            insertedCoins.add(500);
        Set<Integer> coinSystem = new HashSet<>();
            coinSystem.add(1);
            coinSystem.add(2);
            coinSystem.add(5);
            coinSystem.add(10);
            coinSystem.add(20);
            coinSystem.add(50);
            coinSystem.add(100);
            coinSystem.add(200);

        Map<Integer, Integer> change = calculateMinCoinsForChange(productCost, insertedCoins, coinSystem);
        System.out.println(change);
    }

}

/**
 * Important functions
 * int insertedCoinsSum = insertedCoins.stream().mapToInt(Integer::intValue).sum(); // sum
 * 
 * Set To List
 * List<Integer> list = new ArrayList<>(coinSystem);
 * 
 * Recurrsion
 */

 