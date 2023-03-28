package UserApiRateLimiter;

public class RateLimiterTest {
    public static void main(String[] args) {
        //simpleRateLimiter();
        userBasedRateLimiting();
    }

    private static void simpleRateLimiter() {
        SlidingWindowRateLimiter slidingWindowRateLimiter = new SlidingWindowRateLimiter(60, 10);
        for (int i = 0; i < 30; i++) {
            if (slidingWindowRateLimiter.allowRequest()) System.out.println("Request" + i + " allowed");
            else System.out.println("Request " + i + " denied");
        }
    }

    private static void userBasedRateLimiting() {
        UserRequestRateLimiter limiter = new UserRequestRateLimiter(60, 2);
        for (int i = 0; i < 10; i++) {
            String userId = "user" + (i % 2); // simulate 2 users making requests
            if (limiter.allowRequest(userId)) {
                System.out.println("User " + userId + " request " + i + " allowed");
            } else {
                System.out.println("User " + userId + " request " + i + " denied");
            }

        }
    }
}
