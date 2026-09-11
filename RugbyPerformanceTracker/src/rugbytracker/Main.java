package rugbytracker;

import java.io.File;

import java.io.FileNotFoundException;

import java.io.PrintWriter;

import java.util.ArrayList;

import java.util.Scanner;

public class Main {

    private static final String TRAINING_FILE =

            "training_sessions.txt";

    private static final String BRONCO_FILE =

            "bronco_tests.txt";

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<TrainingSession> trainingHistory =

                new ArrayList<>();

        ArrayList<BroncoTest> broncoHistory =

                new ArrayList<>();

        // Load previous data when program starts

        loadTrainingSessions(trainingHistory);

        loadBroncoTests(broncoHistory);

        int menuChoice = 0;

        do {

            System.out.println(

                    "\n================================"

            );

            System.out.println(

                    "   RUGBY PERFORMANCE TRACKER"

            );

            System.out.println(

                    "================================"

            );

            System.out.println("1. Log Training Session");

            System.out.println("2. Log Bronco Test");

            System.out.println("3. View Training History");

            System.out.println("4. View Bronco Progress");

            System.out.println("5. Performance Summary");

            System.out.println("6. Exit");

            System.out.print("\nChoose an option: ");

            if (input.hasNextInt()) {

                menuChoice = input.nextInt();

                input.nextLine();

            } else {

                System.out.println(

                        "Invalid input. Please enter a number."

                );

                input.nextLine();

                continue;

            }

            // =====================================

            // OPTION 1 - LOG TRAINING SESSION

            // =====================================

            if (menuChoice == 1) {

                System.out.println(

                        "\n=== LOG TRAINING SESSION ==="

                );

                System.out.print(

                        "Player name: "

                );

                String playerName =

                        input.nextLine();

                System.out.print(

                        "Date: "

                );

                String date =

                        input.nextLine();

                System.out.println(

                        "\nSession Type"

                );

                System.out.println(

                        "1. Rugby Training"

                );

                System.out.println(

                        "2. Touch Rugby"

                );

                System.out.println(

                        "3. Gym / Strength"

                );

                System.out.println(

                        "4. Speed / Sprint"

                );

                System.out.println(

                        "5. Conditioning"

                );

                System.out.println(

                        "6. Recovery"

                );

                int sessionChoice;

                while (true) {

                    System.out.print(

                            "Choose session type: "

                    );

                    if (input.hasNextInt()) {

                        sessionChoice =

                                input.nextInt();

                        input.nextLine();

                        if (

                                sessionChoice >= 1

                                && sessionChoice <= 6

                        ) {

                            break;

                        } else {

                            System.out.println(

                                    "Choose a number from 1 to 6."

                            );

                        }

                    } else {

                        System.out.println(

                                "Invalid input."

                        );

                        input.nextLine();

                    }

                }

                String sessionType;

                switch (sessionChoice) {

                    case 1:

                        sessionType =

                                "Rugby Training";

                        break;

                    case 2:

                        sessionType =

                                "Touch Rugby";

                        break;

                    case 3:

                        sessionType =

                                "Gym / Strength";

                        break;

                    case 4:

                        sessionType =

                                "Speed / Sprint";

                        break;

                    case 5:

                        sessionType =

                                "Conditioning";

                        break;

                    case 6:

                        sessionType =

                                "Recovery";

                        break;

                    default:

                        sessionType =

                                "Other";

                }

                int duration;

                while (true) {

                    System.out.print(

                            "Duration in minutes: "

                    );

                    if (input.hasNextInt()) {

                        duration =

                                input.nextInt();

                        input.nextLine();

                        if (duration > 0) {

                            break;

                        } else {

                            System.out.println(

                                    "Duration must be greater than 0."

                            );

                        }

                    } else {

                        System.out.println(

                                "Enter a whole number."

                        );

                        input.nextLine();

                    }

                }

                int rpe;

                while (true) {

                    System.out.print(

                            "RPE (1-10): "

                    );

                    if (input.hasNextInt()) {

                        rpe =

                                input.nextInt();

                        input.nextLine();

                        if (

                                rpe >= 1

                                && rpe <= 10

                        ) {

                            break;

                        } else {

                            System.out.println(

                                    "RPE must be between 1 and 10."

                            );

                        }

                    } else {

                        System.out.println(

                                "Enter a whole number."

                        );

                        input.nextLine();

                    }

                }

                System.out.print(

                        "Notes: "

                );

                String notes =

                        input.nextLine();

                TrainingSession session =

                        new TrainingSession(

                                playerName,

                                date,

                                sessionType,

                                duration,

                                rpe,

                                notes

                        );

                trainingHistory.add(session);

                saveTrainingSessions(

                        trainingHistory

                );

                System.out.println(

                        "\nTraining session saved!"

                );

                System.out.println(

                        "Training Load: "

                        + session.getTrainingLoad()

                        + " AU"

                );

            }

            // =====================================

            // OPTION 2 - LOG BRONCO

            // =====================================

            else if (menuChoice == 2) {

                System.out.println(

                        "\n=== LOG BRONCO TEST ==="

                );

                System.out.print(

                        "Player name: "

                );

                String playerName =

                        input.nextLine();

                System.out.print(

                        "Date: "

                );

                String date =

                        input.nextLine();

                int minutes;

                while (true) {

                    System.out.print(

                            "Minutes: "

                    );

                    if (input.hasNextInt()) {

                        minutes =

                                input.nextInt();

                        input.nextLine();

                        if (minutes >= 0) {

                            break;

                        }

                    } else {

                        input.nextLine();

                    }

                    System.out.println(

                            "Enter a valid number."

                    );

                }

                double seconds;

                while (true) {

                    System.out.print(

                            "Seconds: "

                    );

                    if (input.hasNextDouble()) {

                        seconds =

                                input.nextDouble();

                        input.nextLine();

                        if (

                                seconds >= 0

                                && seconds < 60

                        ) {

                            break;

                        }

                    } else {

                        input.nextLine();

                    }

                    System.out.println(

                            "Seconds must be between 0 and 59.9."

                    );

                }

                double totalSeconds =

                        (minutes * 60)

                        + seconds;

                double previousBest =

                        Double.MAX_VALUE;

                for (

                        BroncoTest test :

                        broncoHistory

                ) {

                    if (

                            test.getPlayerName()

                            .equalsIgnoreCase(playerName)

                            && test.getTimeInSeconds()

                            < previousBest

                    ) {

                        previousBest =

                                test.getTimeInSeconds();

                    }

                }

                System.out.print(

                        "Notes: "

                );

                String notes =

                        input.nextLine();

                BroncoTest test =

                        new BroncoTest(

                                playerName,

                                date,

                                totalSeconds,

                                notes

                        );

                broncoHistory.add(test);

                saveBroncoTests(

                        broncoHistory

                );

                System.out.println(

                        "\nBronco result saved!"

                );

                System.out.print(

                        "Recorded Time: "

                );

                printTime(totalSeconds);

                if (

                        previousBest == Double.MAX_VALUE

                        || totalSeconds < previousBest

                ) {

                    System.out.println(

                            "NEW PERSONAL BEST!"

                    );

                } else {

                    double difference =

                            totalSeconds

                            - previousBest;

                    System.out.printf(

                            "%.1f seconds off PB.%n",

                            difference

                    );

                }

            }

            // =====================================

            // OPTION 3 - TRAINING HISTORY

            // =====================================

            else if (menuChoice == 3) {

                System.out.println(

                        "\n=== TRAINING HISTORY ==="

                );

                if (trainingHistory.isEmpty()) {

                    System.out.println(

                            "No training sessions recorded."

                    );

                } else {

                    System.out.print(

                            "Enter player name or ALL: "

                    );

                    String searchName =

                            input.nextLine();

                    boolean found =

                            false;

                    for (

                            TrainingSession session :

                            trainingHistory

                    ) {

                        if (

                                searchName

                                .equalsIgnoreCase("ALL")

                                ||

                                session

                                .getPlayerName()

                                .equalsIgnoreCase(

                                        searchName

                                )

                        ) {

                            System.out.println(

                                    "\n------------------------"

                            );

                            session.displaySession();

                            found = true;

                        }

                    }

                    if (!found) {

                        System.out.println(

                                "No sessions found for "

                                + searchName

                        );

                    }

                }

            }

            // =====================================

            // OPTION 4 - BRONCO PROGRESS

            // =====================================

            else if (menuChoice == 4) {

                System.out.println(

                        "\n=== BRONCO PROGRESS ==="

                );

                System.out.print(

                        "Enter player name: "

                );

                String searchName =

                        input.nextLine();

                ArrayList<BroncoTest> playerTests =

                        new ArrayList<>();

                for (

                        BroncoTest test :

                        broncoHistory

                ) {

                    if (

                            test

                            .getPlayerName()

                            .equalsIgnoreCase(

                                    searchName

                            )

                    ) {

                        playerTests.add(test);

                    }

                }

                if (playerTests.isEmpty()) {

                    System.out.println(

                            "No Bronco tests found for "

                            + searchName

                    );

                } else {

                    System.out.println(

                            "\nTest History"

                    );

                    for (

                            BroncoTest test :

                            playerTests

                    ) {

                        System.out.println(

                                "\n------------------------"

                        );

                        test.displayBroncoTest();

                    }

                    double firstTime =

                            playerTests

                            .get(0)

                            .getTimeInSeconds();

                    double latestTime =

                            playerTests

                            .get(

                                    playerTests.size() - 1

                            )

                            .getTimeInSeconds();

                    double bestTime =

                            firstTime;

                    for (

                            BroncoTest test :

                            playerTests

                    ) {

                        if (

                                test.getTimeInSeconds()

                                < bestTime

                        ) {

                            bestTime =

                                    test.getTimeInSeconds();

                        }

                    }

                    System.out.println(

                            "\n=== ANALYSIS ==="

                    );

                    System.out.println(

                            "Tests Completed: "

                            + playerTests.size()

                    );

                    System.out.print(

                            "First Test: "

                    );

                    printTime(firstTime);

                    System.out.print(

                            "Latest Test: "

                    );

                    printTime(latestTime);

                    System.out.print(

                            "Personal Best: "

                    );

                    printTime(bestTime);

                    double improvement =

                            firstTime

                            - latestTime;

                    if (improvement > 0) {

                        System.out.printf(

                                "Improvement: %.1f seconds%n",

                                improvement

                        );

                        System.out.println(

                                "Trend: IMPROVING"

                        );

                    } else if (improvement < 0) {

                        System.out.printf(

                                "Change: %.1f seconds slower%n",

                                Math.abs(improvement)

                        );

                        System.out.println(

                                "Trend: DECLINING"

                        );

                    } else {

                        System.out.println(

                                "Improvement: 0.0 seconds"

                        );

                        System.out.println(

                                "Trend: STABLE"

                        );

                    }

                }

            }

            // =====================================

            // OPTION 5 - PERFORMANCE SUMMARY

            // =====================================

            else if (menuChoice == 5) {

                System.out.println(

                        "\n=== PERFORMANCE SUMMARY ==="

                );

                System.out.print(

                        "Enter player name: "

                );

                String searchName =

                        input.nextLine();

                int sessionCount = 0;

                int totalMinutes = 0;

                int totalLoad = 0;

                int totalRpe = 0;

                for (

                        TrainingSession session :

                        trainingHistory

                ) {

                    if (

                            session

                            .getPlayerName()

                            .equalsIgnoreCase(

                                    searchName

                            )

                    ) {

                        sessionCount++;

                        totalMinutes +=

                                session.getDuration();

                        totalLoad +=

                                session.getTrainingLoad();

                        totalRpe +=

                                session.getRpe();

                    }

                }

                System.out.println(

                        "\n--- TRAINING ---"

                );

                if (sessionCount == 0) {

                    System.out.println(

                            "No training data available."

                    );

                } else {

                    double averageRpe =

                            (double) totalRpe

                            / sessionCount;

                    double averageLoad =

                            (double) totalLoad

                            / sessionCount;

                    System.out.println(

                            "Sessions Completed: "

                            + sessionCount

                    );

                    System.out.println(

                            "Total Training Time: "

                            + totalMinutes

                            + " minutes"

                    );

                    System.out.printf(

                            "Average RPE: %.1f / 10%n",

                            averageRpe

                    );

                    System.out.println(

                            "Total Training Load: "

                            + totalLoad

                            + " AU"

                    );

                    System.out.printf(

                            "Average Session Load: %.1f AU%n",

                            averageLoad

                    );

                }

                ArrayList<BroncoTest> playerTests =

                        new ArrayList<>();

                for (

                        BroncoTest test :

                        broncoHistory

                ) {

                    if (

                            test

                            .getPlayerName()

                            .equalsIgnoreCase(

                                    searchName

                            )

                    ) {

                        playerTests.add(test);

                    }

                }

                System.out.println(

                        "\n--- BRONCO ---"

                );

                if (playerTests.isEmpty()) {

                    System.out.println(

                            "No Bronco data available."

                    );

                } else {

                    double firstTime =

                            playerTests

                            .get(0)

                            .getTimeInSeconds();

                    double latestTime =

                            playerTests

                            .get(

                                    playerTests.size() - 1

                            )

                            .getTimeInSeconds();

                    double bestTime =

                            firstTime;

                    for (

                            BroncoTest test :

                            playerTests

                    ) {

                        if (

                                test.getTimeInSeconds()

                                < bestTime

                        ) {

                            bestTime =

                                    test.getTimeInSeconds();

                        }

                    }

                    System.out.println(

                            "Tests Completed: "

                            + playerTests.size()

                    );

                    System.out.print(

                            "Current Bronco: "

                    );

                    printTime(latestTime);

                    System.out.print(

                            "Bronco PB: "

                    );

                    printTime(bestTime);

                    double improvement =

                            firstTime

                            - latestTime;

                    if (improvement > 0) {

                        System.out.printf(

                                "Improvement: %.1f seconds%n",

                                improvement

                        );

                        System.out.println(

                                "Trend: IMPROVING"

                        );

                    } else if (improvement < 0) {

                        System.out.printf(

                                "Change: %.1f seconds slower%n",

                                Math.abs(improvement)

                        );

                        System.out.println(

                                "Trend: DECLINING"

                        );

                    } else {

                        System.out.println(

                                "Trend: STABLE"

                        );

                    }

                }

            }

            // =====================================

            // OPTION 6 - EXIT

            // =====================================

            else if (menuChoice == 6) {

                saveTrainingSessions(

                        trainingHistory

                );

                saveBroncoTests(

                        broncoHistory

                );

                System.out.println(

                        "\nData saved."

                );

                System.out.println(

                        "Exiting Rugby Performance Tracker."

                );

            }

            else {

                System.out.println(

                        "Invalid option. Choose 1 to 6."

                );

            }

        } while (menuChoice != 6);

        input.close();

    }

    // =========================================

    // DISPLAY BRONCO TIME

    // =========================================

    public static void printTime(

            double totalSeconds

    ) {

        int minutes =

                (int) (totalSeconds / 60);

        double seconds =

                totalSeconds % 60;

        System.out.printf(

                "%d:%04.1f%n",

                minutes,

                seconds

        );

    }

    // =========================================

    // SAVE TRAINING DATA

    // =========================================

    public static void saveTrainingSessions(

            ArrayList<TrainingSession> history

    ) {

        try {

            PrintWriter writer =

                    new PrintWriter(

                            TRAINING_FILE

                    );

            for (

                    TrainingSession session :

                    history

            ) {

                writer.println(

                        clean(

                                session.getPlayerName()

                        )

                        + "\t"

                        + clean(

                                session.getDate()

                        )

                        + "\t"

                        + clean(

                                session.getSessionType()

                        )

                        + "\t"

                        + session.getDuration()

                        + "\t"

                        + session.getRpe()

                        + "\t"

                        + clean(

                                session.getNotes()

                        )

                );

            }

            writer.close();

        } catch (FileNotFoundException e) {

            System.out.println(

                    "Could not save training data."

            );

        }

    }

    // =========================================

    // LOAD TRAINING DATA

    // =========================================

    public static void loadTrainingSessions(

            ArrayList<TrainingSession> history

    ) {

        File file =

                new File(TRAINING_FILE);

        if (!file.exists()) {

            return;

        }

        try {

            Scanner fileScanner =

                    new Scanner(file);

            while (fileScanner.hasNextLine()) {

                String line =

                        fileScanner.nextLine();

                String[] data =

                        line.split(

                                "\t",

                                -1

                        );

                if (data.length == 6) {

                    try {

                        String playerName =

                                data[0];

                        String date =

                                data[1];

                        String sessionType =

                                data[2];

                        int duration =

                                Integer.parseInt(

                                        data[3]

                                );

                        int rpe =

                                Integer.parseInt(

                                        data[4]

                                );

                        String notes =

                                data[5];

                        TrainingSession session =

                                new TrainingSession(

                                        playerName,

                                        date,

                                        sessionType,

                                        duration,

                                        rpe,

                                        notes

                                );

                        history.add(session);

                    } catch (

                            NumberFormatException e

                    ) {

                        System.out.println(

                                "Skipped invalid training record."

                        );

                    }

                }

            }

            fileScanner.close();

        } catch (FileNotFoundException e) {

            System.out.println(

                    "Training data file not found."

            );

        }

    }

    // =========================================

    // SAVE BRONCO DATA

    // =========================================

    public static void saveBroncoTests(

            ArrayList<BroncoTest> history

    ) {

        try {

            PrintWriter writer =

                    new PrintWriter(

                            BRONCO_FILE

                    );

            for (

                    BroncoTest test :

                    history

            ) {

                writer.println(

                        clean(

                                test.getPlayerName()

                        )

                        + "\t"

                        + clean(

                                test.getDate()

                        )

                        + "\t"

                        + test.getTimeInSeconds()

                        + "\t"

                        + clean(

                                test.getNotes()

                        )

                );

            }

            writer.close();

        } catch (FileNotFoundException e) {

            System.out.println(

                    "Could not save Bronco data."

            );

        }

    }

    // =========================================

    // LOAD BRONCO DATA

    // =========================================

    public static void loadBroncoTests(

            ArrayList<BroncoTest> history

    ) {

        File file =

                new File(BRONCO_FILE);

        if (!file.exists()) {

            return;

        }

        try {

            Scanner fileScanner =

                    new Scanner(file);

            while (fileScanner.hasNextLine()) {

                String line =

                        fileScanner.nextLine();

                String[] data =

                        line.split(

                                "\t",

                                -1

                        );

                if (data.length == 4) {

                    try {

                        String playerName =

                                data[0];

                        String date =

                                data[1];

                        double time =

                                Double.parseDouble(

                                        data[2]

                                );

                        String notes =

                                data[3];

                        BroncoTest test =

                                new BroncoTest(

                                        playerName,

                                        date,

                                        time,

                                        notes

                                );

                        history.add(test);

                    } catch (

                            NumberFormatException e

                    ) {

                        System.out.println(

                                "Skipped invalid Bronco record."

                        );

                    }

                }

            }

            fileScanner.close();

        } catch (FileNotFoundException e) {

            System.out.println(

                    "Bronco data file not found."

            );

        }

    }

    // Removes tabs/newlines so saved records stay valid

    public static String clean(String text) {

        return text

                .replace("\t", " ")

                .replace("\n", " ")

                .replace("\r", " ");

    }

}