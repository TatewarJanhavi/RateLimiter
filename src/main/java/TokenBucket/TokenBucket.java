package TokenBucket;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class TokenBucket {

    private AtomicInteger capacity ;
    private AtomicLong lastUpdatedTime ;
    private int bucketCapacity ;
    private int refreshRate ;


    public TokenBucket(int bucketCapacity, int refreshRate) {
        this.bucketCapacity = bucketCapacity;
        this.refreshRate = refreshRate;
        capacity = new AtomicInteger(bucketCapacity);
        lastUpdatedTime = new AtomicLong(System.currentTimeMillis());
    }

    boolean grantAccess(){
        refreshToken();
        if(capacity.get() > 0 ){
            capacity.decrementAndGet();
            return true ;
        }
        return false ;

    }

    void refreshToken()
    {
       long currentTime = System.currentTimeMillis();
       int additionalToken = (int)((currentTime - lastUpdatedTime.get())/1000 *refreshRate);
       int updatedCapacity = Math.min(capacity.get()+additionalToken , bucketCapacity);
       capacity.set(updatedCapacity);
       lastUpdatedTime.set(currentTime);
    }
}
