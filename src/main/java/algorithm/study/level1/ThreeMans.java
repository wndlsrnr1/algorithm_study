package algorithm.study.level1;

public class ThreeMans {
    /*
    https://school.programmers.co.kr/learn/courses/30/lessons/131705
    한국중학교에 다니는 학생들은 각자 정수 번호를 갖고 있습니다.
    이 학교 학생 3명의 정수 번호를 더했을 때 0이 되면
    3명의 학생은 삼총사라고 합니다.
    예를 들어, 5명의 학생이 있고,
    각각의 정수 번호가 순서대로 -2, 3, 0, 2, -5일 때,
    첫 번째, 세 번째, 네 번째 학생의 정수 번호를 더하면 0이므로
    세 학생은 삼총사입니다.
    또한, 두 번째, 네 번째, 다섯 번째 학생의 정수 번호를 더해도 0이므로
    세 학생도 삼총사입니다.
    따라서 이 경우 한국중학교에서는 두 가지 방법으로 삼총사를 만들 수 있습니다.

    한국중학교 학생들의 번호를 나타내는 정수 배열 number가 매개변수로 주어질 때,
    학생들 중 삼총사를 만들 수 있는 방법의 수를 return 하도록
    solution 함수를 완성하세요.


     */
    static int max = 0;

    int getResult(int[] arr) {
        boolean[] checked = new boolean[arr.length];
        int index = 0;
        int count = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            dfs2(arr, checked, i, count, sum);
        }
        return max;
    }

    public void dfs(int[] arr, boolean[] checked, int index, int count, int sum) {
        int N = 4;

        if (count > N) {
            return;
        }

        if (count > 0) {
            sum += arr[index];
        }

        for (int i = 0; i < arr.length; i++) {
            if (!checked[i]) {
                checked[i] = true;
                dfs(arr, checked, i, count + 1, sum);
                checked[i] = false;
            }
        }
    }

    public void dfs2(int[] arr, boolean[] checked, int index, int count, int sum) {
        int N = 2;

        if (index > arr.length - 1) {
            return;
        }
        if (index >= 0) {
            sum += arr[index];
        }
        if (count == N) {
            if (sum == 0) {
                max += 1;
            }
            return;
        }


        for (int i = index; i < arr.length; i++) {
            dfs2(arr, checked, i + 1, count + 1, sum);
        }
    }

    public int solution(int[] number) {

        int answer = getResult(number);
        return answer;
    }
}
