package vazifa1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    static Lock lock = new ReentrantLock();
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Future<Long>> futures = new ArrayList<>();
        long sumFor = 0;
        long startFor = System.currentTimeMillis();
        for (int i = 0; i <= 1_000_000; i++) {
            sumFor+=i;
        }
        System.out.println("For hisobi -> " + sumFor);
        long end = System.currentTimeMillis();
        long qism = 200_000;
        long startThread = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        lock.lock();
        for (int i = 0; i < 5; i++) {
            long start = i*qism+1;
            long end1 = (i+1)*qism;
            futures.add(executorService.submit(()->{
                long sum = 0;
                for (long j = start;j<=end1;j++){
                    sum += j;
                }
                return sum;
            }));
        }
        lock.unlock();
        long sumThread = 0;
        for (int i = 0; i < futures.size(); i++) {
            sumThread+=futures.get(i).get();
        }
        System.out.println("Thread isobi -> " + sumThread);
        long endTrhread = System.currentTimeMillis();
        System.out.println("For ucun ketgan vaqt " + (end-startFor) + " ms");
        System.out.println("Thread ucun ketgan vaqt " + (endTrhread-startThread) + " ms");
    }
}