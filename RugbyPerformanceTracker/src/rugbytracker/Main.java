/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rugbytracker;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<TrainingSession> trainingHistory = new ArrayList<>();
        String choice;   
        Scanner input = new Scanner(System.in);
        
                do {
        
        System.out.print("Enter name: ");
        String name = input.nextLine();
        System.out.print("Enter date: ");
        String date = input.nextLine();
        System.out.print("Enter Session Type: ");
        String sessionType = input.nextLine();
        System.out.print("Enter duration in minutes: ");
        int duration = input.nextInt(); 
        input.nextLine();
        System.out.print("Enter sprint time in seconds: ");
        double sprintTime = input.nextDouble();
        input.nextLine();
        System.out.print("Enter Body Weight in kg: ");
        double bodyWeight = input.nextDouble(); 
        input.nextLine();
        System.out.print("Enter notes: ");
        String notes = input.nextLine();
                
     TrainingSession session1 = new TrainingSession(
        name,
        date, 
        sessionType,
        duration, 
        sprintTime, 
        bodyWeight,
        notes       
      );
        
        trainingHistory.add(session1);
        
        System.out.print("Add another session? (yes/no): ");
        choice = input.nextLine();
        
                } while (choice.equalsIgnoreCase("yes"));
        
        for(TrainingSession session : trainingHistory) {
            session.displaySession();
        } 

    }
} 