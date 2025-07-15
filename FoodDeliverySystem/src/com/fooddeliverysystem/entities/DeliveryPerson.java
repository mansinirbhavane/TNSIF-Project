package com.fooddeliverysystem.entities;

public class DeliveryPerson {
    private int deliveryPersonId;
    private String name;
    private String phone;

    public DeliveryPerson(int deliveryPersonId, String name, String phone) {
        this.deliveryPersonId = deliveryPersonId;
        this.name = name;
        this.phone = phone;
    }

    public int getDeliveryPersonId() { return deliveryPersonId; }
    public String getName() { return name; }
    public String getPhone() { return phone; }

    @Override
    public String toString() {
        return "ID: " + deliveryPersonId + ", Name: " + name + ", Phone: " + phone;
    }
}