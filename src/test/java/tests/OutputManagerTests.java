package tests;

import Utils.OutputManager;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class OutputManagerTests {
    private OutputManager outputManager;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        outputManager = new OutputManager(new String[]{"Find Book", "Login", "Delete"});
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testPrintCommands() {
        outputManager.printCommands();
        String expectedOutput = "0: Find Book\n1: Login\n2: Delete\n";
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }
}
