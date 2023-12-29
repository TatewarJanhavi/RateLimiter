package TokenBucket;

import java.util.HashMap;
import java.util.Map;

public class UserBucketCreation {
    Map<Integer , TokenBucket> bucketMap ;

    public UserBucketCreation( int id) {
        bucketMap = new HashMap<Integer, TokenBucket>();
        bucketMap.put(id , new TokenBucket(10, 10));
    }

    void accessApplication(int id){
        if(bucketMap.get(id).grantAccess()){
            System.out.println(Thread.currentThread().getName() + " -> able to access the application");
        }
        else{
            System.out.println(Thread.currentThread().getName() + " -> Too many request, Please try after some time");
        }
    }
}
