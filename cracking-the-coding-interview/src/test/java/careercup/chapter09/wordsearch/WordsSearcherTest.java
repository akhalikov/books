package careercup.chapter09.wordsearch;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Test WordsSearcherTest
 */
public class WordsSearcherTest {
  final String documentPath = "data/chapter09/wordsearch";

  @Test
  public void testFindDocuments() {
    List<String> words = Arrays.asList("machine", "support", "solution", "Incapsula");
    final WordsSearch search = new WordsSearch(documentPath);
    search.init();

    Map<String, Set<String>> result = search.findDocuments(words);
    for (Map.Entry<String, Set<String>> entry: result.entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue().toString());
    }
  }
}