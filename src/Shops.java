import java.util.concurrent.Callable;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Shops implements Callable<String> {

    @Override
    public String call() throws Exception {
        int numberOfStoreTransactions = 5;
        int theLowerBoundOfTheRandomSalePrice = 10;
        int theUpperBoundOfTheRandomSalePrice = 100;

        List<Integer> intList = new Random().ints(numberOfStoreTransactions,
                        theLowerBoundOfTheRandomSalePrice, theUpperBoundOfTheRandomSalePrice)
                .boxed()
                .collect(Collectors.toList());
        for (Integer entry : intList) {
            Main.stat.add(entry);

        }
        System.out.println(intList + " магазин " + Thread.currentThread().getName());

        return "\nРезультат: " + Main.stat.sum();
    }
}


