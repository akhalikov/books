package careercup.chapter09.wordsearch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * You have a list of N documents.
 * Find all documents that contain given list of words.
 *
 * Created by akhalikov on 17/02/16
 */
public class WordsSearch {
  private final String docsDir;
  private final Map<String, Path> documents;
  private WordIndexer indexer;

  public WordsSearch(String docsDir) {
    this.docsDir = docsDir;
    this.documents = new HashMap<>();
  }

  public void init() {
    addDocuments();
    indexer = new WordIndexer(documents);
    indexer.build();
  }

  public Map<String, Set<String>> findDocuments(List<String> words) {
    if (documents == null || indexer == null)
      throw new RuntimeException("Search is not initialized");

    final Map<String, Set<String>> index = indexer.getIndex();
    final Map<String, Set<String>> result = new HashMap<>();

    words.forEach(word -> {
      if (index.containsKey(word)) {
        result.put(word, index.get(word));
      }
    });

    return result;
  }

  /**
   * Adding documents from directory
   */
  private void addDocuments() {
    try {
      Path path = Paths.get(docsDir);
      if (!Files.isDirectory(path)) {
        throw new IllegalArgumentException(docsDir + " is not a directory");
      }
      Files.walkFileTree(path, new DocumentReader(documents));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
