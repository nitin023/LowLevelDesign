package LoadBalancer;

import java.util.*;

public class RoundRobinLoadBalancer extends LoadBalancer {
    @Override
    Destination balanceLoad(Request request) {
        Map<RequestType, Queue<Destination>> requestTypeDestinationQueueMap = new HashMap<>();

        Set<Destination> destinationSet = getDestinations(request);
        requestTypeDestinationQueueMap.putIfAbsent(request.requestType, convertSetToQueue(destinationSet));

        Destination destination = requestTypeDestinationQueueMap.get(request.requestType).poll();
        requestTypeDestinationQueueMap.get(request.requestType).add(destination);
        return destination;
    }

    private Queue<Destination> convertSetToQueue(Set<Destination> destinationSet) {
        return new LinkedList<>(destinationSet);
    }
}
