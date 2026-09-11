package rugbytracker;

public class BroncoTest {

    private String playerName;
    private String date;
    private double timeInSeconds;
    private String notes;

    public BroncoTest(
            String playerName,
            String date,
            double timeInSeconds,
            String notes
    ) {
        this.playerName = playerName;
        this.date = date;
        this.timeInSeconds = timeInSeconds;
        this.notes = notes;
    }

    public void displayBroncoTest() {

        int minutes = (int) (timeInSeconds / 60);
        double seconds = timeInSeconds % 60;

        System.out.println("Player: " + playerName);
        System.out.println("Date: " + date);

        System.out.printf(
                "Bronco Time: %d:%04.1f%n",
                minutes,
                seconds
        );

        System.out.println("Notes: " + notes);
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getDate() {
        return date;
    }

    public double getTimeInSeconds() {
        return timeInSeconds;
    }

    public String getNotes() {
        return notes;
    }
}