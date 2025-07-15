package com.fooddeliverysystem.services;

import java.util.Scanner;

import com.fooddeliverysystem.entities.Payment;

public class PaymentService
{
    private static int paymentCounter = 1;
    private Scanner scanner = new Scanner(System.in); // make scanner instance variable

    public Payment processPayment(String orderId, double amount) {
        System.out.println("\n=== Payment ===");
        System.out.println("Total Amount to Pay: ₹" + amount);
        System.out.println("Select Payment Method:");
        System.out.println("1. Cash on Delivery");
        System.out.println("2. UPI");
        System.out.println("3. Debit/Credit Card");
        System.out.print("Enter option (1-3): ");
        int option = scanner.nextInt();
        scanner.nextLine(); // consume newline

        String method = switch (option) {
            case 1 -> "Cash";
            case 2 -> "UPI";
            case 3 -> "Card";
            default -> {
                System.out.println("❌ Invalid payment method selected.");
                yield "Invalid";
            }
        };

        if (method.equals("Invalid")) {
            return null;
        }

        boolean isValid = validatePayment(method);
        boolean success = isValid;

        Payment payment = new Payment(paymentCounter++, orderId, method, amount, success);
        System.out.println(success ? "✅ Payment Successful!" : "❌ Payment Failed!");
        System.out.println(payment);

        return payment;
    }

    private boolean validatePayment(String method) {
        switch (method) {
            case "UPI" -> {
                System.out.print("Enter UPI ID: ");
                String upiId = scanner.nextLine();
                return upiId.contains("@");
            }
            case "Card" -> {
                System.out.print("Enter Card Number (16-digit): ");
                String cardNumber = scanner.nextLine();
                return cardNumber.length() == 16 && cardNumber.matches("\\d+");
            }
            case "Cash" -> {
                System.out.println("Pay with cash on delivery.");
                return true;
            }
            default -> {
                return false;
            }
        }
    }
}