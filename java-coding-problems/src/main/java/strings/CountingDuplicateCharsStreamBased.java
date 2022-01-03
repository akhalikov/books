package strings;

import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class CountingDuplicateCharsStreamBased {

    Map<Character, Long> countDuplicates(String str) {
        return str.chars()
            .mapToObj(c -> (char) c)
            .collect(groupingBy(c -> c, counting()));
    }
}
