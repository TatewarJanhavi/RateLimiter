package SlidingWindow;

import TokenBucket.TokenBucket;

import java.util.HashMap;
import java.util.Map;

public class UserSlidingBucketCreation {
    Map<Integer , SlidingWindow> bucketMap ;

    public UserSlidingBucketCreation(int id) {
        bucketMap = new HashMap<Integer, SlidingWindow>();
        bucketMap.put(id , new SlidingWindow(10, 10));
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
