package 手写代码练习;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

public class 线程交替打印 {
    public static void main(String[] args) {

        // 1.使用全局变量
//        test1();

        // 2.使用LockSupport
//        test2();

        // 3.使用wait/notify + CountDownLatch
        test3();

    }

    static AtomicInteger integer = new AtomicInteger(1);
    public static void test1(){

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(integer.get() <= 100) {
                    if (integer.get() % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + " : " + integer.get());
                    }else{
                        continue;
                    }
                    integer.getAndIncrement();
                }
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(integer.get() <= 100) {
                    if (integer.get() % 2 == 1) {
                        System.out.println(Thread.currentThread().getName() + " : " + integer.get());
                    }else {
                        continue;
                    }
                    integer.getAndIncrement();
                }
            }
        });

        t1.start();
        t2.start();
        System.out.println(" ---- end ---- ");
    }


    static Thread thread_1 = null;
    static Thread thread_2 = null;
    public static void test2(){

         thread_1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(integer.get() <= 100){
                    System.out.println(Thread.currentThread().getName() + " : " + integer.get());
                    integer.getAndIncrement();
                    LockSupport.unpark(thread_2);
                    LockSupport.park(thread_1);
                }
            }
        });

         thread_2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(integer.get() <= 100){
                    LockSupport.park(thread_2);
                    System.out.println(Thread.currentThread().getName() + " : " + integer.get());
                    integer.getAndIncrement();
                    LockSupport.unpark(thread_1);
                }
            }
        });

        thread_1.start();
        thread_2.start();
        System.out.println(" ---- end ---- ");
    }


    public static void test3(){
        Object lock = new Object();
        CountDownLatch latch = new CountDownLatch(1);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    latch.countDown();
                    while(integer.get() <= 100){
                        System.out.println(Thread.currentThread().getName() + " : " + integer.get());
                        integer.getAndIncrement();
                        try{
                            lock.notify();
                            lock.wait();
                        }catch(InterruptedException ex){
                            ex.printStackTrace();
                        }

                    }
                    lock.notify();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock){
                    while(integer.get() <= 100){
                        System.out.println(Thread.currentThread().getName() + " : " + integer.get());
                        integer.getAndIncrement();
                        try{
                            lock.notify();
                            lock.wait();
                        }catch (InterruptedException ex){
                            ex.printStackTrace();
                        }
                    }
                    lock.notify();
                }
            }
        });


        t1.start();
        t2.start();
        System.out.println(" ---- end ---- ");
    }


}
