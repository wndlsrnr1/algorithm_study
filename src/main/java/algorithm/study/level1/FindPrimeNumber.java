package algorithm.study.level1;

public class FindPrimeNumber {
    /*
    https://school.programmers.co.kr/learn/courses/30/lessons/12977

     */
    static int count;

    int getResult(int[] nums) {
        /*
        0번 노드 부터 시작해서 dfs 탐색
        depth: 스택 깊이
        index: 노드 번호
        sum: 합
         */
        for (int i = 0; i < nums.length - 1; i++) {
            dfs(nums, i, 1, 0);
        }
        return count;
    }

    boolean isPrime(int n) {
        for (int j = 2; j < n; j++) {
            if (n % j == 0) {
                return false;
            }
        }
        return true;
    }

    //depth 조심. 1부터 시작하기
    //for문 안에 index 값 넣기 조심.
    /*
    depth: 스택 깊이
    index: 노드 번호
    sum: 합
    dfs index 번째 root노드로 하여 탐색하는 탐수
    */
    void dfs(int[] nums, int index, int depth, int sum) {
        //depth가 0일때 초기화 근데 안해도 될듯
        if (depth == 0) {
            sum = 0;
        }

        //노드가 없으면 return
        if (index > nums.length - 1) {
            return;
        }

        //노드 index번째 노드 방문할때 마다 더해줌
        sum += nums[index];

        //depth가 3이 되었을때 즉 3번째 실행 시 3번 고른 경우
        if (depth > 2) {
            if (isPrime(sum)) {
                //static으로 선언한 max ++ 함.
                count++;
                return;
            }
            return;
        }

        //root node가 index인 인접 노드 탐색
        for (int i = index; i < nums.length; i++) {
            dfs(nums, i + 1, depth + 1, sum);
        }
    }


    public int solution(int[] nums) {
        int result = getResult(nums);
        return result;
    }
}
