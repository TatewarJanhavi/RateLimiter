package LeakyBucket;

import java.util.HashMap;
import java.util.Map;

public class UserLeakyBucketCreation {
    Map<Integer , LeakyBucket> bucketMap ;

    public UserLeakyBucketCreation(int id) {
        bucketMap = new HashMap<Integer, LeakyBucket>();
        bucketMap.put(id , new LeakyBucket(10));
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
