import java.util.*;
public class HW11 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int current = image[sr][sc];
        List<List<Integer>> visited = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        List<Integer> temp = new ArrayList<>(Arrays.asList(sr, sc));
        queue.add(temp);
        while (!queue.isEmpty()){
            temp = queue.poll();
            sr = temp.get(0);
            sc = temp.get(1);
            if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length ||  image[sr][sc] != current){
            }
            else{
                image[sr][sc] = color;
                visited.add(temp);
                temp = new ArrayList<>(Arrays.asList(sr+1, sc));
                if (!visited.contains(temp)){
                    queue.add(temp);
                }
                temp = new ArrayList<>(Arrays.asList(sr-1, sc));
                if (!visited.contains(temp)){
                    queue.add(temp);
                }
                temp = new ArrayList<>(Arrays.asList(sr, sc+1));
                if (!visited.contains(temp)){
                    queue.add(temp);
                }
                temp = new ArrayList<>(Arrays.asList(sr, sc-1));
                if (!visited.contains(temp)){
                    queue.add(temp);
                }
            }
        }
        return image;
    }
}