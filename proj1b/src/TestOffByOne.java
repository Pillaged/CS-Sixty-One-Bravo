import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void TestEqualChars() {
        assertTrue(offByOne.equalChars('a','b'));
        assertTrue(offByOne.equalChars('4','3'));
        assertFalse(offByOne.equalChars('a','c'));
        assertFalse(offByOne.equalChars('$','t'));
        assertTrue(offByOne.equalChars('&','%'));
        assertFalse(offByOne.equalChars('x','x'));

    }
}
//Uncomment this class once you've created your CharacterComparator interface and OffByOne class.