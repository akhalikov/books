package strings;

import java.util.HashMap;
import java.util.Map;

public class CountingDuplicateChars {

    Map<Character, Integer> countDuplicates(String str) {
        final var frequency = new HashMap<Character, Integer>();
        for (final var ch : str.toCharArray()) {
            frequency.compute(ch, (k, v) -> v == null ? 1 : ++v);
        }
        return frequency;
    }
}
