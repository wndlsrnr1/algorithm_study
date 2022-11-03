package algorithm.study.level1;

public class Budget {
    static int max = 0;

    void dfs(int[] d, int budget, int index, boolean[] marked, int stackDepth){

        if (budget < d[index]){
            return;
        }

        if (budget >= d[index]) {
            marked[index] = true;
            budget -= d[index];
        }

        int count = 0;
        for (int i = 0; i < marked.length; i++) {
            if (marked[i]){
                count++;
            }
        }
        if (count > max) {
            max = count;
        }

        //인접 노드 탐색.
        for (int i = 0; i < d.length; i++) {
            if (index == i){
                continue;
            }
            if (marked[i] == false){
                dfs(d, budget, i, marked, stackDepth + 1);
            }
        }

        marked[index] = false;

    }

    int getMax(int[] d, int budget){
        boolean[] marked = new boolean[d.length];
        dfs(d, budget,0, marked, 1);
        return max;
    }



    public int solution(int[] d, int budget) {
        boolean[] booleans = new boolean[d.length];
        int max = getMax(d, budget);
        return max;
    }
}
