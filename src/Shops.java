import java.util.concurrent.Callable;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Shops implements Callable<List<Integer>> {
    private static final int NUMBER_OF_STORE_TRANSACTIONS = 5;
    private static final int THE_LOWER_BOUND_OF_THE_RANDOM_SALE_PRICE = 10;
    private static final int THE_LOWER_UPPER_OF_THE_RANDOM_SALE_PRICE = 100;

    @Override
    public List<Integer> call() throws Exception {
        List<Integer> intList = new Random().ints(NUMBER_OF_STORE_TRANSACTIONS,
                        THE_LOWER_BOUND_OF_THE_RANDOM_SALE_PRICE, THE_LOWER_UPPER_OF_THE_RANDOM_SALE_PRICE)
                .boxed()
                .collect(Collectors.toList());
        System.out.printf("транзакции магазина %s следующие: %s", Thread.currentThread().getName(), intList);
        System.out.println();
        return intList;
    }
}


