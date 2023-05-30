import java.io.File;

public class main {

    public static void main(String[] args) {
        String inst = "n32-k5"; // or "n80-k10"
        File instFile = new File("vrp-data/" + inst + ".vrp");
        VRPInstance instance1 = VRPIO.loadInstance(instFile);
        VRPInstance instance2 = VRPIO.loadInstance(instFile);
        VRPInstance instance3 = VRPIO.loadInstance(instFile);

        VRPSolution nnSol = Utility.nearestNeighbourHeuristic(instance1);
        nnSol.setTotalCost(Utility.calculateTotalCost(nnSol, instance2));

        VRPSolution svSol = Utility.savingsHeuristic(instance3);
        svSol.setTotalCost(Utility.calculateTotalCost(svSol, instance3));

        VRPIO.writeSolution(nnSol, inst + "nn.sol");
        VRPIO.writeSolution(svSol, inst + "sv.sol");
    }
}
