package com.experiment02;

public class Test {
    public static void main(String[] args) {
        // 模拟用户
        User user = new User("BO", 99, "成栋楼952");
        // 模拟商品
        Product p1 = new Product("方便面", 5.5);
        Product p2 = new Product("火腿肠", 2.2);
        // 模拟用户购买的商品及数量
        Item i1 = new Item(p1, 2);
        Item i2 = new Item(p2, 1);
        // 封装至数组
        Item[] items = {i1, i2};

        // 调用创建订单业务逻辑
        Order order = OrderService.addOrder(user, items);
        if (order != null) {
            System.out.println("购买商品总额：" + order.getCost());
            System.out.println("用户余额：" + order.getUser().getBalance());
            System.out.println("邮递地址：" + order.getUser().getAddress());
        } else {
            System.out.println("用户余额不足");
        }
    }
}
