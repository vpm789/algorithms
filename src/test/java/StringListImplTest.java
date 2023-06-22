import org.example.StringListImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringListImplTest {
    private final StringListImpl out = new StringListImpl();

    @Test
    public void checkAddElement() {
        int checkCount = out.toArray().length;
        out.add("one_test");
        assertNotEquals(checkCount, out.toArray().length);
    }

    @Test
    public void checkRemoveElement() {
        out.add("one_test");
        out.add("two_test");
        int checkCount = out.toArray().length;
        out.remove("one_test");
        assertNotEquals(checkCount, out.toArray().length);

    }

    @Test
    public void checkContainsElement() {
        out.add("one_test");
        out.add("two_test");
        assertTrue(out.contains("two_test"));

    }

}
