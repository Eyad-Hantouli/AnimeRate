
public class Main {
    public static void main(String[] args) {
        // Write to Log file -> PROGRAM
        General.writeToLogFile(General.START_PROGRAM, "");

        // Create new program
        Program program = new Program(new LRUCache(General.LRU_CAPACITY));

        // Start program
        program.run();

        // Write to Log file -> PROGRAM
        General.writeToLogFile(General.STOP_PROGRAM, "");
    }
}