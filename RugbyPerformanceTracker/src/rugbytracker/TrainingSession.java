/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rugbytracker;

/**
 *
 * @author adminnova
 */
public class TrainingSession {
    private String name;
    private String date;
    private String sessionType;
    private int duration;
    private double sprintTime;
    private double bodyWeight;
    private String notes;
    
    public TrainingSession (String name, String date, String sessionType, int duration,
            double sprintTime, double bodyWeight, String notes) {
        
        this.name = name;
        this.date = date;
        this.sessionType = sessionType;
        this.duration = duration;
        this.sprintTime = sprintTime;
        this.bodyWeight = bodyWeight;
        this.notes = notes;
    }
    
    public void displaySession() {
        System.out.println("Name: " + name);
        System.out.println("Date: " + date);
        System.out.println("Session Type: " + sessionType);
        System.out.println("Duration: " + duration + " minutes");
        System.out.println("Sprint Time: " + sprintTime + " seconds");
        System.out.println("Body Weight: " + bodyWeight + " kg");
        System.out.println("Notes: " + notes);
    }
}
