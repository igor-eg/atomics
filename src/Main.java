import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.ExecutionException;
import java.util.*;

public class Main {
    static LongAdder stat = new LongAdder();

    public static void main(String args[]) throws InterruptedException, ExecutionException {
        int numberThreads = 5;

        Shops shop = new Shops();
        List<Shops> shops = new ArrayList<>();
        ExecutorService ex = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        for (int i = 0; i < numberThreads; i++) {
            shops.add(new Shops());
        }

        String sum = ex.invokeAny(shops); // запускаем потоки и  выводим на печать общую сумму
        System.out.println(sum);
    }

}

