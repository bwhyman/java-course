package com.example44.flow;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class FlowTest {
    public static void main(String[] args) throws InterruptedException {
        // test();
        // test2();
    }

    /**
     * 为什么是发布者关联订阅者？
     * 事件通知架构，例如android，都是订阅者关联发布者，发布者不关心订阅者
     *
     * @throws InterruptedException
     */
    private static void test() throws InterruptedException {
        // 用于在消息全部消费前阻塞主线程，避免异步下主线程结束而关闭控制台
        final CountDownLatch latch = new CountDownLatch(1);
        // 基于java自带的类创建消息发布者publisher
        SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>();
        // 直接基于接口创建匿名类。创建消息订阅者subscriber
        Flow.Subscriber<Integer> subscriber = new Flow.Subscriber<>() {
            private Flow.Subscription subscription;

            // 订阅成功回调onSubscribe()方法，并注入订阅对象subscription
            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                this.subscription = subscription;
                // 自动创建线程，在子线程中异步消费消息
                System.out.println("Subscriber Thread: " + Thread.currentThread().getName());
                // 通知订阅对象subscription，让发布者publisher生产一个消息
                subscription.request(1);
            }

            // 发布者publisher发布消息后，订阅者subscriber回调
            @Override
            public void onNext(Integer i) {
                // 模拟消费订阅的消息
                System.out.println("onNext: " + i);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 消费后继续通过订阅对象，向发布者publisher要一个消息
                subscription.request(1);
            }

            @Override
            public void onError(Throwable throwable) {

            }
            // 发布者publisher宣布不再生产消息，例如发布者调用close()方法关闭
            @Override
            public void onComplete() {
                // 通知阻塞的主线程继续运行
                latch.countDown();
            }
        };

        System.out.println("Running Thread: " + Thread.currentThread().getName());
        // 发布者publisher关联订阅者subscriber，要求subscriber以异步订阅
        publisher.subscribe(subscriber);

        // 默认支持背压，buffer 256
        // 当subscriber达到缓存数量无法消费消息时，publisher自动阻塞停止发布消息
        // subscriber消费消息释放缓存空间后，publisher再次发布消息，直至缓存再次填满
        for (int i = 0; i < 300; i++) {
            // publisher发布消息，通知subscriber回调onNext()方法消费消息
            publisher.submit(i);
            System.out.println(i);
        }
        // publisher结束消息的发布，通知subscriber回调onComplete()方法
        publisher.close();
        // 主线程阻塞，确保subscriber异步消费消息时，
        latch.await();
    }

    // 每个订阅者均会收到相同的消息
    // 属于pub/sub模式，而非P2P模式
    private static void test2() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);
        SubmissionPublisher<Integer> publisher = new SubmissionPublisher<>();
        MySubscriber s1 = new MySubscriber(latch);
        MySubscriber s2 = new MySubscriber(latch);
        publisher.subscribe(s1);
        publisher.subscribe(s2);
        for (int i = 0; i < 10; i++) {
            publisher.submit(i);
        }
        latch.await();
    }

    private static class MySubscriber implements Flow.Subscriber<Integer> {
        CountDownLatch latch;
        private Flow.Subscription subscription;

        public MySubscriber(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            this.subscription = subscription;
            subscription.request(1);
        }

        @Override
        public void onNext(Integer integer) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": " + integer);
            subscription.request(1);
        }

        @Override
        public void onError(Throwable throwable) {

        }

        @Override
        public void onComplete() {
            latch.countDown();
        }
    }
}
