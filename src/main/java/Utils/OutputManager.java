package Utils;

public class OutputManager {
    private final String[] commands;

    public OutputManager(String[] commands) {
        this.commands = commands;
    }

    public void printCommands(){
        for (int i = 0; i < commands.length; i++) {
            System.out.printf("%d: %s%n", i, commands[i]);
        }
    }
}
