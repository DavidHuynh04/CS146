import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;

public class HW12 {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        int cost = 0;
        int[] cheapestPipe = new int[n + 1];
        Arrays.fill(cheapestPipe, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            if (wells[i] < cheapestPipe[i + 1]) {
                cheapestPipe[i + 1] = wells[i];
            }
        }
        for (int i = 0; i < pipes.length; i++) {
            if (pipes[i][2] < cheapestPipe[pipes[i][0]]) {
                cheapestPipe[pipes[i][0]] = pipes[i][2];
            }
            if (pipes[i][2] < cheapestPipe[pipes[i][1]]) {
                cheapestPipe[pipes[i][1]] = pipes[i][2];
            }
        }
        List<Integer> visited = new ArrayList<>();
        for (int i = 1; i < cheapestPipe.length; i++) {
            if (wells[i - 1] <= cheapestPipe[i]) {
                visited.add(i);
                cost += wells[i - 1];
            }
        }
        if (visited.size() == 0){
            int lowest = Integer.MAX_VALUE;
            int well = 0;
            for (int i = 0; i < wells.length; i++){
                if (wells[i] < lowest){
                    lowest = wells[i];
                    well = i+1;
                }
            }
            visited.add(well+1);
            cost += lowest;
        }
        Arrays.sort(pipes, Comparator.comparingInt(a -> a[2]));
        while(visited.size()!=n){
            for (int i = 0; i < pipes.length; i++) {
                boolean house1 = visited.contains(pipes[i][0]);
                boolean house2 = visited.contains(pipes[i][1]);
                if (house1 ^ house2) {
                    cost += pipes[i][2];
                    if (!house1) {
                        visited.add(pipes[i][0]);
                    } else {
                        visited.add(pipes[i][1]);
                    }
                    break;
                }
            }
        }
        return cost;
    }
}