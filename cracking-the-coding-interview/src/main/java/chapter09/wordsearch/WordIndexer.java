package chapter09.wordsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Word indexer
 */
public class WordIndexer {
  private final Map<String, Path> documents;
  private final HashMap<String, Set<String>> index = new HashMap<>();

  public WordIndexer(Map<String, Path> documents) {
    this.documents = documents;
  }

  public void build() {
    for (Map.Entry<String, Path> docEntry : documents.entrySet()) {
      indexDocument(docEntry.getValue(), docEntry.getKey());
    }
  }

  private void indexDocument(Path path, String key) {
    try (BufferedReader reader = Files.newBufferedReader(path)) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] words = line.split("[\\.,\\s\\(\\)]+");
        for (String word : words) {
          if (word.length() > 0) {
            Set<String> documentKeys = index.get(word);
            if (documentKeys != null) {
              documentKeys.add(key);
            } else {
              documentKeys = new HashSet<>();
              documentKeys.add(key);
            }
            index.put(word, documentKeys);
          }
        }
      }
    } catch (IOException x) {
      System.err.format("IOException: %s%n", x);
    }
  }

  public HashMap<String, Set<String>> getIndex() {
    return index;
  }
}
