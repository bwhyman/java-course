package com.example29.highlevelconcurrency.stampedlock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        stampedLockTest();
    }

    /**
     * ReentrantLock重入锁，属于读共享，单读写互斥的悲观锁。
     * StampedLock乐观读锁，允许读的同时写入，提供方法检测
     * @throws InterruptedException
     */
    private static void stampedLockTest() throws InterruptedException {
        User u = new User(10000);
        final StampedLock lock = new StampedLock();

        int count = 5000;
        CountDownLatch latch = new CountDownLatch(count);
        Runnable w = () -> {
            long stamp = lock.writeLock();
            u.setBalance(u.getBalance() - 1);
            System.out.println("Write: " + u.getBalance());
            lock.unlockWrite(stamp);
            latch.countDown();
        };
        Runnable r = () -> {
            long stamp = lock.tryOptimisticRead();
            // 检测读乐观锁时是否有写操作
            if (!lock.validate(stamp)) {
                stamp = lock.readLock();
                try {
                    System.out.println("Read: " + u.getBalance());
                } finally {
                    lock.unlockRead(stamp);
                }
            } else {
                System.out.println("本次乐观锁读失败");
            }
            latch.countDown();
        };

        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < count; i++) {
            executor.submit(w);
            executor.submit(r);
        }
        latch.await();
        executor.shutdown();
    }


    private static class User{
        private int balance;

        public User(int balance) {
            this.balance = balance;
        }

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }
    }
}
