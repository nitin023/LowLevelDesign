package UserApiRateLimiter;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowRateLimiter {
    private final int windowSize; // window size in seconds
    private final int requestLimit; // maximum number of requests allowed in the window
    private final Deque<Instant> requestTimes; // queue to keep track of request times

    public SlidingWindowRateLimiter(int windowSize, int requestLimit) {
        this.windowSize = windowSize;
        this.requestLimit = requestLimit;
        this.requestTimes = new ArrayDeque<>(requestLimit);
    }

    public synchronized boolean allowRequest() {
        Instant now = Instant.now();
        Instant windowStart = now.minus(Duration.ofSeconds(windowSize));

        while (!requestTimes.isEmpty() && requestTimes.peek().isBefore(windowStart)) {
            requestTimes.poll(); // remove requests that are outside of the window
        }

        if (requestTimes.size() < requestLimit) {
            requestTimes.offer(now); // add current request time to the queue
            return true; // allow the request
        } else {
            return false; // request limit exceeded
        }
    }
}
