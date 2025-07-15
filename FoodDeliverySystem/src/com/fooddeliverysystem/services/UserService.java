package com.fooddeliverysystem.services;

import java.util.ArrayList;
import java.util.Scanner;

import com.fooddeliverysystem.entities.User;

public class UserService {

    private static ArrayList<User> users = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    private static User loggedInUser = null; // ✅ added

    public static void registerUser() {
        System.out.print("Enter Username: ");
        String username = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();
        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();

        users.add(new User(username, password, phone));
        System.out.println("✅ Registration successful!");
    }

    public static boolean loginUser() {
        System.out.print("Enter Username: ");
        String username = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                loggedInUser = u; // ✅ store logged in user
                System.out.println("✅ Login successful. Welcome " + u.getUsername() + "!");
                return true;
            }
        }
        System.out.println("❌ Invalid credentials.");
        return false;
    }

    public static boolean isLoggedIn() {
        return loggedInUser != null;
    }

    public static User getLoggedInCustomer() {
        return loggedInUser;
    }

    public static void showAllUsers() {
        for (User u : users) {
            System.out.println("Username: " + u.getUsername() + ", Phone: " + u.getPhone());
        }
    }
}