import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class General {

    // Variables

    public final static String ANIME_FILE_PATH = "C:\\my_SWE_Training\\Omar Jarrah Task 1\\AnimeRate\\src\\sample-input.txt";
    public final static String LOG_FILE_PATH = "C:\\my_SWE_Training\\Omar Jarrah Task 1\\AnimeRate\\src\\LOG.txt";
    public final static String STOP_WORD = "man of a culture";
    public final static int LRU_CAPACITY = 10;

    // Logging Variables
    public final static int STOP_PROGRAM = -1;
    public final static int START_PROGRAM = 0;
    public final static int ENTER_ANIME_RATE = 1;
    public final static int ENTER_ANIME_NAME = 2;
    public final static int ADD_NEW_ANIME = 3;
    public final static int PRINT_ANIME_NAME = 101;
    public final static int PRINT_ANIME_RATE = 102;
    public final static int PRINT_WARNING = 103;
    public final static int PRINT_ERROR = 104;

    // Methods

    // Anime Related Methods
    public static void checkRate(float rate) {
        if (rate < 0 || rate > 10)
            throw new IllegalArgumentException("Rate must be a float number between 0 and 10");
    }

    public static String normalize(String name) {
        String lowerCase = name.toLowerCase();
        String standardName = lowerCase.replaceAll("[^a-zA-Z0-9]", "");
        return standardName;
    }

    // Txt File Methods
    public static void writeToAnimeFile(String text) {
        try {
            // Create a FileWriter in append mode (true as the second parameter)
            FileWriter fileWriter = new FileWriter(ANIME_FILE_PATH, true);

            // Create a BufferedWriter for efficient writing
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Append the new line to the file
            bufferedWriter.write(text);
            bufferedWriter.newLine(); // Add a new line separator

            // Close the BufferedWriter
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToLogFile(int transaction, String log) {
        try {
            // Create a FileWriter object with the option to append to the file (true) or create a new file if it doesn't exist
            FileWriter fileWriter = new FileWriter(LOG_FILE_PATH, true);

            // Create a BufferedWriter to write text efficiently
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Get the current date and time
            LocalDateTime currentTime = LocalDateTime.now();

            // Define a date and time format (e.g., "yyyy-MM-dd HH:mm:ss")
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            // Format the current time as a string
            String formattedTime = currentTime.format(formatter);

            // Create log line
            String line = switch (transaction) {
                case STOP_PROGRAM -> "[ PROGRAM ] Stop program.";

                case START_PROGRAM -> "[ PROGRAM ] Start program.";

                case ENTER_ANIME_RATE -> "[ USER ] ( Search By Rate ) " + log;

                case ENTER_ANIME_NAME -> "[ USER ] ( Search By Name ) " + log;

                case ADD_NEW_ANIME -> "[ USER ] ( Add New Anime ) " + log;

                case PRINT_ANIME_NAME -> "[ PROGRAM ] ( Print Anime Name ) " + log;

                case PRINT_ANIME_RATE -> "[ PROGRAM ] ( Print Anime Rate ) " + log;

                case PRINT_WARNING -> "[ PROGRAM ] ( WARNING ) " + log;

                case PRINT_ERROR -> "[ PROGRAM ] ( ERROR ) " + log;

                default -> throw new IllegalArgumentException();
            };

            // Write the text and the formatted time to the file
            bufferedWriter.write(formattedTime + " " + line);
            bufferedWriter.newLine(); // Add a newline character

            // Close the BufferedWriter
            bufferedWriter.close();

        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
