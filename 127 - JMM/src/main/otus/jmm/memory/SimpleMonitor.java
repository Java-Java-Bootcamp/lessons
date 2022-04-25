package main.otus.jmm.memory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SimpleMonitor {

    private final Object MUTEX = new Object();
    private volatile Queue<String> queue = new LinkedList<>();


    public static void main(String[] args) {
        SimpleMonitor simpleMonitor = new SimpleMonitor();
        Thread poolThread = new Thread("John"){
            public void run(){
                try {
                   String value = simpleMonitor.poll();
                    System.out.println("pooled value: " + value);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread pushThread = new Thread("Peter"){
            public void run(){
                try {
                    Thread.sleep(1000);
                    simpleMonitor.push("new record");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        poolThread.start();
        pushThread.start();

    }

    public void push(String record){
        synchronized (MUTEX){
            queue.add(record);
            System.out.println("notifiyng all waiting threads");
            MUTEX.notifyAll();
            System.out.println("releasing mutex from push " + Thread.currentThread().getName());
        }
    }

    public String poll() throws InterruptedException {
        synchronized (MUTEX){
            while (queue.isEmpty()){
                System.out.println("nothing to fetch, goes to wait");
                MUTEX.wait();
                System.out.println("Releasing mutext from pool " + Thread.currentThread().getName());
            }
            return queue.poll();
        }
    }



}
