package com.experiment02;

/**
 * 题目编号：7191
 */
public class Test {
    public static void main(String[] args) {
        // 初始化用户
        User user = new User("BO");
        // 初始化商品
        Product p1 = new Product("电视机");
        Product p2 = new Product("洗衣机");
        Product p3 = new Product("豆浆机");
        Product p4 = new Product("打印机");
        // 初始化商城
        Market m1 = new Market("家乐福", new Product[]{p1, p2});
        Market m2 = new Market("沃尔玛", new Product[]{p3, p4});
        // 方法测试
        addOrder(user, p3, m1);
    }

    public static void addOrder(User user, Product product, Market market) {
        // String result = "没有在";
        // 默认没货
        boolean result = false;
        for (Product p : market.getProducts()) {
            if (product.getName().equals(p.getName())) {
                // 有货
                result = true;
                break;
            }
        }
        String msg = result
                ? user.getName() + "在" + market.getName() + "购买到" + product.getName()
                : product.getName() + market.getName() + "无货";
        System.out.println(msg);
    }
}
