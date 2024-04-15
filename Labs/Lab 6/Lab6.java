import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lab6 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] adjacencyCount = new int[numCourses];
        for(int[] prerequisitePair : prerequisites){
            int needsPrerequisite = prerequisitePair[0];
            adjacencyCount[needsPrerequisite]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < adjacencyCount.length; i++){
            if (adjacencyCount[i] == 0){
                queue.add(i);
            }
        }
        List<Integer> visited = new ArrayList<>();
        while(!queue.isEmpty()){
            int temp = queue.poll();
            for (int[] prerequisitePair: prerequisites){
                if (prerequisitePair[1] == temp){
                    adjacencyCount[prerequisitePair[0]]--;
                    if (adjacencyCount[prerequisitePair[0]] == 0){
                        queue.add(prerequisitePair[0]);
                    }
                }
            }
            visited.add(temp);
        }
        if (visited.size() == numCourses){
            return true;
        }
        else{
            return false;
        }
    }
}
