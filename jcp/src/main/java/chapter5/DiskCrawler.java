package chapter5;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Listing 5.8 Producer and consumer tasks in a desktop search application
 *
 * The listing shows a producer task that searches a file hierarchy for files meeting an indexing criterion
 * and puts their names on the work queue.
 *
 * Indexer shows the consumer task that takes file names from the queue and indexes them.
 *
 * The producer-consumer pattern offers a thread-friendly means of decomposing the desktop search problem into
 * simpler components. Factoring file-crawling and indexing into separate activities results in code that is more
 * readable and reusable than with a monolithic activity that does both; each of the activities has only a single task
 * to do, and the blocking queue handles all the flow control, so the code for each is simpler and clearer.
 */
public class DiskCrawler {

    private static final int QUEUE_BOUND = 1_000;
    private static final int N_CONSUMERS = 4;

    public static void main(String[] args) {
        // startIndexing();
    }

    public static void startIndexing(File[] roots) {
        BlockingQueue<File> queue = new LinkedBlockingQueue(QUEUE_BOUND);

        FileFilter filter = (File file) -> true;

        for (File root: roots)
            new Thread(new FileCrawler(root, filter, queue)).start();

        for (int i = 0; i < N_CONSUMERS; i++)
            new Thread(new Indexer(queue)).start();
    }

    static class FileCrawler implements Runnable {

        private final File root;
        private final FileFilter fileFilter;
        private final BlockingQueue<File> fileQueue;

        public FileCrawler(File root, FileFilter fileFilter, BlockingQueue<File> fileQueue) {
            this.root = root;
            this.fileFilter = fileFilter;
            this.fileQueue = fileQueue;
        }

        @Override
        public void run() {
            try {
                crawl(root);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        private void crawl(File root) throws InterruptedException {
            File[] entries = root.listFiles(fileFilter);
            if (entries != null) {
                for (File entry : entries) {
                    if (entry.isDirectory())
                        crawl(entry);
                    else if (!alreadyIndexed(entry))
                        fileQueue.put(entry);
                }
            }
        }

        private boolean alreadyIndexed(File file) {
            // how to define if file was already indexed ?
            return true;
        }
    }

    static class Indexer implements Runnable {
        private final BlockingQueue<File> queue;

        public Indexer(BlockingQueue<File> queue) {
            this.queue = queue;
        }

        public void run() {
            try {
                while (true)
                    indexFile(queue.take());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        private void indexFile(File file) {
            // some indexing functionality
        }
    }
}
