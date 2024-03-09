package tests;
import utils.InputValidator;
import org.junit.Test;

import static org.junit.Assert.*;

public class InputValidatorTest {

    @Test
    public void testValidIntInputs(){
        boolean test1 = InputValidator.isValidIntInput(5, 5, 10);
        boolean test2 = InputValidator.isValidIntInput(10, 5, 10);
        boolean test3 = InputValidator.isValidIntInput(6, 2, 12);
        boolean test4 = InputValidator.isValidIntInput(-1, -10, 0);
        assertTrue(test1);
        assertTrue(test2);
        assertTrue(test3);
        assertTrue(test4);
    }

    @Test
    public void testInvalidIntInputs(){
        boolean test1 = InputValidator.isValidIntInput(0, 5, 10);
        boolean test2 = InputValidator.isValidIntInput(300, 5, 10);
        boolean test3 = InputValidator.isValidIntInput(13, 2, 12);
        boolean test4 = InputValidator.isValidIntInput(-20, -10, 0);
        assertFalse(test1);
        assertFalse(test2);
        assertFalse(test3);
        assertFalse(test4);
    }

    @Test
    public void testValidStringInputs(){
        boolean test1 = InputValidator.isValidString("I am a test");
        boolean test2 = InputValidator.isValidString("10");
        boolean test3 = InputValidator.isValidString("i");

        assertTrue(test1);
        assertTrue(test2);
        assertTrue(test3);
    }

    @Test
    public void testInvalidStringInputs(){
        boolean test1 = InputValidator.isValidString("");
        boolean test2 = InputValidator.isValidString(" ");
        boolean test3 = InputValidator.isValidString("        ");

        assertFalse(test1);
        assertFalse(test2);
        assertFalse(test3);
    }
}
