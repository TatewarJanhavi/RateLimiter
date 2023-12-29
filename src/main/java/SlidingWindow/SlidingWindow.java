package SlidingWindow;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SlidingWindow {
    Queue<Long> slidingQueue ;
    int bucketCapacity ;
    int timeWindowInSecond ;

    public SlidingWindow( int bucketCapacity, int timeWindowInSecond) {
        this.slidingQueue = new ConcurrentLinkedQueue<>();
        this.bucketCapacity = bucketCapacity;
        this.timeWindowInSecond = timeWindowInSecond;
    }

    boolean grantAccess(){
        long currentTime = System.currentTimeMillis();
        checkAndUpdateQuery(currentTime);
        if(slidingQueue.size() < bucketCapacity){
            slidingQueue.add(currentTime);
            return true ;
        }
        return false;
    }

    void checkAndUpdateQuery(long currentTime){
        if(slidingQueue.isEmpty()) return;
        long calculatedTime = ((currentTime - slidingQueue.peek())/1000);
        while(calculatedTime >= timeWindowInSecond){
            slidingQueue.poll();
            if(slidingQueue.isEmpty()) break;
             calculatedTime = ((currentTime - slidingQueue.peek())/1000);
        }
    }
}
