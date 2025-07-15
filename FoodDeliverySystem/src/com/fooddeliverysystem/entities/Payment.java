package com.fooddeliverysystem.entities;

public class Payment 
{
    private int paymentId;
    private String orderId;
    private String method;
    private double amount;
    private boolean success;

    public Payment(int paymentId, String orderId, String method, double amount, boolean success) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.method = method;
        this.amount = amount;
        this.success = success;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getMethod() {
        return method;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "🧾 Payment Receipt:\n" +
               "  Payment ID   : " + paymentId + "\n" +
               "  Order ID     : " + orderId + "\n" +
               "  Method       : " + method + "\n" +
               "  Amount Paid  : ₹" + amount + "\n" +
               "  Status       : " + (success ? "✅ Success" : "❌ Failed");
    }
}