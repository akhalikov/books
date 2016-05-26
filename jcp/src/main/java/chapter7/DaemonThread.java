package chapter7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Example of usage of daemon thread for scheduled cache update
 *
 * Scheduling is implemented via ScheduledExecutorService.
 * DatabaseSession, ResultSet, Row - typical abstractions used by database drivers.
 */
public class DaemonThread {
  static final DatabaseSession session = new DatabaseSession("postgres@127.0.0.1:1234");

  public static void main(String[] args) throws InterruptedException {
    new DataFetchingService(session);

    // Waiting 10 sec to see how it works
    Thread.sleep(10*1000);
  }

  static class DataFetchingService {
    private static final Logger logger = LoggerFactory.getLogger(DataFetchingService.class);
    private static final int CACHE_UPDATE_INTERVAL_SECONDS = 1;

    private DatabaseSession session;

    /**
     * Cache for fetching data
     */
    private final ConcurrentMap<String, String> cache = new ConcurrentHashMap<>();

    /**
     * Simple service
     */
    public DataFetchingService(DatabaseSession session) {
      this.session = session;

      // Initial cache update
      updateCache();

      // Scheduling cache update
      Executors.newSingleThreadScheduledExecutor((Runnable r) -> {
        Thread thread = new Thread(r, "DataFetchingService_CacheUpdater");

        // If we make this thread daemon - it will be managed by JVM and properly closed on JVM shutdown.
        thread.setDaemon(true);
        return thread;
      }).scheduleWithFixedDelay(() -> {
        try {
          updateCache();
        } catch (RuntimeException e) {
          logger.error("Failed to update cache: {}", e.toString());
        }
      },
      CACHE_UPDATE_INTERVAL_SECONDS, CACHE_UPDATE_INTERVAL_SECONDS, TimeUnit.SECONDS);
    }

    void updateCache() {
      System.out.println("Updating cache...");

      // request to some database or service
      ResultSet resultSet = session.execute("select key, value from some.table");

      Set<String> newKeys = new HashSet<>();

      // updating cache
      if (resultSet == null) {
        return;
      }

      for (Row row: resultSet) {
        String key = row.getString("key");
        cache.put(key, row.getString("value"));
        newKeys.add(key);
      }

      // clear old values
      cache.forEach((key, value) -> {
        if (!newKeys.contains(key)) {
          cache.remove(key);
        }
      });
    }
  }

  static class DatabaseSession {
    private final String uri;

    public DatabaseSession(String uri) {
      this.uri = uri;
    }

    ResultSet execute(String query) {
      System.out.println("Executing query: " + query + " on " + uri);
      return null;
    }
  }

  static abstract class ResultSet implements Iterable<Row> {}

  static abstract class Row {
    abstract String getString(String columnName);
  }
}
