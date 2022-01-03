package chapter10;

import org.junit.Test;

import static chapter10.GroupAnagrams.sort;
import static chapter10.GroupAnagrams.sort2;
import static org.junit.Assert.assertArrayEquals;
import static toolkit.utils.ArrayUtils.print;

public class GroupAnagramsTest {

    @Test
    public void testSort() {
        // given
        var strings = new String[]{"abab", "Google", "Amazon", "Moo", "abba", "baba"};

        // when
        sort(strings);
        print(strings);

        // then
        assertArrayEquals(
            new String[]{"abab", "abba", "baba", "Amazon", "Google", "Moo"},
            strings
        );
    }

    @Test
    public void testSort2() {
        // given
        var actual = new String[]{"abab", "Google", "Amazon", "Microsoft", "abba", "baba"};

        // when
        sort2(actual);

        // then
        print(actual);
    }
}