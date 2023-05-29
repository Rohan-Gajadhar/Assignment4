import java.util.List;
import java.util.Map;

public class Utility {

    /**
     * Calculate the Euclidean distance between two VRP nodes
     * @param node1 the first VRP node
     * @param node2 the second VRP node
     * @return the Euclidean distance between node1 and node2
     */
    public static double calculateEuclideanDistance(VRPNode node1, VRPNode node2) {
        // TODO: Implement the function to calculate the Euclidean distance.
        double distance = 0.0;

        distance += Math.pow((node1.getX() - node2.getX()), 2);
        distance += Math.pow((node1.getY() - node2.getY()), 2);

        return Math.sqrt(distance);
    }

    /**
     * Calculate the total cost of a VRP solution under a VRP instance.
     * The total cost is the sum of all the Euclidean distance between adjacent nodes in the routes.
     * @param solution the VRP solution.
     * @param instance the VRP instance.
     * @return the total cost of the solution.
     */
    public static double calculateTotalCost(VRPSolution solution, VRPInstance instance) {
        // TODO: Implement the function to calculate the total cost of the solution.
        double totalCost = 0.0;

        Map<Integer, VRPNode> nodes = instance.getNodes();
        List<List<Integer>> routes = solution.getRoutes();

        //Depot to first node distance
        for(List<Integer> route : routes){
            VRPNode depot = instance.getDepot();
            VRPNode firstNode = nodes.get(route.get(0));
            totalCost += calculateEuclideanDistance(depot, firstNode);

            for(int i = 0; i < route.size() - 1; i++){
                VRPNode node1 = nodes.get(route.get(i));
                VRPNode node2 = nodes.get(route.get(i + 1));
                totalCost += calculateEuclideanDistance(node1, node2);
            }

            //Last node to depot distance
            VRPNode lastNode = nodes.get(route.get(route.size() - 1));
            totalCost += calculateEuclideanDistance(lastNode, depot);
        }

        return totalCost;
    }

    /**
     * Generate a VRP solution for a VRP instance using the nearest neighbour heuristic.
     * @param instance the VRP instance.
     * @return the VRP solution generated by the nearest neighbour heuristic.
     */
    public static VRPSolution nearestNeighbourHeuristic(VRPInstance instance) {
        // TODO: Implement the nearest neighbour heuristic.
        
        return null;
    }

    /**
     * Generate a VRP solution for a VRP instance using the savings heuristic.
     * @param instance the VRP instance.
     * @return the VRP solution generated by the savings heuristic.
     */
    public static VRPSolution savingsHeuristic(VRPInstance instance) {
        // TODO: Implement the savings heuristic.
        return null;
    }

}
