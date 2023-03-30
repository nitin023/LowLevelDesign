package LoadBalancer;

public class Destination {
    String ipAddress;
    int requestsBeingServed;
    int threshold;

    public boolean acceptRequest(Request request){
        if(requestsBeingServed < threshold){
            requestsBeingServed++;
            return true;
        }
        return false;
    }

    private void onRequestCompletion(){
        requestsBeingServed--;
    }
}
