import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.ExecutionException;
import java.util.*;

public class Main {
    private static final int NUMBER_THREADS = 5;

    public static void main(String args[]) throws InterruptedException, ExecutionException {
        LongAdder totalRevenueForTaxation = new LongAdder();
        Shops shop = new Shops();
        List<Shops> shops = new ArrayList<>();
        List<List<Integer>> revenueResults = new ArrayList<>();
        ExecutorService ex = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        for (int i = 0; i < NUMBER_THREADS; i++) {
            shops.add(new Shops());
            Future<List<Integer>> revenueResult = ex.submit(shop);
            revenueResults.add(revenueResult.get());
        }

        for (List<Integer> entry : revenueResults) { // складываем выручку магазинов в LongAdder totalRevenueForTaxation
            for (Integer each : entry)
                totalRevenueForTaxation.add(each);
        }

        ex.shutdown();
        System.out.println();
        System.out.println("Общая выручка магазинов: " + totalRevenueForTaxation);
    }
}
