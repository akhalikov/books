package strings;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class CountingDuplicateCharsTest {

    private final CountingDuplicateChars subj = new CountingDuplicateChars();

    @Test
    void simple_test() {
        // given / when
        var result = subj.countDuplicates("ababac");

        // then
        assertThat(result).isEqualTo(Map.of('a', 3, 'b', 2, 'c', 1));
    }

    @Test
    void empty_string() {
        // given / when
        var result = subj.countDuplicates("");

        // then
        assertThat(result).isEmpty();
    }

    @Test
    void single_character() {
        // given / when
        var result = subj.countDuplicates("aaaaaaaaaa");

        // then
        assertThat(result).isEqualTo(Map.of('a', 10));
    }
}