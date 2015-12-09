package chapter6;

import com.ahalikov.toolkit.threads.ThreadHelper;

import java.util.concurrent.CompletableFuture;

/**
 * How to use CompletableFuture class
 *
 * Created by artur on 09.12.15.
 */
public class FutureLogic {

  public static void main(String[] args) {
    new FutureLogic().start();
  }

  public void start() {
    final DataService dataService = new DataService();
    final ProcessingService processingService = new ProcessingService();

    CompletableFuture
      .supplyAsync(() -> dataService.getData())
      .thenApply((String data) -> processingService.process(data))
      .thenAccept(System.out::println);
  }

  static class DataService {
    /**
     * Some blocking time-consuming data retrieval logic
     */
    public String getData() {
      ThreadHelper.clog("DataService.getData");
      String data = "Hello CompletableFuture";
      ThreadHelper.sleepSeconds(3);
      return data;
    }
  }

  static class ProcessingService {
    /**
     * Some blocking time-consuming processing logic
     */
    public String process(String data) {
      ThreadHelper.clog("ProcessingService.process->" + data);
      ThreadHelper.sleepSeconds(5);
      return "processed data: " + data;
    }
  }
}
