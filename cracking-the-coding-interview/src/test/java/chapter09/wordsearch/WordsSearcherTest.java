package chapter09.wordsearch;

import static java.util.Arrays.asList;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordsSearcherTest {
  private static final String DOCUMENT_PATH = "data/chapter09/wordsearch";

  @Test
  public void testFindDocuments() {
    List<String> words = asList("machine", "support", "solution", "Incapsula");
    final WordsSearch search = new WordsSearch(DOCUMENT_PATH);
    search.init();

    Map<String, Set<String>> result = search.findDocuments(words);
    for (Map.Entry<String, Set<String>> entry: result.entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue().toString());
    }
  }
}