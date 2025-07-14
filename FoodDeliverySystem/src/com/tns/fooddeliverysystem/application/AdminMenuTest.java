package com.tns.fooddeliverysystem.application;

import com.tns.fooddeliverysystem.entities.*;
import com.tns.fooddeliverysystem.services.FoodServices;
import com.tns.fooddeliverysystem.services.AdminService;

import java.util.*;

public class AdminMenuTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FoodServices foodService = new FoodServices();
        AdminService adminService = new AdminService();
        int choice;

        do {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add Restaurant");
            System.out.println("2. Add Food Item to Restaurant");
            System.out.println("3. Remove Food Item from Restaurant");
            System.out.println("4. View Restaurants and Menus");
            System.out.println("5. View Orders");
            System.out.println("6. Add Delivery Person");
            System.out.println("7. Assign Delivery Person to Order");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Restaurant ID: ");
                    int restId = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Restaurant Name: ");
                    String restName = sc.nextLine();
                    foodService.addRestaurant(new Restaurant(restId, restName));
                    break;

                case 2:
                    System.out.print("Enter Restaurant ID: ");
                    int rid = sc.nextInt();
                    System.out.print("Enter Food Item ID: ");
                    int fid = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Food Item Name: ");
                    String fname = sc.nextLine();
                    System.out.print("Enter Food Item Price: ");
                    double fprice = sc.nextDouble();
                    foodService.addFoodItemToRestaurant(rid, new FoodItem(fid, fname, fprice));
                    break;

                case 3:
                    System.out.print("Enter Restaurant ID: ");
                    int rmid = sc.nextInt();
                    System.out.print("Enter Food Item ID to remove: ");
                    int fidRemove = sc.nextInt();
                    foodService.removeFoodItemFromRestaurant(rmid, fidRemove);
                    break;

                case 4:
                    foodService.displayRestaurantsAndMenus();
                    break;

                case 5:
                    adminService.viewOrders();
                    break;

                case 6:
                    System.out.print("Enter Delivery Person ID: ");
                    int dpId = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Delivery Person Name: ");
                    String dpName = sc.nextLine();
                    System.out.print("Enter Contact No.: ");
                    long dpContact = sc.nextLong();
                    adminService.addDeliveryPerson(new DeliveryPerson(dpId, dpName, dpContact));
                    break;

                case 7:
                    System.out.print("Enter Order ID: ");
                    int orderId = sc.nextInt();
                    System.out.print("Enter Delivery Person ID: ");
                    int deliveryId = sc.nextInt();
                    adminService.assignDeliveryPerson(orderId, deliveryId);
                    break;

                case 8:
                    System.out.println("Exiting Admin Module");
                    break;

                default:
                    System.out.println("Invalid option.");
            }

        } while (choice != 8);

        sc.close();
    }
}
