import java.util.concurrent.Callable;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Shops implements Callable<String> {

    @Override
    public String call() throws Exception {
        final int NUMBER_OF_STORE_TRANSACTIONS = 5;
        final int THE_LOWER_BOUND_OF_THE_RANDOM_SALE_PRICE = 10;
        final int THE_LOWER_UPPER_OF_THE_RANDOM_SALE_PRICE = 100;

        List<Integer> intList = new Random().ints(NUMBER_OF_STORE_TRANSACTIONS,
                        THE_LOWER_BOUND_OF_THE_RANDOM_SALE_PRICE, THE_LOWER_UPPER_OF_THE_RANDOM_SALE_PRICE)
                .boxed()
                .collect(Collectors.toList());
        for (Integer entry : intList) {
            Main.stat.add(entry);

        }
        System.out.println(intList + " магазин " + Thread.currentThread().getName());

        return "\nРезультат: " + Main.stat.sum();
    }
}


