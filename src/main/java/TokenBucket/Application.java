package TokenBucket;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) {
        UserBucketCreation userBucketCreation = new UserBucketCreation(1);
        ExecutorService executorService = Executors.newFixedThreadPool(12);
        for(int i = 1 ; i <= 12 ; i++){
            executorService.execute(() -> userBucketCreation.accessApplication(1));
        }
        executorService.shutdown();
    }
}
