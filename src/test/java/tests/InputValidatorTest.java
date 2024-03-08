package tests;
import Utils.InputValidator;
import org.junit.Test;

import static org.junit.Assert.*;

public class InputValidatorTest {
    public InputValidator inputValidator = new InputValidator();

    @Test
    public void testValidInputs(){
        boolean test1 = inputValidator.isValidIntInput(5, 5, 10);
        boolean test2 = inputValidator.isValidIntInput(10, 5, 10);
        boolean test3 = inputValidator.isValidIntInput(6, 2, 12);
        boolean test4 = inputValidator.isValidIntInput(-1, -10, 0);
        assertTrue(test1);
        assertTrue(test2);
        assertTrue(test3);
        assertTrue(test4);
    }

    @Test
    public void testInvalidInputs(){
        boolean test1 = inputValidator.isValidIntInput(0, 5, 10);
        boolean test2 = inputValidator.isValidIntInput(300, 5, 10);
        boolean test3 = inputValidator.isValidIntInput(13, 2, 12);
        boolean test4 = inputValidator.isValidIntInput(-20, -10, 0);
        assertFalse(test1);
        assertFalse(test2);
        assertFalse(test3);
        assertFalse(test4);
    }
}
