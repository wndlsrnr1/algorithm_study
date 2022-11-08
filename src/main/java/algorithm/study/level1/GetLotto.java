package algorithm.study.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetLotto {
    /**
     *
     * @param lottos
     * @return
     * https://school.programmers.co.kr/learn/courses/30/lessons/77484
     */
    private int countZero(int[] lottos) {
        int zeroCount = 0;

        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] != 0) {
                return zeroCount;
            } else {
                zeroCount++;
            }
        }
        if (zeroCount == 0) {
            return -1;
        } else {
            return zeroCount;
        }
    }

    private List<Integer> removeDuplication(int[] lottos) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            //속해 있는가
            boolean flag = true;
            for (int j = 0; j < lottos.length; j++) {
                if (lottos[j] == i) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                integerList.add(i);
            }
        }
        return integerList;
    }

    void getResult(int[] lottos, int[] win_nums) {
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        //count zero
        int zeroLength = countZero(lottos);
        int count = 0;
        if (zeroLength == 0) {
            for (int i = 0; i < lottos.length; i++) {
                for (int j = 0; j < win_nums.length; j++) {
                    if (lottos[i] == win_nums[j]){
                        count++;
                    }
                }
            }
            if (min == 0){
                min = count;
            }
            if (min > count){
                min = count;
            }
            if (max < count){
                max = count;
            }
            return;
        }

        List<Integer> removedLottoNums = removeDuplication(lottos);
        List<int[]> intArrList = new ArrayList<>();
        for (int i = 0; i < removedLottoNums.size() - 1; i++) {
            int startNode = removedLottoNums.get(i);
            dfs(lottos, removedLottoNums, win_nums, intArrList, i + 1, 0, zeroLength);
            //dfs();
        }
//        System.out.println("max = " + max);
//        System.out.println("min = " + min);
    }

    /*
    깊이 zero의 길이, 시작 노드 = 노드 개수 중복되지 않은 나머지 노드, 깊이 = list의 인덱스, 결과 담을 배열 arr
     */

    int min = 0;
    int max = 0;
    void dfs(int[] lottos, List<Integer> removedLottoNums, int[] winNums, List<int[]> intArrList, int startNode, int depth, int totalDepth) {
        if (startNode > removedLottoNums.size() - 1) {
            return;
        }
        if (depth > totalDepth-1) {
            int count = 0;
            for (int i = 0; i < lottos.length; i++) {
                for (int j = 0; j < winNums.length; j++) {
                    if (lottos[i] == winNums[j]){
                        count++;
                    }
                }
            }
            if (min == 0){
                min = count;
            }
            if (min > count){
                min = count;
            }
            if (max < count){
                max = count;
            }
            return;
        }

        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == removedLottoNums.get(startNode)) {
                return;
            }
        }

        lottos[depth] = removedLottoNums.get(startNode);


        for (int i = startNode; i < removedLottoNums.size(); i++) {
            Integer nodeValue = removedLottoNums.get(i);
            dfs(lottos, removedLottoNums, winNums, intArrList, i + 1, depth + 1, totalDepth);

        }
    }


    public int[] solution(int[] lottos, int[] win_nums) {
        this.max = 0;
        this.min = 0;
        getResult(lottos, win_nums);
        int[] correct = {6, 6, 5, 4, 3, 2, 1};
        int[] answer = {correct[this.max], correct[this.min]};
        return answer;
    }
}
