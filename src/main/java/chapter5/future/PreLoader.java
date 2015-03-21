package chapter5.future;

import static utils.ThreadHelper.*;

import java.math.BigDecimal;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by artur on 20.01.15.
 */
public class PreLoader {

    public static void main(String[] args) {
        PreLoader loader = new PreLoader();
        loader.start();

        sleepSeconds(1);

        clog("Getting product after 1sec...");
        // Current thread will block here
        clog("product: " + loader.get());

        sleepSeconds(1);

        clog("Getting product again...");
        clog("product: " + loader.get());
    }

    final FutureTask<ProductInfo> future
            = new FutureTask<>(() -> loadProductInfo());

    final Thread thread = new Thread(future);

    public void start() {
        thread.start();
    }

    ProductInfo get() {
        try {
            return future.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    ProductInfo loadProductInfo() {
        // simulating latency
        clog("Loading product info...");
        sleepSeconds(5);

        ProductInfo productInfo = new ProductInfo(
                "101", "Book", "Concurrency In Practice", new BigDecimal("25.00"));
        return productInfo;
    }

    static class ProductInfo {
        private String id;
        private String category;
        private String name;
        private BigDecimal price;

        public ProductInfo(String id, String category, String name, BigDecimal price) {
            this.id = id;
            this.category = category;
            this.name = name;
            this.price = price;
        }

        @Override
        public String toString() {
            return "ProductInfo{" +
                    "id='" + id + '\'' +
                    ", category='" + category + '\'' +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }
    }
}
