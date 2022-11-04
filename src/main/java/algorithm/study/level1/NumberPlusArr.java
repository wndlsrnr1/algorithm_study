package algorithm.study.level1;
import java.util.*;
public class NumberPlusArr {
    /*
    https://school.programmers.co.kr/learn/courses/30/lessons/68644
    정수 배열 numbers가 주어집니다. numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를 배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.

    1. 더해서 우선순위 큐에 넣기 (다시 정렬할 것이므로)
    2. 모든 수를 더해야 하므로 그리드 이용 n제곱
    3. poll로 배열 만듦. n
     */
    public int[] solution(int[] numbers) {
        Queue<Integer> queue = new PriorityQueue<Integer>();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int number = numbers[i] + numbers[j];
                if (!queue.contains(number)){
                    queue.add(number);
                }
            }
        }

        int[] answer = new int[queue.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = queue.poll();
        }
        return answer;
    }


}
