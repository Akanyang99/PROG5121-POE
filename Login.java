/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registration;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Login {

    private Map<String, String> users = new HashMap<>(); // username -> password
    private Map<String, String> phones = new HashMap<>(); // username -> phone
    private boolean loggedIn = false;
    private String currentUser = null;

    public void register(Scanner sc) {
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        System.out.print("Enter phone: ");
        String phone = sc.nextLine();

        if (!checkUserName(username) || !checkPassword(password) || !checkPhone(phone)) {
            System.out.println("Invalid registration data.");
            return;
        }

        users.put(username, password);
        phones.put(username, phone);
        System.out.println("User registered!");
    }

    public void login(Scanner sc) {
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        if (users.containsKey(username) && users.get(username).equals(password)) {
            loggedIn = true;
            currentUser = username;
            System.out.println("Login successful!");
        } else {
            loggedIn = false;
            System.out.println("Username or password incorrect.");
        }
    }

    public boolean checkUserName(String username) {
        return username != null && username.matches("[a-zA-Z0-9]{3,}");
    }

    public boolean checkPassword(String password) {
        return password != null && password.length() >= 8;
    }

    public boolean checkPhone(String phone) {
        return phone != null && phone.matches("\\d{10}");
    }

    // These methods fix the compilation errors in your tests
    public boolean isUserRegistered(String username) {
        return users.containsKey(username);
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }
}
