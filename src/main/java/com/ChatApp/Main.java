package com.chatapp;

import java.util.Scanner;

/**
 * Main console application for the Chat System registration and login feature.
 * 
 * @author Your Full Name
 * @version 1.0
 */
public class Main {
    
    public static void main(String[] args) {
        // Create a Scanner object to read input from the keyboard
        Scanner scanner = new Scanner(System.in);
        
        // Create a Login object to handle registration and login
        Login loginSystem = new Login();
        
        // Display welcome banner
        System.out.println("==================================================");
        System.out.println("   WELCOME TO THE CHAT APPLICATION");
        System.out.println("==================================================");
        
        // ========== REGISTRATION PHASE ==========
        System.out.println("\n--- REGISTRATION ---");
        System.out.println("Please create your account.\n");
        
        boolean registered = false;
        
        // Keep asking for registration until successful
        while (!registered) {
            // Get user input
            System.out.print("Enter First Name: ");
            String firstName = scanner.nextLine().trim();
            
            System.out.print("Enter Last Name: ");
            String lastName = scanner.nextLine().trim();
            
            System.out.print("Create Username (must contain '_' and be <= 5 chars): ");
            String username = scanner.nextLine().trim();
            
            System.out.print("Create Password (8+ chars, 1 capital, 1 number, 1 special): ");
            String password = scanner.nextLine();
            
            System.out.print("Enter Cell Phone Number (+27XXXXXXXXX format): ");
            String phoneNumber = scanner.nextLine().trim();
            
            // Attempt to register
            String registrationResult = loginSystem.registerUser(username, password, 
                                                                  phoneNumber, firstName, lastName);
            System.out.println("\n" + registrationResult);
            
            // Check if registration was successful
            if (registrationResult.equals("User successfully registered!")) {
                registered = true;
                System.out.println("\n✓ Registration complete!\n");
            } else {
                System.out.println("\nPlease try again with correct format.\n");
            }
        }
        
        // ========== LOGIN PHASE ==========
        System.out.println("--- LOGIN ---");
        boolean loggedIn = false;
        int attempts = 0;
        int maxAttempts = 3;
        
        // Allow up to 3 login attempts
        while (!loggedIn && attempts < maxAttempts) {
            System.out.print("Enter Username: ");
            String loginUsername = scanner.nextLine().trim();
            
            System.out.print("Enter Password: ");
            String loginPassword = scanner.nextLine();
            
            String loginStatus = loginSystem.returnLoginStatus(loginUsername, loginPassword);
            System.out.println(loginStatus);
            
            if (loginStatus.startsWith("Welcome")) {
                loggedIn = true;
                System.out.println("\n✓ You have successfully logged in!");
                System.out.println("Starting chat application...");
                // Note: Chat functionality will be added in Part 2
            } else {
                attempts++;
                if (attempts < maxAttempts) {
                    System.out.println("Attempts remaining: " + (maxAttempts - attempts) + "\n");
                }
            }
        }
        
        if (!loggedIn) {
            System.out.println("\nToo many failed attempts. Please restart the application.");
        }
        
        // Close the scanner to free up resources
        scanner.close();
    }
}