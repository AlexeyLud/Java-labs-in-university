package task3;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringUtilsTest {

    @Test(expected = NullPointerException.class)
    public void looseByNullRemove() {
        StringUtils su = new StringUtils();
        String actual1 = su.loose(null, null);
        String expected1 = "";
        assertEquals(expected1, actual1);
    }

    @Test
    public void loose() {
        StringUtils su = new StringUtils();

        String actual2 = su.loose(null, "help");
        String expected2 = null;
        assertEquals(expected2, actual2);
        assertNull(actual2);

        String actual3 = su.loose("help", "");
        String expected3 = "help";
        assertEquals(expected3, actual3);

        String actual4 = su.loose(" ", "help");
        String expected4 = " ";
        assertEquals(expected4, actual4);

        String actual5 = su.loose("help", " ");
        String expected5 = "help";
        assertEquals(expected5, actual5);

        String actual6 = su.loose("Hello My World", "hmwl");
        String expected6 = "eoyord";
        assertEquals(expected6, actual6);

    }
}