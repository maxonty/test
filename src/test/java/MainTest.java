import org.example.Main;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

public class MainTest {

    @BeforeEach
    void setup() {
        System.out.println("Начало тестирования:");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Конец тестирования.");
    }

    @Test
    void checkEven_withEvenNumber() {
        assertEquals(1, Main.checkEven(10));
    }

    @Test
    void checkEven_withOddNumber() {
        assertEquals(0, Main.checkEven(9));
    }

    @Test
    void isShort_withLongString() {
        assertFalse(Main.isShort("Heloooo"));
    }

    @Test
    void isShort_withShortString() {
        assertTrue(Main.isShort("Hi"));
    }
}

