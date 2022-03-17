package com.experiment02;

public class OrderService {
    public static Order addOrder(User user, Item[] items) {
        Order order = null;
        double sum = 0;
        for (Item item : items) {
            sum += item.getProduct().getPrice() * item.getQuantity();
        }
        double balance = user.getBalance() - sum;
        if (balance > 0) {
            order = new Order(user, items);
            order.setCost(sum);
            user.setBalance(balance);
        }
        return order;
    }
}
