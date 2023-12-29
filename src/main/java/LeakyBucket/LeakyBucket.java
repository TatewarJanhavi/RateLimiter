package LeakyBucket;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LeakyBucket {
    BlockingQueue<Integer> blockingQueue ;

    public LeakyBucket(int capacity) {
        this.blockingQueue = new LinkedBlockingQueue<>(capacity) ;
    }
    public boolean grantAccess(){
        if(blockingQueue.remainingCapacity() > 0){
            blockingQueue.add(1);
            return true ;
        }
        return false ;
    }
}
