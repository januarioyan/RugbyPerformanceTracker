package rugbytracker;

public class TrainingSession {

    private String playerName;
    private String date;
    private String sessionType;
    private int duration;
    private int rpe;
    private int trainingLoad;
    private String notes;

    public TrainingSession(
            String playerName,
            String date,
            String sessionType,
            int duration,
            int rpe,
            String notes
    ) {
        this.playerName = playerName;
        this.date = date;
        this.sessionType = sessionType;
        this.duration = duration;
        this.rpe = rpe;
        this.notes = notes;

        trainingLoad = duration * rpe;
    }

    public void displaySession() {

        System.out.println("Player: " + playerName);
        System.out.println("Date: " + date);
        System.out.println("Session Type: " + sessionType);
        System.out.println("Duration: " + duration + " minutes");
        System.out.println("RPE: " + rpe + "/10");
        System.out.println("Training Load: " + trainingLoad + " AU");
        System.out.println("Notes: " + notes);
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getDate() {
        return date;
    }

    public String getSessionType() {
        return sessionType;
    }

    public int getDuration() {
        return duration;
    }

    public int getRpe() {
        return rpe;
    }

    public int getTrainingLoad() {
        return trainingLoad;
    }

    public String getNotes() {
        return notes;
    }
}