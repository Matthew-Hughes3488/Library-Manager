package tests;

import org.junit.Test;
import static org.junit.Assert.*;

import utils.InputManager;

public class InputManagerTests {
    private InputManager inputManager = new InputManager();

    @Test
    public void testGetIntInputWithinRange() {
        // Test valid input within the specified range
        int result = inputManager.getIntInput(0, 100);
        assertTrue(result >= 0 && result <= 100);
    }

    @Test
    public void testGetIntInputOutsideRange() {
        // Test input outside the specified range
        int result = inputManager.getIntInput(-50, 0);
        assertTrue(result < -50 || result > 0);
    }

    @Test
    public void testGetIntInputSameRange() {
        // Test when min and max are the same
        int result = inputManager.getIntInput(1, 1);
        assertEquals(1, result);
    }

    @Test
    public void testGetStringInput() {
        // Test getStringInput method
        String result = inputManager.getStringInput();
        assertNotNull(result);
    }
}
