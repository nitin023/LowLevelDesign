package LoadBalancer;

public class LoadBalancerFactory {
    public LoadBalancer createLoadBalancer(String loadBalType) {
        return switch (loadBalType) {
            case "round-robin" -> new RoundRobinLoadBalancer();
            case "least-connection" -> new LeastConnectionLoadBalancer();
            default -> new RoutedLoadBalancer() ;
        };
    }
}
