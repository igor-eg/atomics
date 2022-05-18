import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.ExecutionException;
import java.util.*;

public class Main {
    static LongAdder stat = new LongAdder();
    private static final int NUMBER_THREADS = 5;

    public static void main(String args[]) throws InterruptedException, ExecutionException {

        Shops shop = new Shops();
        List<Shops> shops = new ArrayList<>();
        ExecutorService ex = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        for (int i = 0; i < NUMBER_THREADS; i++) {
            shops.add(new Shops());
        }

        String sum = ex.invokeAny(shops); // запускаем потоки и  выводим на печать общую сумму
        System.out.println(sum);
    }

}

