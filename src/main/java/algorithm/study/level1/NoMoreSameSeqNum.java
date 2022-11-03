package algorithm.study.level1;


import java.util.Stack;

public class NoMoreSameSeqNum {
    /*
    https://school.programmers.co.kr/learn/courses/30/lessons/12906
     */
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()){
                stack.push(arr[i]);
                continue;
            }
            if (stack.peek() != arr[i]) {
                stack.push(arr[i]);
            }
        }
        int size = stack.size();
        int[] resultArr = new int[size];
        for (int i = 0; i < size; i++) {
            resultArr[size - 1 - i] = stack.pop();
        }

        return resultArr;
    }

}

